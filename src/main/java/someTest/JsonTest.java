package someTest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import vo.Beixiang2SubmitRepVo;

import java.util.List;

public class JsonTest {
    public static void main(String[] args) throws Exception {
        String respStr ="{'type':'REPORT','total':'2','dataList':[{'uuid':'d8f4a192-113c-4e5a-9173-b18a4881eb07','phone':'135XXXXXXXX','msgID':'05243215888','submitTime':'20161115123020','state':'0'},{'uuid':'d8f4a192-113c-4e5a-9173-b18a4881eb07','phone':'135XXXXXXXX','msgID':'05243215889','submitTime':'20161115123020','state':'0'}]}";
        MosReport respVo = JSONObject.parseObject(respStr, MosReport.class);
        System.out.println(respVo);
        List<MosReportVo> respList = JSONArray.parseArray(respVo.getDataList(), MosReportVo.class);
        System.out.println(respList);

    }

}


class MosReport {
    private String type;
    private String total;
    private String dataList;

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getTotal() {
        return total;
    }
    public void setTotal(String total) {
        this.total = total;
    }
    public String getDataList() {
        return dataList;
    }
    public void setDataList(String dataList) {
        this.dataList = dataList;
    }

    @Override
    public String toString() {
        return "MosReport{" +
                "type='" + type + '\'' +
                ", total='" + total + '\'' +
                ", dataList='" + dataList + '\'' +
                '}';
    }
}

class MosReportVo {
    private String uuid;
    private String phone;
    private String msgID;
    private String customMsgID;
    private String state;
    private String submitTime;
    private String originResult;
    private String reserve;

    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getMsgID() {
        return msgID;
    }
    public void setMsgID(String msgID) {
        this.msgID = msgID;
    }
    public String getCustomMsgID() {
        return customMsgID;
    }
    public void setCustomMsgID(String customMsgID) {
        this.customMsgID = customMsgID;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getSubmitTime() {
        return submitTime;
    }
    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }
    public String getOriginResult() {
        return originResult;
    }
    public void setOriginResult(String originResult) {
        this.originResult = originResult;
    }
    public String getReserve() {
        return reserve;
    }
    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

    @Override
    public String toString() {
        return "MosReportVo{" +
                "uuid='" + uuid + '\'' +
                ", phone='" + phone + '\'' +
                ", msgID='" + msgID + '\'' +
                ", customMsgID='" + customMsgID + '\'' +
                ", state='" + state + '\'' +
                ", submitTime='" + submitTime + '\'' +
                ", originResult='" + originResult + '\'' +
                ", reserve='" + reserve + '\'' +
                '}';
    }
}