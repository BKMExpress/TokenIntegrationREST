package model.request;

import model.dto.PosInfo;

/**
 * Created by Akif Hatipoglu on 10.12.2018.
 */
public class DoPaymentReversalRequest extends MerchantBaseRequest {

    private String transactionToken;
    private String requestType;
    private String amount;
    private String currency;
    private PosInfo posInfo;

    public String getTransactionToken() {
        return transactionToken;
    }

    public void setTransactionToken(String transactionToken) {
        this.transactionToken = transactionToken;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public PosInfo getPosInfo() {
        return posInfo;
    }

    public void setPosInfo(PosInfo posInfo) {
        this.posInfo = posInfo;
    }

    public String toSignatureString() {
        return getUniqueReferans() +
                getMerchantId() +
                getTransactionToken() +
                getRequestType() +
                getAmount() +
                getCurrency() +
                getTs();
    }

    @Override
    public String toString() {
        return "DoPaymentReversalRequest{" +
                "transactionToken='" + transactionToken + '\'' +
                ", requestType='" + requestType + '\'' +
                ", amount='" + amount + '\'' +
                ", currency='" + currency + '\'' +
                ", posInfo=" + posInfo +
                '}';
    }
}
