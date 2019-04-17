package model.request;

public class InitOtpPaymentRequest  extends MerchantBaseRequest {
    
    private String ccFirst6Digits;
    private String ccLast4Digits;
    private String tckno;
    private String customerno;
    private String amount;

    private String currency;


    public String getCcFirst6Digits() {
        return ccFirst6Digits;
    }

    public void setCcFirst6Digits(String ccFirst6Digits) {
        this.ccFirst6Digits = ccFirst6Digits;
    }

    public String getCcLast4Digits() {
        return ccLast4Digits;
    }

    public void setCcLast4Digits(String ccLast4Digits) {
        this.ccLast4Digits = ccLast4Digits;
    }

    public String getTckno() {
        return tckno;
    }

    public void setTckno(String tckno) {
        this.tckno = tckno;
    }

    public String getCustomerNo() {
        return customerno;
    }

    public void setCustomerNo(String customerNo) {
        this.customerno = customerNo;
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

    @Override
    public String toSignatureString() {
        return getUniqueReferans() +
               getMerchantId() +
               getCcFirst6Digits() +
               getCcLast4Digits() +
               getTckno() +
               getCustomerNo() +
               getAmount() +
               getCurrency() +
               getTs();

    }

    @Override
    public String toString() {
        return "InitOtpPaymentRequest{" +
                   "ccFirst6Digits='" + ccFirst6Digits + '\'' +
                   ", ccLast4Digits='" + ccLast4Digits + '\'' +
                   ", tckno='" + tckno + '\'' +
                   ", customerno='" + customerno + '\'' +
                "} " + super.toString();
    }
}
