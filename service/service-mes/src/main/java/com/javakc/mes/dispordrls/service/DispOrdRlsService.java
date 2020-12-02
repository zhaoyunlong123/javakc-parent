package com.javakc.mes.dispordrls.service;

import com.javakc.commonutils.jpa.base.service.BaseService;
import com.javakc.commonutils.jpa.dynamic.SimpleSpecificationBuilder;
import com.javakc.mes.dispordrls.dao.DispOrdRlsDao;
import com.javakc.mes.dispordrls.entity.DispOrdRls;
import com.javakc.mes.dispordrls.vo.DispOrdRlsQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @program: javakc-parent
 * @Description: 生产执行系统逻辑层
 * @Version： 1.0
 * @Author: zhao yun long
 * @date: 2020/12/1 20:45:37
 */
@Service
public class DispOrdRlsService extends BaseService<DispOrdRlsDao, DispOrdRls> {

    /**
     * 带条件的分页查询 -- 调度指令管理
     * @param dispOrdRlsQuery
     * @param PageNum
     * @param PageSize
     * @return
     */
    public Page<DispOrdRls> findPageDispOrdRls(DispOrdRlsQuery dispOrdRlsQuery, int PageNum, int PageSize) {
        // new一个封装查询条件的对象
        SimpleSpecificationBuilder<DispOrdRls> simpleSpecificationBuilder = new SimpleSpecificationBuilder<>();
        // 调用数据层findAll -- 动态条件查询带分页
        Page page = dao.findAll(simpleSpecificationBuilder.getSpecification(), PageRequest.of(PageNum - 1, PageSize));
        // 返回查询结果
        return page;

    }
}

