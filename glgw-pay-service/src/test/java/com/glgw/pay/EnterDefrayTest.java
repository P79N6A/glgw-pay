package com.glgw.pay;


import com.glgw.pay.request.BatchDefrayRequest;
import com.glgw.pay.response.BatchDefrayRequestItem;
import com.glgw.pay.response.EtDefrayResponse;
import com.glgw.pay.response.GlgwResponse;
import com.glgw.pay.service.EnterDefrayServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:spring/applicationContext.xml"})
public class EnterDefrayTest {

    private static final Logger logger = LogManager.getLogger(EnterDefrayTest.class);


    @Autowired
    private EnterDefrayServiceImpl enterDefrayService;


    /**
     * 批量代付接口 (已调通)
     */
    @Test
    public void testDefray() {
        String bizTradeNo = "DD" + System.currentTimeMillis();
        long amount = 100000L;

        List<BatchDefrayRequestItem> itemList = new ArrayList<BatchDefrayRequestItem>();
        BatchDefrayRequestItem item = new BatchDefrayRequestItem();
        item.setBizTradeNo(bizTradeNo);//明细订单号
        item.setMerCustomerId("hgl_test_jropen");
        item.setTadType("102");//代付类型（101代付到余额，102代付到卡，103代付到小金库）
        item.setTradeAmount(amount);//明细金额
        item.setTradeSubject("奖金"); //交易描述
        item.setRemark("发奖金");   //请求备注
        item.setToPersonal("PER");
        item.setBankCode("CMB");//银行代码（代付到卡）
        item.setBankAccountNo("6225880150357581");//银行账号（代付到卡）
        item.setBankAccountName("张成林");//银行账户名称（代付到卡）
        item.setBankName("招商银行");//银行名称（代付到卡）

        item.setName("zcljzu666");//用户名（代付到卡）
        item.setCardType("ID");
        item.setIdNumber("411522198607130610");  //证件号（代付到卡）
        item.setMobileNo("13051349886");
        itemList.add(item);

        BatchDefrayRequest request = new BatchDefrayRequest();
        request.setBizTradeNo(bizTradeNo);//商户订单号（唯一）
        request.setAmount(amount); //总金额
        request.setTotalNum(itemList.size());
        request.setList(itemList);

        try {
            GlgwResponse<EtDefrayResponse> response = enterDefrayService.defray(request);
            logger.info("response:{}", response);
        } catch (Exception e) {
            logger.error("{}", e);
        }
    }
}
