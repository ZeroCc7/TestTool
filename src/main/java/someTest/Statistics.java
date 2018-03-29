package someTest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Statistics {
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static String dispatchStartTime;
    public static String dispatchStopTime;
    public static volatile int tolSenSuccessNum;
    public static int tolSenFailNum;
    public static volatile long tolTaskNum;
    public static volatile int runningNum;

    public synchronized static void inc(int a) {
        tolTaskNum+=a;
    }
    public static void setDispatchStartTime(Date date) {
        if(date == null)
            Statistics.dispatchStartTime = "";
        else
            Statistics.dispatchStartTime = sdf.format(date);
    }

    public static void setDispatchStopTime(Date date) {
        Statistics.dispatchStopTime = sdf.format(date);
    }

}
