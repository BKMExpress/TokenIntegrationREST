package model.response;

import model.dto.OtpInfo;

public class InitOtpPaymentResponse  extends UniqueBaseResponse {

    private String ticketId;

    private OtpInfo otpInfo;

    public InitOtpPaymentResponse(BaseResponse response, String uniqueRefNo) {
        super(uniqueRefNo);
        this.resultMsg = response.getResultMsg();
        this.resultCode = response.getResultCode();
    }

    @Override
    public String toSignatureString() {
        return  this.getUniqueReferans() +
                this.getTicketId() +
                this.getTs();

    }

    @Override
    public String toString() {
        return "InitOtpPaymentResponse{" +
                "ticketId='" + ticketId + '\'' +
                ", otpInfo=" + otpInfo +
                "} " + super.toString();
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public OtpInfo getOtpInfo() {
        return otpInfo;
    }

    public void setOtpInfo(OtpInfo otpInfo) {
        this.otpInfo = otpInfo;
    }
}