package someTest;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileTest {
    private final static Random random = new Random();
    private final static String mobileFile = "D:\\0.txt";
    private final static int times = 10000;
    private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    private final static int testTimes = 1;

    public static void main(String[] args) throws Exception {
        String filename= "D:\\webapps\\client\\WEB-INF\\classes\\com\\wlwx\\service\\system\\impl\\CustomerServiceImpl.class";
        File file = new File(filename);
        File fileParent = file.getParentFile();
        if(!fileParent.exists()){
            fileParent.mkdirs();
        }
        file.createNewFile();

//        int runTime = 0;
//        while (runTime < testTimes) {
//            String fileDir = "D:\\ChinaPostTest\\ChinaPost\\" + sdf.format(new Date()) + "_tol" + times;
//            runTime++;
//            for (int i = 0; i < times; i++) {
//                String smsContent = getSmsContent();
//                int uid = random.nextInt(6);
//                String mobile = getSmsTaskMobileByFile();
//                if (mobile.length() != 11) {
//                    System.out.println(mobile + "不合适。。。。");
//                    continue;
//                }
//                String all = uid + "$$$$$" + mobile + "$$$$$" + smsContent;
//                writeTxtFile(all, fileDir);
//            }
//            File f = new File(fileDir);
//            f.renameTo(new File(fileDir + ".yll"));
//            System.out.println("mobile Num = " + times + "写入完成.");
//            Thread.sleep(1000 * 60);
//        }
//        String fileA = "C:\\Users\\Administrator\\Desktop\\sendSuccess.txt";
//        List<String> mobileA = getSmsTaskMobileByFile(fileA);
//        System.out.println("mobileA："+mobileA.size());
//        Map<String,String> mobileMap = new HashMap<String,String>();
//        for(String mobile : mobileA){
//            String m = mobileMap.get(mobile);
//            if(m == null){
//                mobileMap.put(mobile,mobile);
//            }else{
//                System.out.println(mobile);
//            }
//        }
//        System.out.println("读取完成......mobileMap Size="+mobileMap.size());
//        String fileB = "C:\\Users\\Administrator\\Desktop\\submitMobile.txt";
//        String weiteFile = "C:\\Users\\Administrator\\Desktop\\no.txt";
//
//        List<String> mobileB = getSmsTaskMobileByFile(fileB);
//        System.out.println("mobileB："+mobileB.size());
//
//        int x = 0;
//        for(String mobile : mobileB){
//            String m = mobileMap.get(mobile);
//            if(m == null){
//                x++;
//                System.out.println(mobile);
//                writeTxtFile(mobile,weiteFile);
//            }
//        }
//        System.out.println("有 "+x+" 未发送");



    }

    public static String getSmsContent() {
        int s = random.nextInt(6);
        List<String> smsContent = new ArrayList<String>();
        smsContent.add("【有利网】亲爱的利友，您有定存宝要到期了，您可以“设置续投”，定存宝到期自动出借，更有最高达1.5%续投专享加息哦 ，戳这进入dwz.cn/3LARLx");
        smsContent.add("【百度】<百度有钱花>亲爱的用户：您已开通自动还款功能，2018年2月01日是您的还款日，本期应还款金额696.66元。根据中国人民银行要求，贷款逾期信息将上报金融信用信息基础数据库，请于还款日早8点前确保绑定的银行卡余额充足，如已还款，请忽略。");
        smsContent.add("【百度】<百度有钱花>借现金提醒您：借款申请审核失败，亲，我们无法通过您的贷款激活申请，详细原因可咨询95055");
        smsContent.add("【首汽约车】超低价坐专车！11元起步含3公里（不含时长费），雨雪天不加价！更可抽取最高50元红包 t.cn/R8GZFzA 退回N");
        smsContent.add("【盈客在线】翁女士：萨贝尔厦门万达店周三会员日，当日劲爆6.8折（酒水饮料甜品除外，优惠不同享）快来享受您的会员权益回复TD退订");
        smsContent.add("【百度】搜索推广消费1月30日比1月29日上升52.9%");
        return smsContent.get(s);
    }

    private void moveTotherFolders(String dirName, String removeTo) throws IOException {
        long starTime = System.currentTimeMillis();
//        dirName = "D:\\ChinaPostTest\\ChinaPost";
//        removeTo = "D:\\ChinaPostTest\\ChinaPostBackups\\";

        File dir = new File(dirName);
        File[] files = dir.listFiles();
        int inx = 0;
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getAbsolutePath();
                if (fileName.endsWith("txt")) { // 判断文件名是否以.avi结尾
                    InputStreamReader read = new InputStreamReader(new FileInputStream(fileName), "UTF-8");// 考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    while ((lineTxt = bufferedReader.readLine()) != null) {
                        System.out.println(lineTxt);
                        inx++;
                    }
                    read.close();
                }
                System.out.println("开始移动文件...耗时：" + (System.currentTimeMillis() - starTime) + " Ms");
                File tmpFile = new File(removeTo);//获取文件夹路径
                if (!tmpFile.exists()) {//判断文件夹是否创建，没有创建则创建新文件夹
                    tmpFile.mkdirs();
                }
                files[i].renameTo(new File(removeTo + files[i].getName()));
                System.out.println("移动文件完成....耗时：" + (System.currentTimeMillis() - starTime) + " Ms");

            }
            System.out.println("File Size(" + files.length + "),Mobile Num (" + inx + ")读完了...耗时：" + (System.currentTimeMillis() - starTime) + " Ms");

        } else {
            System.out.println("没有该文件.");
        }
    }

    public static void writeTxtFile(String content, String file) throws Exception {
        FileWriter fw = null;
        File f = new File(file);
        if(!f.exists()){
            f.mkdirs();
        }
        try {
            // 如果文件存在，则追加内容；如果文件不存在，则创建文件
            fw = new FileWriter(f, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.println(content);
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取文件
     *
     * @return
     */
    public static List<String> getSmsTaskMobileByFile(String fileName) {
        int num = random.nextInt(1000);
        String encoding = "UTF-8";
        File fileF = new File(fileName);
        List<String> smsMobileList = new ArrayList<String>();
        try {
            if (fileF.isFile() && fileF.exists()) { // 判断文件是否存在s
                InputStreamReader read = new InputStreamReader(new FileInputStream(fileF), encoding);// 考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                int index = 0;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    smsMobileList.add(lineTxt.trim());
                    index++;
                }
                read.close();
            } else {
                System.out.println("找不到指定s的文件:" + fileName);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("获取号码文件异常");
        }
        return smsMobileList;
    }


}
