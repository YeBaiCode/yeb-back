package com.xxxx.server.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xxxx.server.pojo.ResponseBean;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

/**
 * @author yebai
 * @version V1.0
 * @Package com.xxxx.server.config.security
 * @Description 当未登录或者token失效时访问接口时 自定义的返回结果
 * @date 2021/5/30 11:37
 * @ClassName RestAuthorizationEntryPoint
 */
@Component
public class RestAuthorizationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException e) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        ResponseBean error = ResponseBean.error("权限不足，请联系管理员!");
        error.setCode(401);
        writer.write(new ObjectMapper().writeValueAsString(error));
        writer.flush();
        writer.close();
        HashSet<String> strings = new HashSet<>();
    }
}
