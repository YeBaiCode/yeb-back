package com.xxxx.server.controller;


import com.xxxx.server.pojo.Joblevel;
import com.xxxx.server.pojo.ResponseBean;
import com.xxxx.server.service.IJoblevelService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhoubin
 * @since 2021-05-29
 */
@RestController
@RequestMapping("/system/basic/joblevel")
public class JoblevelController {

    @Resource
    private IJoblevelService joblevelService;

    @ApiOperation(value = "获取所有职称信息")
    @GetMapping("/")
    public List<Joblevel> getAllJoblevels(){
        return joblevelService.list();
    }

    @ApiOperation(value = "添加职称信息")
    @PostMapping("/")
    public ResponseBean addJoblevel(@RequestBody Joblevel position){
        position.setCreateDate(LocalDateTime.now());
        if (joblevelService.save(position)){
            return ResponseBean.success("添加成功!");
        }
        return ResponseBean.error("添加失败!");
    }

    @ApiOperation(value = "更新职称信息")
    @PutMapping("/")
    public ResponseBean updateJoblevel(@RequestBody Joblevel position){
        if (joblevelService.updateById(position)){
            return ResponseBean.success("更新成功!");
        }
        return ResponseBean.error("更新失败!");
    }

    @ApiOperation(value = "删除职称信息")
    @DeleteMapping("/{id}")
    public ResponseBean deleteJoblevel(@PathVariable Integer id){
        if (joblevelService.removeById(id)){
            return ResponseBean.success("删除成功!");
        }
        return ResponseBean.error("删除失败!");
    }

    @ApiOperation(value = "批量删除职称信息")
    @DeleteMapping("/")
    public ResponseBean deleteJoblevels(@PathVariable Integer[] ids){
        if (joblevelService.removeByIds(Arrays.asList(ids))){
            return ResponseBean.success("删除成功!");
        }
        return ResponseBean.error("删除失败!");
    }

}
