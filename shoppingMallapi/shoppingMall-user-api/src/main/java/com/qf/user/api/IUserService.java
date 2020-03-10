package com.qf.user.api;

import com.qf.base.IBaseService;
import com.qf.dto.ResultBean;
import com.qf.entity.TUser;

public interface IUserService extends IBaseService<TUser> {

    ResultBean regist(String phone, String code, String password);

}
