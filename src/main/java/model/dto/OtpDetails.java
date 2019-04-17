package model.dto;


public class OtpDetails {

    private int otpDurInMin;
    private int otpLength;
    private String otpType;
    private int allowedOtpAttempts;

    public int getOtpDurInMin() {
        return otpDurInMin;
    }

    public void setOtpDurInMin(int otpDurInMin) {
        this.otpDurInMin = otpDurInMin;
    }

    public int getOtpLength() {
        return otpLength;
    }

    public void setOtpLength(int otpLength) {
        this.otpLength = otpLength;
    }

    public String getOtpType() {
        return otpType;
    }

    public void setOtpType(String otpType) {
        this.otpType = otpType;
    }

    public int getAllowedOtpAttempts() {
        return allowedOtpAttempts;
    }

    public void setAllowedOtpAttempts(int allowedOtpAttempts) {
        this.allowedOtpAttempts = allowedOtpAttempts;
    }
}
