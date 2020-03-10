package com.qf.user.service.impl;

import com.qf.base.BaseServiceImpl;
import com.qf.base.IBaseDao;
import com.qf.constant.RedisConstant;
import com.qf.dto.ResultBean;
import com.qf.entity.TUser;
import com.qf.user.api.IUserService;
import com.qf.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author: xiaohe
 * @Date:2020/3/10 22:00
 */
@Component
@Service
public class UserServiceImpl extends BaseServiceImpl<TUser> implements IUserService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public IBaseDao<TUser> getBaseDao() {
        return mapper;
    }


    //注册
    @Override
    public ResultBean regist(String phone, String code, String password) {

        String redisKey = StringUtil.getRedisKey(RedisConstant.REGISTER_PHONE, phone);
        String redisCode = (String) redisTemplate.opsForValue().get(redisKey);
        if(code.equals(redisCode)){
            TUser tUser = new TUser();
            tUser.setPassword();
            tUser.setPhone(phone);
            mapper.insertSelective(user);
            return ResultBean.success("注册成功");
        }

        return ResultBean.error("验证码错误");
    }




}
