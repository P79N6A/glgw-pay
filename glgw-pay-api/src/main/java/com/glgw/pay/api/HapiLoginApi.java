package com.glgw.pay.api;

import com.glgw.pay.request.HapiLoginRequest;

import javax.servlet.http.HttpServletResponse;

public interface HapiLoginApi {

    //H5组件企业调用
    public void enterLoginIn(HapiLoginRequest request, HttpServletResponse httpServletResponse) throws Exception;


}
