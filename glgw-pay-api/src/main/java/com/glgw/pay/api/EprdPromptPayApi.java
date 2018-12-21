package com.glgw.pay.api;

import com.glgw.pay.request.PromptPayAcquirerQueryRequest;
import com.glgw.pay.request.PromptPayAcquirerRequest;
import com.glgw.pay.response.GlgwResponse;
import com.glgw.pay.response.PromptPayAcquirerQueryResponse;
import com.glgw.pay.response.PromptPayAcquirerResponse;

public interface EprdPromptPayApi {

    /**
     * 收银台支付接口
     * @param request
     * @return
     * @throws Exception
     */
    public GlgwResponse<PromptPayAcquirerResponse> getAccountPayAcquirer(PromptPayAcquirerRequest request)throws Exception;


    /**
     * 实时付款订单查询
     * @param request
     * @return
     * @throws Exception
     */
    public GlgwResponse<PromptPayAcquirerQueryResponse> queryPromptPayOrder(PromptPayAcquirerQueryRequest request)throws Exception;
}
