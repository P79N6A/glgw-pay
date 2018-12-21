package com.glgw.pay.controller;


import com.glgw.pay.api.HapiLoginApi;
import com.glgw.pay.request.HapiLoginRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("hapiLogin")
public class HapiLoginController {

    private static final Logger logger = LogManager.getLogger(EnterpriseAccountController.class);

    @Autowired
    private HapiLoginApi hapiLoginApi;


    //H5组件企业调用
    @RequestMapping("enterLoginIn")
    public void enterLoginIn(@RequestBody HapiLoginRequest request, HttpServletResponse httpServletResponse) throws Exception {

        try {
            hapiLoginApi.enterLoginIn(request,httpServletResponse);
        } catch (Exception e) {
            logger.error("{}", e);
        }
    }

}
