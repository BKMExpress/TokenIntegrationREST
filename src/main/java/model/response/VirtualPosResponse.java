 
package model.response;


import model.dto.PosResult;

public class VirtualPosResponse {

    private String token;
    private String posRequest;
    private String posResponse;
    private String posReference;
    private boolean posSuccess;
    private String posMessage;
    private String xid;
    private String md;
    private PosResult posResult;
    
    public PosResult getPosResult() {
		return posResult;
	}

	public void setPosResult(PosResult posResult) {
		this.posResult = posResult;
	}

    public VirtualPosResponse() {
        posSuccess = true;
    }

    public VirtualPosResponse(String token, String posRequest, String posResponse, String posReference,
                              boolean posSuccess, String posMessage, String xid, String md, PosResult posResult) {

        this.token = token;
        this.posRequest = posRequest;
        this.posResponse = posResponse;
        this.posReference = posReference;
        this.posSuccess = posSuccess;
        this.posMessage = posMessage;
        this.xid = xid;
        this.md = md;
        this.posResult=posResult;
    }

    public String getPosRequest() {
        return posRequest;
    }

    public String getPosResponse() {
        return posResponse;
    }

    public String getToken() {
        return token;
    }

    public String getPosReference() {
        return posReference;
    }

    public boolean isPosSuccess() {
        return posSuccess;
    }

    public String getPosMessage() {
        return posMessage;
    }

    public String getXid() {
        return xid;
    }

    public String getMd() {
        return md;
    }

}
