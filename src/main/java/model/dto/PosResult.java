package model.dto;

public class PosResult {

	private String orderId;
	private String authCode;
	private String posResponse;
	private String posResultCode;
	private String posResultMessage;
	private String referansNumber;
	private String posTransactionId;
	private String groupId;
	private String cardBin;
	private String cardBank;
	private int noflnst;
	private String posBank;

	public PosResult() {

	}

	public PosResult(String orderId, String authCode, String posResponse,
					 String posResultCode, String posResultMessage,
					 String referansNumber, String posTransactionId, String groupId,
					 String cardBin, String cardBank, int noflnst, String posBank, String stan, String merchantOrderId) {
		super();
		this.orderId = orderId;
		this.authCode = authCode;
		this.posResponse = posResponse;
		this.posResultCode = posResultCode;
		this.posResultMessage = posResultMessage;
		this.referansNumber = referansNumber;
		this.posTransactionId = posTransactionId;
		this.groupId = groupId;
		this.cardBin = cardBin;
		this.cardBank = cardBank;
		this.noflnst = noflnst;
		this.posBank = posBank;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getPosResponse() {
		return posResponse;
	}

	public void setPosResponse(String posResponse) {
		this.posResponse = posResponse;
	}

	public String getPosResultCode() {
		return posResultCode;
	}

	public void setPosResultCode(String posResultCode) {
		this.posResultCode = posResultCode;
	}

	public String getPosResultMessage() {
		return posResultMessage;
	}

	public void setPosResultMessage(String posResultMessage) {
		this.posResultMessage = posResultMessage;
	}

	public String getReferansNumber() {
		return referansNumber;
	}

	public void setReferansNumber(String referansNumber) {
		this.referansNumber = referansNumber;
	}

	public String getPosTransactionId() {
		return posTransactionId;
	}

	public void setPosTransactionId(String posTransactionId) {
		this.posTransactionId = posTransactionId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getCardBin() {
		return cardBin;
	}

	public void setCardBin(String cardBin) {
		this.cardBin = cardBin;
	}

	public String getCardBank() {
		return cardBank;
	}

	public void setCardBank(String cardBank) {
		this.cardBank = cardBank;
	}

	public int getNoflnst() {
		return noflnst;
	}

	public void setNoflnst(int noflnst) {
		this.noflnst = noflnst;
	}

	public String getPosBank() {
		return posBank;
	}

	public void setPosBank(String posBank) {
		this.posBank = posBank;
	}

	@Override
	public String toString() {

		StringBuffer sb = new StringBuffer();
		String orderIdValue = (orderId != null) ? orderId : "";
		String authCodeValue = (authCode != null) ? authCode : "";
		String posResponseValue = (posResponse != null) ? posResponse : "";
		String posResultCodeValue = (posResultCode != null) ? posResultCode: "";
		String posResultMessageValue = (posResultMessage != null) ? posResultMessage : "";
		String referansNumberValue = (referansNumber != null) ? referansNumber : "";
		String posTransactionIdValue = (posTransactionId != null) ? posTransactionId : "";
		String groupIdValue = (groupId != null) ? groupId : "";
		String cardBinValue = (cardBin != null) ? cardBin : "";
		String cardBankValue = (cardBank != null) ? cardBank : "";
		String noflnstValue = String.valueOf(noflnst);
		String posBankValue = (posBank != null) ? posBank : "";
		
		sb.append(orderIdValue).append(authCodeValue).append(posResponseValue)
		.append(posResultCodeValue).append(posResultMessageValue).append(referansNumberValue)
		.append(posTransactionIdValue).append(groupIdValue).append(cardBinValue)
		.append(cardBankValue).append(noflnstValue).append(posBankValue);
		 
		return sb.toString();

	}

}
