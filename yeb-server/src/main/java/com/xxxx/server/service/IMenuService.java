package com.xxxx.server.service;

import com.xxxx.server.pojo.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoubin
 * @since 2021-05-29
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 根据用户id查询菜单列表
     * @author yebai
     * @date 2021/6/21 10:10
     */
    List<Menu> getMenusByAdminId();

    /**
     * 根据角色获取菜单列表
     * @author yebai
     * @date 2021/6/21 11:46
     */
    List<Menu> getMenusWithRole();
}
