package service;

import model.request.InitOtpPaymentRequest;
import model.response.InitOtpPaymentResponse;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Created by myalcinsoy on 05-Jun-18.
 */
public class InitOtpPaymentService {

    private static String INIT_OTP_PAYMENT_WITH_CARD_DATA = "service/initOtpPaymentWithCardData.do";

    public static InitOtpPaymentResponse callInitOtpPaymentService(URI url, RestTemplate rest, InitOtpPaymentRequest request ){
        InitOtpPaymentResponse response = null;

        if ( url != null )
            try {
                HttpEntity<String> entity = UtilService.getEntityForRestTemplate(request);

                response = rest.postForObject(url, entity, InitOtpPaymentResponse.class);

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        return response;

    }

    public static URI getUrlForInitOtpPayment() {
        URI url = null;
        try {
            url = new URI(UtilService.TOKENIZATION_BASE_URL + INIT_OTP_PAYMENT_WITH_CARD_DATA);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

        return  url;
    }

    public static InitOtpPaymentRequest createInitOtpPaymentRequest(){
        InitOtpPaymentRequest request =  new InitOtpPaymentRequest();
        request.setUniqueReferans("TRTWFAKHXZONSOV");
        request.setMerchantId(UtilService.MERCHANT_ID);
        request.setCcFirst6Digits("554960");
        request.setCcLast4Digits("1023");
        request.setTckno("12345678911");
        request.setAmount("1,24");
        request.setTs("20180528");
        request.setSign("12123");

        return request;
    }

}
