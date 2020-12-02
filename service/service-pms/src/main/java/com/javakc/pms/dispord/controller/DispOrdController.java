package com.javakc.pms.dispord.controller;

import com.alibaba.excel.EasyExcel;
import com.javakc.commonutils.api.APICODE;
import com.javakc.pms.dispord.entity.DispOrd;
import com.javakc.pms.dispord.listener.ExcelListener;
import com.javakc.pms.dispord.service.DispOrdService;
import com.javakc.pms.dispord.vo.DispOrdData;
import com.javakc.pms.dispord.vo.DispOrdQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: javakc-parent
 * @Description: pms 调度指令库表现层
 * @Author: zhao yun long
 * @date: 2020/11/23 20:52
 */
@Api(value = "调度指令库管理")
@RestController
@RequestMapping("/pms/dispord")
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

    @ApiOperation(value = "导出Excel", notes = "使用Alibaba的EasyExcel进行数据的导出")
    @GetMapping("exportEasyExcel")
    public void exportEasyExcel(HttpServletResponse response) {
        // 查询数据
        List<DispOrd> list = dispOrdService.findAll();

        // 擦黄建导出的集合数据
        List<DispOrdData> exportList = new ArrayList<>();

        // 将实体类的数据导入到API中
        // 循环取出一行行的数据
        for (DispOrd dispOrd : list) {
            // 创建一个空白的数据对象
            DispOrdData dispOrdData = new DispOrdData();
            // 数据复制操作
            BeanUtils.copyProperties(dispOrd,dispOrdData);
            // 放置到集合当中
            exportList.add(dispOrdData);
        }

        // 文件名
        String fileName = "信息";

        try {
            // ## 设置响应信息
            response.reset();
            response.setContentType("application/vnd.ms-excel; charset=utf-8");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8") + ".xlsx");
            // 导出
            EasyExcel.write(response.getOutputStream(),DispOrdData.class).sheet("指令库列表").doWrite(exportList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ApiOperation(value = "导入Excel", notes = "使用Alibaba的EasyExcel进行数据的导入")
    @PostMapping("importEasyExcel")
    public void importEasyExcel(MultipartFile file) {
        try {
            EasyExcel.read(file.getInputStream(), DispOrdData.class, new ExcelListener(dispOrdService)).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ApiOperation(value = "导出Excel", notes = "使用 Apache 的 POI 进行数据的导出")
    @GetMapping("exportExcel")
    public void exportExcel(HttpServletResponse response) {
        dispOrdService.exportExcel(response);
    }

    @ApiOperation(value = "导入Excel", notes = "使用 Apache 的 POI 进行数据的导入")
    @PostMapping("importExcel")
    public void importExcel(MultipartFile file) {
        dispOrdService.importExcel(file);
    }

}
