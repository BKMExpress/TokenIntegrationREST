package model.request;


public class UniqueBaseRequest extends BaseRequest {

    protected String uniqueReferans;

    private String ts;

    private String sign;


    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }


    public String getUniqueReferans() {
        return uniqueReferans;
    }

    public void setUniqueReferans(String uniqueReferans) {
        this.uniqueReferans = uniqueReferans;
    }

    @Override
    public String toString() {
        return "UniqueBaseRequest{" +
                "uniqueRefNo='" + uniqueReferans + '\'' +
                '}';
    }
}
