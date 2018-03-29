package vo.maiyuanvo;

import java.util.List;

public class ReturnSms {
	private String returnstatus;
	private String message;
	private int remainpoint;
	private String taskID;
	private int successCounts;
	private List<StatusBox> statusbox;
	private List<CallBox> callbox;
	private ErrorStatus errorstatus;

	public String getReturnstatus() {
		return returnstatus;
	}

	public void setReturnstatus(String returnstatus) {
		this.returnstatus = returnstatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getRemainpoint() {
		return remainpoint;
	}

	public void setRemainpoint(int remainpoint) {
		this.remainpoint = remainpoint;
	}

	public String getTaskID() {
		return taskID;
	}

	public void setTaskID(String taskID) {
		this.taskID = taskID;
	}

	public int getSuccessCounts() {
		return successCounts;
	}

	public void setSuccessCounts(int successCounts) {
		this.successCounts = successCounts;
	}

	public List<CallBox> getCallbox() {
		return callbox;
	}

	public void setCallbox(List<CallBox> callbox) {
		this.callbox = callbox;
	}

	public List<StatusBox> getStatusbox() {
		return statusbox;
	}

	public void setStatusbox(List<StatusBox> statusbox) {
		this.statusbox = statusbox;
	}

	public ErrorStatus getErrorstatus() {
		return errorstatus;
	}

	public void setErrorstatus(ErrorStatus errorstatus) {
		this.errorstatus = errorstatus;
	}

}
