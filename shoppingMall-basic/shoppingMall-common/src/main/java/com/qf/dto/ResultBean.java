package com.qf.dto;

import java.io.Serializable;

/**
 * @Author: xiaohe
 * @Date:2020/3/10 21:22
 */
public class ResultBean implements Serializable {

    private int code;

    private Object data;

    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ResultBean success(){
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(0);
        resultBean.setData(null);
        resultBean.setMessage("success");
        return  resultBean;
    }


    public static ResultBean success(String message){
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(0);
        resultBean.setData(null);
        resultBean.setMessage(message);
        return  resultBean;
    }



    public static ResultBean success(Object data){
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(0);
        resultBean.setData(data);
        resultBean.setMessage("success");
        return  resultBean;

    }


    public static ResultBean success(Object data,String message){
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(0);
        resultBean.setData(data);
        resultBean.setMessage(message);
        return  resultBean;

    }


    public static ResultBean error(){
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(1);
        resultBean.setData(null);
        resultBean.setMessage("error");
        return  resultBean;

    }




    public static ResultBean error(String message){
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(1);
        resultBean.setData(null);
        resultBean.setMessage(message);
        return  resultBean;

    }

}
