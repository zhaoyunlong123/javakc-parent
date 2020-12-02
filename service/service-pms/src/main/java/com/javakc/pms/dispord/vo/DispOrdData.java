package com.javakc.pms.dispord.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @program: javakc-parent
 * @Description: 设置表头和添加的数据字段
 * @Version： 1.0
 * @Author: zhao yun long
 * @date: 2020/11/29 11:33:12
 */
@Data
public class DispOrdData {

    @ExcelProperty(value = "指令名称", index = 0)
    private String orderName;

    @ExcelProperty(value = "指令类型", index = 1)
    private int specType;

    @ExcelProperty(value = "优先级", index = 2)
    private int priority;

    @ExcelProperty(value = "指令描述", index = 3)
    private String orderDesc;

}
