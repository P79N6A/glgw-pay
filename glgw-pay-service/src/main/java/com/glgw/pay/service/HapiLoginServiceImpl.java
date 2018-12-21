package com.glgw.pay.service;


import com.alibaba.fastjson.JSONObject;
import com.glgw.pay.api.HapiLoginApi;
import com.glgw.pay.enums.ComponentCode;
import com.glgw.pay.request.HapiLoginRequest;
import com.jd.jr.jropen.sdk.api.HapiLoginService;
import com.jd.jr.jropen.sdk.model.CommonRequest;
import com.jd.jr.jropen.sdk.model.CommonRequestHeader;
import com.jd.jr.jropen.sdk.model.CommonResponseHeader;
import com.jd.jr.jropen.sdk.model.enter.HapiLoginRequestBody;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
public class HapiLoginServiceImpl extends BaseService implements HapiLoginApi {

    private static final Logger logger = LogManager.getLogger(HapiLoginServiceImpl.class);

    /**
     * H5组件企业调用
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public void enterLoginIn(HapiLoginRequest request, HttpServletResponse httpServletResponse) throws Exception {
        final long reqNum = System.currentTimeMillis();
        logger.info("请求编号:{},H5组件企业调用上送数据：{}", reqNum, request);

        //请求体
        HapiLoginRequestBody body = new HapiLoginRequestBody();
        body.setMerCustomerId(request.getMerCustomerId());
        body.setComponentCode(request.getComponentCode());
        body.setLoginRole("ENTER");
        //余额提现
        if (ComponentCode.BALANCE_EXTRACT.getCode().equals(request.getComponentCode())) {
            body.setExtJson("{ \"orderCode\": \"" + request.getExtJson() +  "}");
        }
        //同意协议
        if (ComponentCode.CLOUD_AGREE.getCode().equals(request.getComponentCode())) {
            body.setExtJson("{ \"merCustomerId\": \"" + request.getExtJson() +  "}");
        }


        //请求头
        CommonRequestHeader header = setCommonRequestHeader(JSONObject.toJSONString(body));

        //请求数据
        CommonRequest<HapiLoginRequestBody> commonRequest = new CommonRequest();
        commonRequest.setRequestHeader(header);
        commonRequest.setRequestBody(body);


        logger.info("请求编号:{},京东上送数据项={}", reqNum, commonRequest);
        HapiLoginService hapiLoginService = new HapiLoginService();
        CommonResponseHeader commonResponse = hapiLoginService.enterLoginIn(commonRequest, httpServletResponse);
        logger.info("请求编号:{},京东返回数据项={}", reqNum, commonResponse);

    }


}
