package com.qf.sms.service.handler;

import com.qf.constant.RabbitConstant;
import com.qf.constant.RedisConstant;
import com.qf.sms.service.util.SmsUtil;
import com.qf.util.StringUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * @Author: xiaohe
 * @Date:2020/3/10 20:36
 */
@Component
public class SmsHnadler {

    @Value("${sms.account}")
    private String account;

    @Value("${sms.password}")
    private String password;

    @Value("${sms.veryCode}")
    private String veryCode;

    @Value("$sms.http_url")
    private String http_url;

    @Value("${sms.tplId}")
    private String tplId;


    @Autowired
    private RedisTemplate redisTemplate;

    @RabbitListener(queues = RabbitConstant.SMS_SEND_QUEUE)
    public void proccess(String phone) {
        //4位数随机验证码
        String code =String.valueOf((int)(Math.random() * 9 +1)*1000);
        String content = "@1@="+code;
        SmsUtil.account = account;
        SmsUtil.password = password;
        SmsUtil.veryCode = veryCode;
        SmsUtil.http_url  =http_url;
        SmsUtil.sendTplSms(phone,tplId,content);


        String redisKey = StringUtil.getRedisKey(RedisConstant.REGISTER_PHONE, phone);
        redisTemplate.opsForValue().set(redisKey,code,1, TimeUnit.MINUTES);
    }

}
