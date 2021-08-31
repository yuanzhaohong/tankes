package com.tanke.utils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * @Author: jarry
 */
// 确保序列化JSON时，如果是null对象，其key也会消失。
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
// 生成无参构造，确保在RPC调用时，不会出现反序列失败
@NoArgsConstructor
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class ServerResponse<T> implements Serializable {

    private int status;
    private String msg;
    private T data;
    private String errcode;
    private String errmsg;
    private ServerResponse(int status) {
        this.status = status;
    }

    private ServerResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    //  这里存在一个问题，如果构造函数传入的参数列表为(int,String)，那么是调用上面的（int,String），还是这里的（int,T)，毕竟T作为泛型是可以表示String的
    //  答案是调用上面的（int,String)（可以理解为上面的是专业的）。那么有时候data作为T类型传入的就是String啊，岂不是就出问题了。这里会在下方对应的public函数处理
    private ServerResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    //    使之不在JSON序列化结果当中
    @JsonIgnore
    // 可以快速进行成功与否的条件判断
    public boolean isSuccess() {
        return this.status == 200;
    }

    @JsonIgnore
    // 可以快速进行成功与否的条件判断，判断false时，不用加!。囧
    public boolean isFail() {
        return this.status != 200;
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    // 快速构建返回结果
    //    成功时的调用
    public static <T> ServerResponse<T> createBySuccess() {
        return new ServerResponse<T>(200);
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String msg) {
        return new ServerResponse<T>(200, msg);
    }

    public static <T> ServerResponse<T> createBySuccess(T data) {
        return new ServerResponse<T>(200, data);
    }

    public static <T> ServerResponse<T> createBySuccess(String msg, T data) {
        return new ServerResponse<T>(200, msg, data);
    }

    //    失败时的调用
    public static <T> ServerResponse<T> createByError() {
        return new ServerResponse<T>(500, "网络异常");
    }

    public static <T> ServerResponse<T> createByErrorMessage(String errorMessage) {
        return new ServerResponse<T>(500, errorMessage);
    }

    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode, String errorMessage) {
        return new ServerResponse<T>(errorCode, errorMessage);
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
