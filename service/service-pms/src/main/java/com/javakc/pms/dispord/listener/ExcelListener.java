package com.javakc.pms.dispord.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.javakc.pms.dispord.entity.DispOrd;
import com.javakc.pms.dispord.service.DispOrdService;
import com.javakc.pms.dispord.vo.DispOrdData;
import org.springframework.beans.BeanUtils;

/**
 * @program: javakc-parent
 * @Description: 创建读取操作的监听器
 * @Version： 1.0
 * @Author: zhao yun long
 * @date: 2020/11/29 21:38:10
 */
public class ExcelListener extends AnalysisEventListener<DispOrdData> {

    DispOrdService dispOrdService;

    public ExcelListener(DispOrdService dispOrdService) {
        this.dispOrdService = dispOrdService;
    }

    /**
     * 一行行读取数据是执行的方法
     *
     * @param dispOrdData
     * @param analysisContext
     */
    @Override
    public void invoke(DispOrdData dispOrdData, AnalysisContext analysisContext) {
        // 创建一个空白的尸实体
        DispOrd dispOrd = new DispOrd();
        // 复制数据
        BeanUtils.copyProperties(dispOrdData, dispOrd);
        // 保存
        dispOrdService.saveOrUpdate(dispOrd);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
