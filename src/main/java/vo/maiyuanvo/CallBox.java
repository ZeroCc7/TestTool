package vo.maiyuanvo;


public class CallBox {
	private String mobile;
	private String taskid;
	private String content;
	private String receivetime;
	private String extno;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTaskid() {
		return taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReceivetime() {
		return receivetime;
	}

	public void setReceivetime(String receivetime) {
		this.receivetime = receivetime;
	}

	public String getExtno() {
		return extno == null ? "" : extno;
	}

	public void setExtno(String extno) {
		this.extno = extno;
	}
}
