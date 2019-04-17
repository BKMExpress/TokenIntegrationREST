package model.request;

public abstract class MerchantBaseRequest extends UniqueBaseRequest {


    private String merchantId;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }


    public abstract String toSignatureString();

    @Override
    public String toString() {
        return "MerchantBaseRequest{" +
                "merchantId='" + merchantId + '\'' +
                ", base='" + super.toString() + '\'' +
                "} " + super.toString();
    }
}
