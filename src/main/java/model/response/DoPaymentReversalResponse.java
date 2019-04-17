package model.response;

import model.dto.PosResult;

/**
 * Created by Akif Hatipoglu on 10.12.2018.
 */
public class DoPaymentReversalResponse extends UniqueBaseResponse {

    private PosResult posResult;

    public PosResult getPosResult() {
        return posResult;
    }

    public void setPosResult(PosResult posResult) {
        this.posResult = posResult;
    }

    public DoPaymentReversalResponse(BaseResponse response, String uniqueRefNo) {
        super(uniqueRefNo);
        this.resultMsg = response.getResultMsg();
        this.resultCode = response.getResultCode();
    }

    @Override
    public String toSignatureString() {
        return getUniqueReferans() +
                this.getTs();

    }
}
