package model.response;

public class UniqueBaseResponse extends BaseResponse {

    protected String uniqueReferans;

    private String ts;

    private String sign;

    public UniqueBaseResponse(String uniqueRefNo) {
        this.uniqueReferans = uniqueRefNo;
    }

    public String getUniqueReferans() {
        return uniqueReferans;
    }

    public void setUniqueReferans(String uniqueReferans) {
        this.uniqueReferans = uniqueReferans;
    }

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



    @Override
    public String toString() {
        return "UniqueBaseResponse{" +
                "uniqueReferans='" + uniqueReferans + '\'' +
                "} " + super.toString();
    }
}
