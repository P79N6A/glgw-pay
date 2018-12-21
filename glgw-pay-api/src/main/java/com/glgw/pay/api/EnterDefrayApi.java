package com.glgw.pay.api;

import com.glgw.pay.request.BatchDefrayRequest;
import com.glgw.pay.response.EtDefrayResponse;
import com.glgw.pay.response.GlgwResponse;

/**
 * 代付
 */
public interface EnterDefrayApi {

    /**
     * 批量代付
     */
    public GlgwResponse<EtDefrayResponse> defray(BatchDefrayRequest request) throws Exception;

}
