package com.glgw.pay;


import com.glgw.pay.request.AsyncNotifyMerMessageRequest;
import com.glgw.pay.response.AsyncNotifyMerResponse;
import com.glgw.pay.service.JdAsyncNotifyMessageServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:spring/applicationContext.xml"})
public class JdAsyncNotifyMessageTest {

    private static final Logger logger = LogManager.getLogger(JdAsyncNotifyMessageTest.class);

    @Autowired
    private JdAsyncNotifyMessageServiceImpl jdAsyncNotifyMessageService;


    @Test
    public void testQueryPromptPayOrder() {
        AsyncNotifyMerMessageRequest request = new AsyncNotifyMerMessageRequest();
        request.setReceiveMsg("444444444444");

        try {
            AsyncNotifyMerResponse response = jdAsyncNotifyMessageService.parseMsg(request);
            logger.info("response:{}", response);
        } catch (Exception e) {
            logger.error("{}", e);
        }
    }
}
