import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.request.CheckOtpRequest;
import model.request.DoOtpPaymentRequest;
import model.request.DoPaymentReversalRequest;
import model.request.InitOtpPaymentRequest;
import model.response.CheckOtpResponse;
import model.response.DoOtpPaymentResponse;
import model.response.DoPaymentReversalResponse;
import model.response.InitOtpPaymentResponse;
import org.springframework.web.client.RestTemplate;
import service.CheckOtpService;
import service.DoOtpPaymentService;
import service.DoPaymentReversalService;
import service.InitOtpPaymentService;

import java.net.URI;

/**
 * Created by myalcinsoy on 05-Jun-18.
 */
public class TokenCaller {


     public static void main(String[] args) {

         // kart bilgileri ile ticket alınır
         InitOtpPaymentResponse initOtpPaymentResponse = callInitOtpPaymentService();
         if ( initOtpPaymentResponse.getResultCode() == 0 )
             System.out.println("TICKET ALMA BAŞARILI " + initOtpPaymentResponse.getTicketId() );
         else {
             System.out.println("TICKET ALMA BAŞARISIZ " + initOtpPaymentResponse.getTicketId() + " HATA : " +
                  initOtpPaymentResponse.getResultMsg() );
             return;
         }

         boolean isOtpValidated = false;
         // ivr akışında müşteriden alınan otpCode un doğrulaması yapılır
         int tryCount = initOtpPaymentResponse.getOtpInfo().getAllowedOtpAttempts();
         for ( int i = 0 ; i < tryCount ; i ++ ) {
             CheckOtpResponse checkOtpResponse = callCheckOtpService(initOtpPaymentResponse);
             if (checkOtpResponse.getResultCode() == 0) {
                 System.out.println("OTP DOĞRULAMASI BAŞARILI ");
                 isOtpValidated = true;
                 break;
             }
             System.out.println("OTP DOĞRULAMASI BAŞARISIZ, TEKRAR DENEYİN ");
         }

         if ( ! isOtpValidated ){
             System.out.println("DOĞRULAMA YAPILAMADI, İŞLEMİNİZİ GERÇEKLEŞTİREMİYORUZ");
             return;
         }
         // Doğrulaması yapılmış ticket için ödeme alınır, bunun için ticketId ve pos bilgileri geçilir.
         DoOtpPaymentResponse doOtpPaymentResponse = callDoOtpPaymentService(initOtpPaymentResponse);

         if ( doOtpPaymentResponse.getResultCode() == 0 )
             System.out.println("ÖDEME BAŞARILI");
         else
             System.out.println("ÖDEME BAŞARISIZ " + doOtpPaymentResponse.getResultMsg());

         //islem iptal edilmek isteniyor ise
         DoPaymentReversalResponse doPaymentReversalResponse = callDoPaymentReversalService(initOtpPaymentResponse);
         if ( doPaymentReversalResponse.getResultCode() == 0 )
             System.out.println("İPTAL BAŞARILI");
         else
             System.out.println("İPTAL BAŞARISIZ " + doOtpPaymentResponse.getResultMsg());

         return ;
    }


    public static InitOtpPaymentResponse  callInitOtpPaymentService() {

        InitOtpPaymentRequest request = InitOtpPaymentService.createInitOtpPaymentRequest();

        URI url = InitOtpPaymentService.getUrlForInitOtpPayment();

        RestTemplate rest = new RestTemplate();
        InitOtpPaymentResponse response = InitOtpPaymentService.callInitOtpPaymentService(url, rest, request);

        // PRINTING AMACLI
        Gson gson = new GsonBuilder().create();
        String responseJson = gson.toJson(response);
        System.out.println("/*******************/");
        System.out.println("RESPONSE " + responseJson);
        System.out.println("/*******************/");
        return response;
    }


    public static CheckOtpResponse callCheckOtpService(InitOtpPaymentResponse initOtpPaymentResponse) {

        CheckOtpRequest request = CheckOtpService.createCheckOtpRequest(initOtpPaymentResponse);

        URI url = CheckOtpService.getUrlForCheckOtpPayment();

        RestTemplate rest = new RestTemplate();
        CheckOtpResponse response = CheckOtpService.callCheckOtpService(url, rest, request);

        // PRINTING AMACLI
        Gson gson = new GsonBuilder().create();
        String responseJson = gson.toJson(response);
        System.out.println("/*******************/");
        System.out.println("RESPONSE " + responseJson);
        System.out.println("/*******************/");

        return response;
    }


    public static DoOtpPaymentResponse callDoOtpPaymentService(InitOtpPaymentResponse initOtpPaymentResponse) {

        DoOtpPaymentRequest request = DoOtpPaymentService.createDoPaymentByTicketIdRequest(initOtpPaymentResponse);

        URI url = DoOtpPaymentService.getUrlForDoOtpPayment();

        RestTemplate rest = new RestTemplate();
        DoOtpPaymentResponse response = DoOtpPaymentService.callDoOtpPaymentService(url, rest, request);

        // PRINTING AMACLI
        Gson gson = new GsonBuilder().create();
        String responseJson = gson.toJson(response);
        System.out.println("/*******************/");
        System.out.println("RESPONSE " + responseJson);
        System.out.println("/*******************/");

        return response;
    }

    public static DoPaymentReversalResponse callDoPaymentReversalService(InitOtpPaymentResponse initOtpPaymentResponse){

        DoPaymentReversalRequest request = DoPaymentReversalService.createDoReversalByTicketIdRequest(initOtpPaymentResponse);

        URI url = DoPaymentReversalService.getUrlForDoReversal();

        RestTemplate rest = new RestTemplate();
        DoPaymentReversalResponse response = DoPaymentReversalService.callDoReversalService(url, rest, request);

        // PRINTING AMACLI
        Gson gson = new GsonBuilder().create();
        String responseJson = gson.toJson(response);
        System.out.println("/*******************/");
        System.out.println("RESPONSE " + responseJson);
        System.out.println("/*******************/");

        return response;

    }

}
