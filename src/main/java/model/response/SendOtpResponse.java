package model.response;

/**
 * Created by myalcinsoy on 12/12/2016.
 */
public class SendOtpResponse extends BaseResponse {

    private String otpId;
    private String ccInfo;
    private String expiryDate;

    public String getOtpId() {
        return otpId;
    }

    public void setOtpId(String otpId) {
        this.otpId = otpId;
    }

    public String getCcInfo() {
        return ccInfo;
    }

    public void setCcInfo(String ccInfo) {
        this.ccInfo = ccInfo;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}
