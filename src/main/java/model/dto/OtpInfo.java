package model.dto;


public class OtpInfo {

    private String otpId;
    private String otpRefNo;
    private String bankShortName;
    private int otpDurInMin;
    private int otpLength;
    private String otpType;
    private int allowedOtpAttempts;

    public String getOtpId() {
        return otpId;
    }

    public void setOtpId(String otpId) {
        this.otpId = otpId;
    }

    public String getOtpRefNo() {
        return otpRefNo;
    }

    public void setOtpRefNo(String otpRefNo) {
        this.otpRefNo = otpRefNo;
    }

    public String getBankShortName() {
        return bankShortName;
    }

    public void setBankShortName(String bankShortName) {
        this.bankShortName = bankShortName;
    }

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
