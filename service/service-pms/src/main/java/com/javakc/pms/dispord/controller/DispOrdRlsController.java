package com.javakc.pms.dispord.controller;

import com.javakc.commonutils.api.APICODE;
import com.javakc.pms.dispord.client.MesClient;
import com.javakc.pms.dispord.entity.DispOrdRls;
import com.javakc.pms.dispord.service.DispOrdRlsService;
import com.javakc.pms.dispord.vo.DispOrdRlsQuery;
import com.javakc.servicebase.hanler.HctfException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @program: javakc-parent
 * @Description: 调度指令表现层
 * @Version： 1.0
 * @Author: zhao yun long
 * @date: 2020/12/1 17:51:35
 */
@RestController
@RequestMapping("/pms/dispordrls")
@Api(value = "调度指令管理")
public class DispOrdRlsController {

    @Autowired
    private DispOrdRlsService dispOrdRlsService;

    @Autowired
    MesClient mesClient;

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

    @ApiOperation("下达集团调度指令")
    @GetMapping("updateRelease/{id}")
    public APICODE updateRelease(@PathVariable("id") int id) {
        DispOrdRls dispOrdRls = dispOrdRlsService.getById(id);
        // 改变为已下达状态
        dispOrdRls.setIsRelease(1);
        dispOrdRls.setReleaseTime(new Date());

        // 调用mes的服务来进行数据的下达
        APICODE apicode = mesClient.savePmsDispOrdRls(dispOrdRls);

        if (apicode.getCode() == 20001) {
            throw new HctfException(20001, apicode.getMessage());
        }


        // 修改
        dispOrdRlsService.saveOrUpdate(dispOrdRls);
        return APICODE.ok();
    }



}
