package service;

import model.request.CheckOtpRequest;
import model.response.CheckOtpResponse;
import model.response.InitOtpPaymentResponse;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Created by myalcinsoy on 05-Jun-18.
 */
public class CheckOtpService {

    private static String CHECK_OTP = "/otp/checkOtp.do";

    public static CheckOtpResponse callCheckOtpService(URI url, RestTemplate rest, CheckOtpRequest request ){
        CheckOtpResponse response = null;

        if ( url != null )
            try {
                HttpEntity<String> entity = UtilService.getEntityForRestTemplate(request);

                response = rest.postForObject(url, entity, CheckOtpResponse.class);

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        return response;

    }

    public static URI getUrlForCheckOtpPayment() {
        URI url = null;
        try {
            url = new URI(UtilService.TOKENIZATION_BASE_URL + CHECK_OTP);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

        return  url;
    }

    public static CheckOtpRequest createCheckOtpRequest(InitOtpPaymentResponse response){
        CheckOtpRequest request =  new CheckOtpRequest();
        request.setTicketId(response.getTicketId());
        request.setOtpId(response.getOtpInfo().getOtpId());
        request.setOtpCode("123456"); // Ivr ak???nda mü?teriden al?nan OTP Kodu, Test offline sistemde 123456 ile do?rulama yap?labiliyor.

        return request;
    }

}
