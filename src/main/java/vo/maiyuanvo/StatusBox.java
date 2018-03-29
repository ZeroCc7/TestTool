package vo.maiyuanvo;


public class StatusBox {
	private String mobile;
	private String taskid;
	private String status;
	private String receivetime;
	private String errorcode;
	private String extno;
	
	/**
	 * 
	<returnsms> <statusbox> <mobile>15859104764</mobile> <taskid>14680237</taskid> <status>10</status> <receivetime>2015-3-26 15:15:42</receivetime> <errorcode>DELIVRD</errorcode> <extno></extno> </statusbox> </returnsms>
	 * @return
	 */

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReceivetime() {
		return receivetime;
	}

	public void setReceivetime(String receivetime) {
		this.receivetime = receivetime;
	}

	public String getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}

	public String getExtno() {
		return extno;
	}

	public void setExtno(String extno) {
		this.extno = extno;
	}
}
