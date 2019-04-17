package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.request.BaseRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by myalcinsoy on 05-Jun-18.
 */
public class UtilService {

    public static String MERCHANT_ID = "e7125a0f-7c5d-4152-a803-6a23fb4132fd";
    public static String TOKENIZATION_BASE_URL = "https://tokenpreprod.bkm.com.tr/";
    private static final String signatureTsSdfFormat = "yyyyMMdd-HH:mm:ss";

    public static String getDateAsSignTsString(Date date) {
        return new SimpleDateFormat(signatureTsSdfFormat).format(date);
    }


    public static HttpEntity<String> getEntityForRestTemplate(BaseRequest request) {
        HttpHeaders headers = new HttpHeaders();
        MediaType mediaType = new MediaType("application", "json", Charset.forName("UTF-8"));
        headers.setContentType(mediaType);

        Gson gson = new GsonBuilder().create();
        String requestJson = gson.toJson(request);

        HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);

        return entity;

    }
}
