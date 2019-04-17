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

         // kart bilgileri ile ticket al?n?r
         InitOtpPaymentResponse initOtpPaymentResponse = callInitOtpPaymentService();
         if ( initOtpPaymentResponse.getResultCode() == 0 )
             System.out.println("TICKET ALMA BA?ARILI " + initOtpPaymentResponse.getTicketId() );
         else {
             System.out.println("TICKET ALMA BA?ARISIZ " + initOtpPaymentResponse.getTicketId() + " HATA : " +
                  initOtpPaymentResponse.getResultMsg() );
             return;
         }

         boolean isOtpValidated = false;
         // ivr ak???nda m�?teriden al?nan otpCode un do?rulamas? yap?l?r
         int tryCount = initOtpPaymentResponse.getOtpInfo().getAllowedOtpAttempts();
         for ( int i = 0 ; i < tryCount ; i ++ ) {
             CheckOtpResponse checkOtpResponse = callCheckOtpService(initOtpPaymentResponse);
             if (checkOtpResponse.getResultCode() == 0) {
                 System.out.println("OTP DO?RULAMASI BA?ARILI ");
                 isOtpValidated = true;
                 break;
             }
             System.out.println("OTP DO?RULAMASI BA?ARISIZ, TEKRAR DENEY?N ");
         }

         if ( ! isOtpValidated ){
             System.out.println("DO?RULAMA YAPILAMADI, ??LEM?N?Z? GER�EKLE?T?REM?YORUZ");
             return;
         }
         // Do?rulamas? yap?lm?? ticket i�in �deme a?n?r, bunun i�in ticketId ve pos bilgileri ge�ilir.
         DoOtpPaymentResponse doOtpPaymentResponse = callDoOtpPaymentService(initOtpPaymentResponse);

         if ( doOtpPaymentResponse.getResultCode() == 0 )
             System.out.println("�DEME BA?ARILI");
         else
             System.out.println("�DEME BA?ARISIZ " + doOtpPaymentResponse.getResultMsg());

         //islem iptal edilmek isteniyor ise
         DoPaymentReversalResponse doPaymentReversalResponse = callDoPaymentReversalService(initOtpPaymentResponse);
         if ( doPaymentReversalResponse.getResultCode() == 0 )
             System.out.println("iptal BA?ARILI");
         else
             System.out.println("iptal BA?ARISIZ " + doOtpPaymentResponse.getResultMsg());

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
