package model.response;


import model.dto.PosResult;

public class DoOtpPaymentResponse  extends UniqueBaseResponse {

    private String cardToken;
    private PosResult posResult;

    public DoOtpPaymentResponse(BaseResponse response, String uniqueRefNo) {
        super(uniqueRefNo);
        this.resultMsg = response.getResultMsg();
        this.resultCode = response.getResultCode();
    }


    @Override
    public String toSignatureString() {
        return this.getUniqueReferans() +
               this.getCardToken() +
               this.getPosResult().getOrderId()+
               this.getTs();
    }

    public String getCardToken() {
        return cardToken;
    }

    public void setCardToken(String cardToken) {
        this.cardToken = cardToken;
    }

    public PosResult getPosResult() {
        return posResult;
    }

    public void setPosResult(PosResult posResult) {
        this.posResult = posResult;
    }

    @Override
    public String toString() {
        return "DoOtpPaymentResponse{" +
                "cardToken='" + cardToken + '\'' +
                ", posResult=" + posResult +
                "} " + super.toString();
    }
}
