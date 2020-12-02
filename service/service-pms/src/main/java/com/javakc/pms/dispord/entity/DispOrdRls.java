package com.javakc.pms.dispord.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * @program: javakc-parent
 * @Description: 调度指令实体类
 * @Version： 1.0
 * @Author: zhao yun long
 * @date: 2020/12/1 17:53:59
 */
@Getter
@Setter
@Entity
@Table(name = "pms_disp_ord_rls")
public class DispOrdRls {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(generator = "generator_uuid")
//    @GenericGenerator(name = "generator_uuid", strategy = "uuid")
//    @ApiModelProperty(value = "主键,采用hibernate的uuid生成32位字符串")
    @ApiModelProperty(value = "主键id")
    private int id;

    @Column(name = "order_no")
    private String orderNo;

    @Column(name = "order_name")
    private String orderName;

    @Column(name = "spec_type")
    private int specType;

    @Column(name = "priority")
    private int priority;

    @Column(name = "order_desc")
    private String orderDesc;

    @Column(name = "transfer")
    private String transfer;

    @Column(name = "transmitter")
    private String transmitter;

    @Column(name = "release_time")
    private Date releaseTime;

    @Column(name = "is_release")
    private int isRelease;

    @Column(name = "order_status")
    private int orderStatus;

    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "gmt_create", nullable = false, updatable = false)
    private Date gmtCreate;

    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "gmt_modified", nullable = false, insertable = false)
    private Date gmtModified;

}