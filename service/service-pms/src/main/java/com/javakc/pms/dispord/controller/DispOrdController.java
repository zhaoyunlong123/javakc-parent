package com.javakc.pms.dispord.controller;

import com.javakc.commonutils.api.APICODE;
import com.javakc.pms.dispord.entity.DispOrd;
import com.javakc.pms.dispord.service.DispOrdService;
import com.javakc.pms.dispord.vo.DispOrdQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: javakc-parent
 * @Description: pms
 * @Author: zhao yun long
 * @date: 2020/11/23 20:52
 */
@Api(value = "调度指令库管理")
@RestController
@RequestMapping("/pms/dispord")
@CrossOrigin
public class DispOrdController {

    @Autowired
    private DispOrdService dispOrdService;

    @ApiOperation(value = "查询所有指令库")
    @GetMapping
    public APICODE findAll() {
        List<DispOrd> list = dispOrdService.findAll();
//        int i = 1/0;
        return APICODE.ok().data("items",list);
    }

    @ApiOperation(value = "根据条件进行分页查询 -- 调度指令库")
    @PostMapping("{pageNum}/{pageSize}")
    public APICODE findPageDispOrd(@RequestBody(required = false) DispOrdQuery dispOrdQuery, @PathVariable(value = "pageNum") int pageNum, @PathVariable(value = "pageSize") int pageSize) {
        Page<DispOrd> page = dispOrdService.findPageDispOrd(dispOrdQuery, pageNum, pageSize);
        // 当前页的数据集合
        List<DispOrd> list = page.getContent();
        // 总条数
        long totalElements = page.getTotalElements();
        return APICODE.ok().data("total", totalElements).data("items", list);
    }

    @ApiOperation("新增 -- 调度指令库")
    @PostMapping("createDispOrd")
    public APICODE createDispOrd(@RequestBody DispOrd dispOrd){
        dispOrdService.saveOrUpdate(dispOrd);
        return APICODE.ok();
    }

    @ApiOperation("根据id获取数据 -- 调度指令库")
    @GetMapping("{id}")
    public APICODE getDispOrd(@PathVariable(name = "id") int id){
        DispOrd dispOrd = dispOrdService.getById(id);
        return APICODE.ok().data("dispOrd",dispOrd);
    }

    @ApiOperation("修改 -- 调度指令库")
    @PutMapping("updateDispOrd")
    public APICODE updateDispOrd(@RequestBody DispOrd dispOrd){
        dispOrdService.saveOrUpdate(dispOrd);
        return APICODE.ok();
    }

    @ApiOperation("删除 -- 调度指令库")
    @DeleteMapping("{id}")
    public APICODE deleteDispOrd(@PathVariable(name = "id") int id){
        dispOrdService.removeById(id);
        return APICODE.ok();
    }

}
