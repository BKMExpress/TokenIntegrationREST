package model.request;

public class CheckOtpRequest extends BaseRequest {

    private String ticketId;

    private String otpId;

    private String otpCode;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getOtpId() {
        return otpId;
    }

    public void setOtpId(String otpId) {
        this.otpId = otpId;
    }

    public String getOtpCode() {
        return otpCode;
    }

    public void setOtpCode(String otpCode) {
        this.otpCode = otpCode;
    }

    @Override
    public String toString() {
        return "CheckOtpRequest{" +
                "ticketId='" + ticketId + '\'' +
                ", otpId='" + otpId + '\'' +
                ", otpCode='" + otpCode + '\'' +
                "} " + super.toString();
    }
}
