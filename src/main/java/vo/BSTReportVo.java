package vo;

public class BSTReportVo {
    private String dstphone;
    private String logtime;
    private String msgid;
    private String state;

    public String getDstphone() {
        return dstphone;
    }

    public void setDstphone(String dstphone) {
        this.dstphone = dstphone;
    }

    public String getLogtime() {
        return logtime;
    }

    public void setLogtime(String logtime) {
        this.logtime = logtime;
    }

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("dstphone="+dstphone);
        str.append("&logtime="+logtime);
        str.append("&msgid="+msgid);
        str.append("&state="+state);
        return str.toString();
    }
}
