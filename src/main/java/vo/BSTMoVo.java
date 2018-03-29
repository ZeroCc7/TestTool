package vo;

public class BSTMoVo {
    private String msgid;
    private String srcphone;
    private String dstphone;
    private String message;
    private String logtime;

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public String getSrcphone() {
        return srcphone;
    }

    public void setSrcphone(String srcphone) {
        this.srcphone = srcphone;
    }

    public String getDstphone() {
        return dstphone;
    }

    public void setDstphone(String dstphone) {
        this.dstphone = dstphone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLogtime() {
        return logtime;
    }

    public void setLogtime(String logtime) {
        this.logtime = logtime;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("msgid="+msgid);
        stringBuffer.append("&srcphone="+srcphone);
        stringBuffer.append("&dstphone="+dstphone);
        stringBuffer.append("&message="+message);
        stringBuffer.append("&logtime="+logtime);
        return stringBuffer.toString();
    }
}
