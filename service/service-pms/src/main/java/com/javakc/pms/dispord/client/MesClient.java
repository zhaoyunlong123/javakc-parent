package com.javakc.pms.dispord.client;

import com.javakc.commonutils.api.APICODE;
import com.javakc.pms.dispord.entity.DispOrdRls;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @program: javakc-parent
 * @Description: 服务调用接口
 * @Version： 1.0
 * @Author: zhao yun long
 * @date: 2020/12/1 23:42:33
 */
@FeignClient(name = "service-mes", fallback = MesFeignClient.class)
@Component
public interface MesClient {

    /**
     * 指定要调用的接口，保证与服务中的接口的一致性，填写全路径
     * 此时调用这个接口中的方法，就相当于调用mes中Controller的方法
     * @param dispOrdRls
     * @return
     */
    @PostMapping("/mes/dispordrls/savePmsDispOrdRls")
    public APICODE savePmsDispOrdRls(@RequestBody DispOrdRls dispOrdRls);


}
