package com.javakc.servicebase.hanler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: javakc-parent
 * @Description: 异常类
 * @Author: zhao yun long
 * @date: 2020/11/23 23:17
 */
@Data
@AllArgsConstructor // ## 使用后添加一个构造函数，该构造函数含有所有已声明字段属性参数
@NoArgsConstructor // ## 使用后创建一个无参构造函数
public class HctfException extends RuntimeException {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 信息
     */
    private String msg;

}
