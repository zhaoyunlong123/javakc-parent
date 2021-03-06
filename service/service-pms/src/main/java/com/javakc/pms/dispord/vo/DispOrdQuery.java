package com.javakc.pms.dispord.vo;

import lombok.Data;

import java.util.Date;

/**
 * @program: javakc-parent
 * @Description: 封装查询条件
 * @Author: zhao yun long
 * @date: 2020/11/23 23:34
 */
@Data
public class DispOrdQuery {

    private String orderName;

    private String beginDate;

    private String endDate;

}
