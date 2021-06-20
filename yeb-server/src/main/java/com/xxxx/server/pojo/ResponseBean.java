package com.xxxx.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yebai
 * @version V1.0
 * @Package com.xxxx.server.pojo
 * @Description
 * @date 2021/5/30 6:53
 * @ClassName RespBean
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBean {
    private long code;
    private String message;
    private Object obj;

    public static ResponseBean success(String message){
        return new ResponseBean(200,message,null);
    }

    public static ResponseBean success(String message, Object obj){
        return new ResponseBean(200,message,obj);
    }

    public static ResponseBean error(String message){
        return new ResponseBean(500,message,null);
    }

    public static ResponseBean error(String message, Object obj){
        return new ResponseBean(500,message,obj);
    }
}
