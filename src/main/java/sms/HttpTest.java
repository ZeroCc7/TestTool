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

public class HttpTest {
    protected static ThreadPoolExecutor taskExecutor = new ThreadPoolExecutor(20, 20, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1000000),
            new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) throws Exception {
        String url = "http://172.20.0.227:8099/api/sms/guideWhile";
        Map<String, Object> posedate = new HashMap<String, Object>();
        String posdate = JSON.toJSONString(posedate);
        taskExecutor.execute(new sendPosdate(url, posdate));

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
