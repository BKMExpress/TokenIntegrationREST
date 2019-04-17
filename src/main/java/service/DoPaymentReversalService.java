package service;

import model.dto.PosInfo;
import model.request.DoPaymentReversalRequest;
import model.response.DoPaymentReversalResponse;
import model.response.InitOtpPaymentResponse;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Date;

/**
 * Created by Akif Hatipoglu on 10.12.2018.
 */
public class DoPaymentReversalService {

    private static String DO_REVERSAL_PAYMENT_TICKETID = "service/doPaymentReversal.do";

    public static DoPaymentReversalResponse callDoReversalService(URI url, RestTemplate rest, DoPaymentReversalRequest request ){
        DoPaymentReversalResponse response = null;

        if ( url != null )
            try {
                HttpEntity<String> entity = UtilService.getEntityForRestTemplate(request);

                response = rest.postForObject(url, entity, DoPaymentReversalResponse.class);

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        return response;

    }

    public static URI getUrlForDoReversal() {
        URI url = null;
        try {
            url = new URI(UtilService.TOKENIZATION_BASE_URL + DO_REVERSAL_PAYMENT_TICKETID);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

        return  url;
    }

    public static DoPaymentReversalRequest createDoReversalByTicketIdRequest(InitOtpPaymentResponse response){
        DoPaymentReversalRequest request =  new DoPaymentReversalRequest();
        request.setUniqueReferans("TRTWFAKHXZONSOY"); // her seferinde belirlenen unique deger
        request.setMerchantId(UtilService.MERCHANT_ID);
        request.setAmount("1,24");
        request.setRequestType("1"); // (1, "İptal"), (2, "İade"), (3, "İade İptal"),(4,"Bağımsız İade"), (5,"Vadeli iade")
        request.setCurrency("949"); // tl islemi ifade eder
        request.setTransactionToken(response.getUniqueReferans()); // inir otp den alınan

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