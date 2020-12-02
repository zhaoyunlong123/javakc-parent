package com.javakc.pms.dispord.service;

import com.javakc.commonutils.jpa.base.service.BaseService;
import com.javakc.commonutils.jpa.dynamic.SimpleSpecification;
import com.javakc.commonutils.jpa.dynamic.SimpleSpecificationBuilder;
import com.javakc.pms.dispord.dao.DispOrdRlsDao;
import com.javakc.pms.dispord.entity.DispOrdRls;
import com.javakc.pms.dispord.vo.DispOrdRlsQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @program: javakc-parent
 * @Description: 调度指令逻辑层
 * @Version： 1.0
 * @Author: zhao yun long
 * @date: 2020/12/1 17:54:42
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
