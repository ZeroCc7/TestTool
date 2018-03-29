package vo.maiyuanvo;

import java.io.Serializable;

public class TaskRelated implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1221012811458105425L;
	private String taskId;
	private int chan_id;
	private int cust_id;
	private String sp_code;

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public int getChan_id() {
		return chan_id;
	}

	public void setChan_id(int chan_id) {
		this.chan_id = chan_id;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getSp_code() {
		return sp_code;
	}

	public void setSp_code(String sp_code) {
		this.sp_code = sp_code;
	}
}
