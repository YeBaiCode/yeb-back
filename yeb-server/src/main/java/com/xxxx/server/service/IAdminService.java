package com.xxxx.server.service;

import com.xxxx.server.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.pojo.Menu;
import com.xxxx.server.pojo.ResponseBean;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoubin
 * @since 2021-05-29
 */
public interface IAdminService extends IService<Admin> {

    /**
     * 登录之后返回token
     * @param username
     * @param password
     * @param request
     * @return
     */
    ResponseBean login(String username, String password, String code,HttpServletRequest request);

    /**
     * 根据用户名获取用户
     * @param name
     * @return
     */
    Admin getAdminByUserName(String name);

    /**
     *
     * @return
     */
    List<Menu> getMenusByAdminId();
}
