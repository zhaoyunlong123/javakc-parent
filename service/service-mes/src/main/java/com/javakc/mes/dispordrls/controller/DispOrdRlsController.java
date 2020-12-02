package com.javakc.mes.dispordrls.controller;

import com.javakc.commonutils.api.APICODE;
import com.javakc.mes.dispordrls.entity.DispOrdRls;
import com.javakc.mes.dispordrls.service.DispOrdRlsService;
import com.javakc.mes.dispordrls.vo.DispOrdRlsQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: javakc-parent
 * @Description: 生产执行系统表现层
 * @Version： 1.0
 * @Author: zhao yun long
 * @date: 2020/12/1 20:42:42
 */
@RestController
@RequestMapping("/mes/dispordrls")
@Api(value = "调度指令管理")
public class DispOrdRlsController {

    @Autowired
    private DispOrdRlsService dispOrdRlsService;

    @PostMapping("{PageNum}/{PageSize}")
    @ApiOperation("带条件的分页查询 -- 调度指令管理")
    public APICODE findPageDispOrdRls(@RequestBody(required = false) DispOrdRlsQuery dispOrdRlsQuery, @PathVariable("PageNum") int PageNum, @PathVariable("PageSize") int PageSize) {
        Page<DispOrdRls> page = dispOrdRlsService.findPageDispOrdRls(dispOrdRlsQuery, PageNum, PageSize);
        // 当前页的集合
        List<DispOrdRls> list = page.getContent();
        // 总条数
        long totalElements = page.getTotalElements();
        return APICODE.ok().data("total", totalElements).data("items", list);
    }

    @GetMapping("{id}")
    @ApiOperation("根据调度指令管理ID获取单条数据 -- 调度指令管理")
    public APICODE view(@PathVariable("id") int id) {
        DispOrdRls dispOrdRls = dispOrdRlsService.getById(id);
        return APICODE.ok().data("dispOrdRls",dispOrdRls);
    }

    @ApiOperation("接收集团下达的指令信息")
    @PostMapping("savePmsDispOrdRls")
    public APICODE savePmsDispOrdRls(@RequestBody DispOrdRls dispOrdRls) {
        dispOrdRlsService.saveOrUpdate(dispOrdRls);
        return APICODE.ok();
    }

}
