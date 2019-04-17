package model.response;

public class BaseResponse {
    protected int resultCode;
    protected int subResultCode;
    protected String resultMsg;

    public int getSubResultCode() {
        return subResultCode;
    }

    public void setSubResultCode(int subResultCode) {
        this.subResultCode = subResultCode;
    }

    public int getResultCode() {
        return resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String toSignatureString(){
        return "" + getResultCode() + getResultMsg();

    }



    @Override
    public String toString() {
        return "BaseResponse{" +
                "resultCode=" + resultCode +
                ", resultMsg='" + resultMsg + '\'' +
                '}';
    }
}
