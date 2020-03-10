package com.qf.sso.controller;

import com.qf.constant.RabbitConstant;
import com.qf.dto.ResultBean;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: xiaohe
 * @Date:2020/3/10 21:09
 */
@Controller
@RequestMapping("user")
public class RegisterController {

    @Reference
    private IUserService userService;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @RequestMapping("getCode")
    @ResponseBody
    public ResultBean getCode(String phone){
        rabbitTemplate.convertAndSend(RabbitConstant.SMS_TOPIC_EXCHANGE,"sms.send",phone);
        return ResultBean.success();
    }

    @RequestMapping("register")
    @ResponseBody
    public ResultBean register(String phone,String code,String password){
        return userService.regist(phone,code,password);
    }
}
