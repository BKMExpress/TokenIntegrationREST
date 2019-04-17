package model.request;


import model.dto.PosInfo;

/**
 * Created by myalcinsoy on 18-May-18.
 */
public class DoOtpPaymentRequest  extends MerchantBaseRequest {

    protected String initOtpUniqueReferans;

    private String ticketId;

    private String orderId;

    private String bankMerchantId;

    private String amount;

    private String currency;

    private String numberOfInst;

    private String subMerchantName;

    private String acquirerBankId;


    private PosInfo posInfo;

    public String getInitOtpUniqueReferans() {
        return initOtpUniqueReferans;
    }

    public void setInitOtpUniqueReferans(String initOtpUniqueReferans) {
        this.initOtpUniqueReferans = initOtpUniqueReferans;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBankMerchantId() {
        return bankMerchantId;
    }

    public void setBankMerchantId(String bankMerchantId) {
        this.bankMerchantId = bankMerchantId;
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

    public String getNumberOfInst() {
        return numberOfInst;
    }

    public void setNumberOfInst(String numberOfInst) {
        this.numberOfInst = numberOfInst;
    }

    public String getSubMerchantName() {
        return subMerchantName;
    }

    public void setSubMerchantName(String subMerchantName) {
        this.subMerchantName = subMerchantName;
    }

    public String getAcquirerBankId() {
        return acquirerBankId;
    }

    public void setAcquirerBankId(String acquirerBankId) {
        this.acquirerBankId = acquirerBankId;
    }

    public PosInfo getPosInfo() {
        return posInfo;
    }

    public void setPosInfo(PosInfo posInfo) {
        this.posInfo = posInfo;
    }

    @Override
    public String toSignatureString() {
        return getUniqueReferans() +
               getMerchantId() +
               getInitOtpUniqueReferans() +
               getTicketId() +
               getAmount() +
               getCurrency() +
               getTs();

    }

}
