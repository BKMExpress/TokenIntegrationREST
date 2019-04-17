package model.response;


import model.dto.OtpInfo;

public class GetOtpInfoResponse extends BaseResponse {

    private OtpInfo otpInfo;

    public GetOtpInfoResponse() {

    }

    public OtpInfo getOtpInfo() {
        return otpInfo;
    }

    public void setOtpInfo(OtpInfo otpInfo) {
        this.otpInfo = otpInfo;
    }

    @Override
    public String toString() {
        return "GetOtpInfoResponse{" + "otpInfo=" + otpInfo + "} " + super.toString();
    }

}
