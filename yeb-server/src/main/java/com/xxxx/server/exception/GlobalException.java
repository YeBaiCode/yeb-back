package com.xxxx.server.exception;

import com.xxxx.server.pojo.ResponseBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理
 * @author yebai
 * @date 2021年06月24日 17:35
 */
@RestControllerAdvice
public class GlobalException {

    /*数据库异常处理*/
    @ExceptionHandler(SQLException.class)
    public ResponseBean mysqlException(SQLException e){
        if (e instanceof SQLIntegrityConstraintViolationException){
            return ResponseBean.error("该数据有关联数据，操作失败!");
        }
        return ResponseBean.error("数据库异常，操作失败!");
    }
}
