package com.javakc.pms.dispord.client;

import com.javakc.commonutils.api.APICODE;
import com.javakc.pms.dispord.entity.DispOrdRls;
import org.springframework.stereotype.Component;

/**
 * @program: javakc-parent
 * @Description: pms熔断器实现类
 * @Version： 1.0
 * @Author: zhao yun long
 * @date: 2020/12/2 12:50:56
 */
@Component
public class MesFeignClient implements MesClient {

    @Override
    public APICODE savePmsDispOrdRls(DispOrdRls dispOrdRls) {
        return APICODE.ERROR().message("MES 服务调用失败 -- 下达");
    }

}
