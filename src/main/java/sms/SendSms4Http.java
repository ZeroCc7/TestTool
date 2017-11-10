package sms;

import util.UMD5;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Random;

public class SendSms4Http {
    //	public static String cust_code = "590005";									 //账号
//	public static String password = "ZE6GCMVBL6";		 								//密码
//	public static String sp_code = "04668991";  	//接入码（扩展码）

    //	public static String cust_code = "201611";									 //账号
//	public static String password = "YQDMYJ5LZ2";		 								//密码 CUFGLIXFIZ
    public static String cust_code = "777777";									 //账号
    public static String password = "111111";
    public static String sp_code = "";


    public static void main(String[] args) throws Exception {
//		sendSms("http://172.20.0.225:7760", "13174537097,18650995326", "【未来无线】您的验证码是665252，如非本人操作请忽略。");
//		sendSms("http://172.20.0.225:7760", "13665027676", "该还贷款");
//		cust_code = "201611";									 //账号
//		password = "1CQE6W4XA5";s		 								//密码 CUFGLIXFIZ
        //15962163166 江苏号码 测试用 15359149768 XJ
        //江苏移动测试
//		sendSms("http://172.20.0.56:8866", "13960735706", "你好，你的验证码为082504【未来无线】");


        //空号   17865964579 空号  15704901085外省  13774568228
//		sendSms("http://127.0.0.1:8860", "15108283734", "居家防暑妙招：冲温水澡更凉爽；放慢动作，避免剧烈活动；闭眼小睡降低温度；穿棉质服装利于排汗。退订回复TD【健康堂】");


//		sendSms("http://172.20.0.56:8866", "13174537097", "您的短信验证码为：23422，请在10分钟内完成验证");
//		sendSms("http://127.0.0.1:8860", "13960735706", "【江苏银行】短信验证码22222，您向6999尾号215账户转账1000元。请勿泄露验证码，谨防诈骗。如有疑问，请致电95319。");
//		sendSms("http://127.0.0.1:8860", "13174537097", "您的短信验证码为：32323，请在10分钟内完成验证");
//		for(int i = 0 ;i<100;i++){
//			String p = getPhoneNum("131",1500); //yangxi 13960789441 ziming 15080457442
        sendSms("http://127.0.0.1:8860", "13960735706,13960789441", "您的验证码：77777。请尽快使用。【健康之路】");
//			Thread.sleep(2000);
//		}

        //13365915899 电信 zmh
//junyimsgid7113724786863767553
        // LL 18396110335  ZB 13960735706 zb 13960735706   zz 15960393654

		/*
		 * 移动 ： 13960735706 值班
		 *
		 *
		 * 		 */
    }

    public static void sendSms(String smsSvcUrl,String mobiles, String content) throws IOException {
        sendSms(smsSvcUrl,cust_code, password, mobiles, content, sp_code, 0);
    }

    public static void sendSms(String smsSvcUrl,String mobiles, String content, long task_id)
            throws IOException {
        sendSms(smsSvcUrl,cust_code, password, mobiles, content, sp_code, task_id);
    }

    public static void sendSms(String smsSvcUrl,String cust_code, String password, String mobiles,
                               String content, String sp_code) throws IOException {
        sendSms(smsSvcUrl,cust_code, password, mobiles, content, sp_code, 0);
    }

    @SuppressWarnings("deprecation")
    public static void sendSms(String smsSvcUrl,String cust_code, String password, String mobiles,
                               String content, String sp_code, long task_id ) throws IOException {
        String urlencContent = URLEncoder.encode(content, "utf-8");
        String sign = UMD5.sign(urlencContent, password, "utf-8");
        String postData = "content=" + urlencContent + "&destMobiles="
                + URLEncoder.encode(mobiles) + "&sign=" + sign + "&cust_code=" + cust_code
                + "&sp_code=" + sp_code + "&task_id=" + task_id+"&msg_fmt=15";
        URL myurl = new URL(smsSvcUrl);
        URLConnection urlc = myurl.openConnection();
        urlc.setReadTimeout(1000 * 30);
        urlc.setDoOutput(true);
        urlc.setDoInput(true);
        urlc.setAllowUserInteraction(false);

        DataOutputStream server = new DataOutputStream(urlc.getOutputStream());
        System.out.println("发送数据=" + postData);

        server.write(postData.getBytes("utf-8"));
        server.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(
                urlc.getInputStream(), "utf-8"));
        String resXml = "", s = "";
        while ((s = in.readLine()) != null)
            resXml = resXml + s + "\r\n";
        in.close();
        System.out.println("接收数据=" + URLDecoder.decode(resXml, "utf-8"));
    }

    public static String sendSms(String smsSvcUrl,String mobiles, String content, String sp_code,
                                 long task_id,String password,String cust_code,String... need_report) throws IOException {
        String urlencContent = URLEncoder.encode(content,"utf-8");
        String urlmobiles = URLEncoder.encode(mobiles,"utf-8");
        //String sign = MD5.getMD5((urlencContent + password).getBytes());
        String sign=UMD5.sign(urlencContent, password, "utf-8");
        String postData = "content=" + urlencContent + "&destMobiles="
                + urlmobiles + "&sign=" + sign + "&cust_code=" + cust_code
                + "&sp_code=" + sp_code + "&task_id=" + task_id;
        if(need_report.length>0){
            postData+="&need_report=NO";
        }
        URL myurl = new URL(smsSvcUrl);
        URLConnection urlc = myurl.openConnection();
        urlc.setReadTimeout(1000 * 30);
        urlc.setDoOutput(true);
        urlc.setDoInput(true);
        urlc.setAllowUserInteraction(false);

        DataOutputStream server = new DataOutputStream(urlc.getOutputStream());
        //System.out.println("发送数据=" + postData);

        server.write(postData.getBytes("utf-8"));
        server.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(
                urlc.getInputStream(), "utf-8"));
        String resXml = "", s = "";
        while ((s = in.readLine()) != null)
            resXml = resXml + s + "\r\n";
        in.close();
        return URLDecoder.decode(resXml,"utf-8");
        //System.out.println("接收数据=" + URLDecoder.decode(resXml,"utf-8"));
    }

    private static String getPhoneNum(String p, int num) {
        String[] xS = p.split(",");
        Random rd = new Random();
        String mobileS = "";
        for(int i = 0;i<num;i++){
            String x = xS[rd.nextInt(xS.length)];
            int getLent = 11-x.length();
            for(int j = 0;j<getLent;j++){

                x = x+rd.nextInt(10);
            }
            if("".equals(mobileS)){
                mobileS = x;
            }else{
                mobileS = mobileS+","+x;
            }
        }
        return mobileS;
    }
}
