package service;


import model.dto.PosInfo;
import model.request.DoOtpPaymentRequest;
import model.response.DoOtpPaymentResponse;
import model.response.InitOtpPaymentResponse;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Date;

/**
 * Created by myalcinsoy on 05-Jun-18.
 */
public class DoOtpPaymentService {

    private static String DO_OTP_PAYMENT_TICKETID = "service/doPaymentByTicketId.do";

    public static DoOtpPaymentResponse callDoOtpPaymentService(URI url, RestTemplate rest, DoOtpPaymentRequest request ){
        DoOtpPaymentResponse response = null;

        if ( url != null )
            try {
                HttpEntity<String> entity = UtilService.getEntityForRestTemplate(request);

                response = rest.postForObject(url, entity, DoOtpPaymentResponse.class);

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        return response;

    }

    public static URI getUrlForDoOtpPayment() {
        URI url = null;
        try {
            url = new URI(UtilService.TOKENIZATION_BASE_URL + DO_OTP_PAYMENT_TICKETID);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

        return  url;
    }

    public static DoOtpPaymentRequest createDoPaymentByTicketIdRequest(InitOtpPaymentResponse response){
        DoOtpPaymentRequest request =  new DoOtpPaymentRequest();
        request.setUniqueReferans("TRTWFAKHXZONSOY");
        request.setInitOtpUniqueReferans(response.getUniqueReferans());
        request.setMerchantId(UtilService.MERCHANT_ID);
        request.setTicketId(response.getTicketId());
        request.setOrderId("123abc");
        request.setNumberOfInst("1");
        request.setBankMerchantId("321534");
        PosInfo posInfo = new PosInfo();
        posInfo.setUserId("akapi");
        posInfo.setPassword("TEST1234");
        posInfo.setUrl("http://srvirt01:7200/akbank");
        posInfo.setExtra( "{\"ClientId\":\"100111222\", \"storekey\":\"TEST1234\"}");
        request.setPosInfo(posInfo);
        request.setTs("20180528");
        request.setSign(UtilService.getDateAsSignTsString(new Date()));

        return request;
    }
}
