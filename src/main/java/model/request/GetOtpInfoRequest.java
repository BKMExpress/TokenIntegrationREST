package model.request;


public class GetOtpInfoRequest extends BaseRequest {


    private String ticketId;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public String toString() {
        return "GetOtpInfoRequest{" +
                "ticketId='" + ticketId + '\'' +
                "} " + super.toString();
    }
}


