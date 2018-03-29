package sms;

import com.alibaba.fastjson.JSON;
import util.HttpClient;
import util.SHAUtil;
import vo.WhiteNumber;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class APIWhiteMobileTest {
    protected static ThreadPoolExecutor taskExecutor = new ThreadPoolExecutor(20, 20, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1000000),
            new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) throws Exception {
        String url = "http://172.20.0.227:8099/api/sms/guideWhile";
        url = "http://43.243.130.33:8099/api/sms/guideWhile";
//        url = "http://127.0.0.1:8088/client/api/sms/guideWhile";
//        url = "http://172.20.0.227:8099/api/sms/guideWhile";
//        url = "http://www.52sms.com/api/batch_send/market";
        Map<String, Object> posedate = new HashMap<String, Object>();
        String mobileS = "13161279284,13161279920,13161280002,13161280015,13161280546,13161280694,13161281275,13161281348,13161281409,13161281796,13161281919,13161282643,13161282694,13161284037,13161284971,13161285808,13161286137,13161286663,13161286724,13161287785,13161287795,13161288164,13161288748,13161289041,13161289124,13161289254,13161289537,13161290444,13161290551,13161290694,13161291626,13161292203,13161292490,13161293196,13161293253,13161293884,13161294100,13161294157,13161294234,13161294242,13161294750,13161295078,13161295364,13161296466,13161296675,13161297325,13161297710,13161298004,13161299142,13161299413,13161299488,13161302773,13161304800,13161304988,13161305107,13161305975,13161306365,13161306411,13161306754,13161306930,13161307009,13161307078,13161307102,13161307495,13161307772,13161308362,13161308406,13161308729,13161308897,13161309202,13161309400,13161310005,13161310534,13161310597,13161311141,13161311789,13161312584,13161312734,13161313140,13161313394,13161313428,13161313484,13161313837,13161313972,13161314444,13161316677,13161317068,13161317242,13161318520,13161318543,13161319275,13161320884,13161322560,13161322836,13161324098,13161325113,13161325518,13161326328,";
//
        mobileS = "15852224152";

        String account = "011222";
//        account = "096522";
        String pwd = "cfm123456";
//        pwd = "FL1B4GHNZV";
        pwd = SHAUtil.SHA256(pwd);
        String sign = "none";
        String type = "2";
        List<WhiteNumber> whitelist = new ArrayList<WhiteNumber>();
        String[] mobilel = mobileS.split(",");
        for (String mobile : mobilel) {
            WhiteNumber whiteNumber = new WhiteNumber();
            whiteNumber.setMobile(mobile);
            whiteNumber.setNationcode("86");
            whitelist.add(whiteNumber);
        }

        posedate.put("account", account);
        posedate.put("pwd", pwd);
        posedate.put("sign", sign);
        posedate.put("type", type);
        posedate.put("whitelist", whitelist);
        String posdate = JSON.toJSONString(posedate);
//        System.out.println("Start.....");
//        System.out.println("posdate："+posdate);
//        for (int i = 0; i < 10000; i++) {
//        posdate= "{\"msg\":\"您的验证码为：20180117，验证码2分钟内有效。\",\"phone_no\":\"18650995326\",\"app_key\":\"bbb736a099f09bc063dffa1437422cb5\",\"check\":\"918af9441158b57268a2abbe5b892f26\",\"timestamp\":1516860909}\n";
        taskExecutor.execute(new HttpTest.sendPosdate(url, posdate));
//        }
//        System.out.println("End!");

    }

    public static class sendPosdate implements Runnable {

        private String url;
        private String posdate;

        public sendPosdate(String url, String posdate) {
            this.posdate = posdate;
            this.url = url;
        }

        public void run() {
            try {
                HttpClient.postHttpRequest(url, posdate);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
