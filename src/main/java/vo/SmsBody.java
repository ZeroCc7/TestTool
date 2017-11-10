package vo;

public class SmsBody {

	private String smsMsgId;
	private String from;
	private String to;
	private String body;
	private String statusCallback;
	private String profileId;
	private String createTime;
	private String updateTime;
	private String status;
	private String resourceUrl;
	
	
	
	public String getProfileId() {
		return profileId;
	}
	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}
	public String getSmsMsgId() {
		return smsMsgId;
	}
	public void setSmsMsgId(String smsMsgId) {
		this.smsMsgId = smsMsgId;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getStatusCallback() {
		return statusCallback;
	}
	public void setStatusCallback(String statusCallback) {
		this.statusCallback = statusCallback;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResourceUrl() {
		return resourceUrl;
	}
	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

	@Override
	public String toString() {
		return "CmcSmsBody{" +
				"smsMsgId='" + smsMsgId + '\'' +
				", from='" + from + '\'' +
				", to='" + to + '\'' +
				", body='" + body + '\'' +
				", statusCallback='" + statusCallback + '\'' +
				", profileId='" + profileId + '\'' +
				", createTime='" + createTime + '\'' +
				", updateTime='" + updateTime + '\'' +
				", status='" + status + '\'' +
				", resourceUrl='" + resourceUrl + '\'' +
				'}';
	}
}
