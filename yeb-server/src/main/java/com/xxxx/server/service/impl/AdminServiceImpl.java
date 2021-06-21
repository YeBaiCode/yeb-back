package com.xxxx.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxxx.server.config.security.JwtTokenUtil;
import com.xxxx.server.pojo.Admin;
import com.xxxx.server.mapper.AdminMapper;
import com.xxxx.server.pojo.Menu;
import com.xxxx.server.pojo.ResponseBean;
import com.xxxx.server.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhoubin
 * @since 2021-05-29
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Resource
    private AdminMapper adminMapper;

    /**
     * 登录之后返回token
     * @param username
     * @param password
     * @param request
     * @return
     */
    @Override
    public ResponseBean login(String username, String password,String code , HttpServletRequest request) {
        String captcha = (String) request.getSession().getAttribute("captcha");
        // equalsIgnoreCase忽略大小写
        if (StringUtils.isEmpty(code)||!captcha.equalsIgnoreCase(code)){
            return ResponseBean.error("验证码输入错误，请重新输入！");
        }

        // 登录
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (null==userDetails || !passwordEncoder.matches(password,userDetails.getPassword())) {
            return ResponseBean.error("用户名或密码不正确");
        }
        if (!userDetails.isEnabled()) {
            return ResponseBean.error("账号被禁用,请联系管理员");
        }

        // 更新security登录用户对象
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        // 生成token
        String token = jwtTokenUtil.generateToken(userDetails);
        HashMap<String, Object> map = new HashMap<>();
        map.put("token",token);
        map.put("tokenHead",tokenHead);
        return ResponseBean.success("登录成功",map);
    }

    /**
     * 根据用户名获取用户
     * @param name
     * @return
     */
    @Override
    public Admin getAdminByUserName(String name) {
        return adminMapper.selectOne(new QueryWrapper<Admin>().eq("username",name).eq("enabled",true));
    }

}
