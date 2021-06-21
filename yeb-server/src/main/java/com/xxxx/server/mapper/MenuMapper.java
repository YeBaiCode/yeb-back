package com.xxxx.server.mapper;

import com.xxxx.server.pojo.Admin;
import com.xxxx.server.pojo.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhoubin
 * @since 2021-05-29
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> getMenusByAdminId(Integer adminId);

    /**
     * 根据角色获取菜单列表
     * @author yebai
     * @date 2021/6/21 11:46
     */
    List<Menu> getMenusWithRole();
}
