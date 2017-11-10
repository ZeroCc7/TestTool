package someTest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import vo.Beixiang2SubmitRepVo;

public class JsonTest {
    public static void main(String[] args) throws Exception {
        String respStr ="{'CmcSmsBody':[{'SmsMsgId':'xx','From':'1065795555','To':'8618625150488','Body':'helloworld!','StatusCallback':'xx','ProfileId':'xxx','CreateTime':'xxx','UpdateTime':'xxxxx!','Status':'xxx','ResourceUrl':'xxxx'},{'SmsMsgId':'xx','From':'1065795555','To':'8618625150489','Body':'helloworld!','StatusCallback':'xx','ProfileId':'xxx','CreateTime':'xxx','UpdateTime':'xxxxx!','Status':'xxx','ResourceUrl':'xxxx'}]}";
        System.out.println(respStr);
        Beixiang2SubmitRepVo respVo = JSONObject.parseObject(respStr, Beixiang2SubmitRepVo.class);
        System.out.println(respVo);
    }

}
