package someTest;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

import static someTest.DisplayProductInfoWithExecutorService.h;

public class DisplayProductInfoWithExecutorService {
    public  static Map<String,String> h = new HashMap();
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        int n = 10;//线程数
        int start = 0;//开始值
        int end = 1000000;//结束值
        int sum = 0;
        List<String> a = new ArrayList<>();

        ExecutorService threads = Executors.newFixedThreadPool(n);
        CompletionService<Integer> cs = new ExecutorCompletionService<Integer>(threads);
        for (int i = 0; i < 100; i++) {
            a.add(i + ":xx");
        }
        System.out.println("size：" + a.size());
        List<Future<Integer>> resultList = new ArrayList<Future<Integer>>();

        int size = a.size() / (n + 1);
        List[] subLists = splitList(a, size);
        System.out.println("subLists:" + subLists.length);
        for (List<String> sub : subLists) {
            System.out.println(sub);
            Future<Integer> su = cs.submit(new SumCallable(sub));
            resultList.add(su);
        }

//        threads.shutdown();//关闭service
        int sendSuccessNum = 0;
        for (Future<Integer> fs : resultList) {
            sendSuccessNum += fs.get();
           System.out.println(sendSuccessNum);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("和发送：" + sendSuccessNum + ",耗时：" + (endTime - startTime) + "ms");
    }

    /**
     * 拆分list
     */
    @SuppressWarnings("rawtypes")
    public static List[] splitList(List list, int pageSize) {
        int total = list.size();
        int pageCount = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
        List[] result = new List[pageCount];
        for (int i = 0; i < pageCount; i++) {
            int start = i * pageSize;
            int end = start + pageSize > total ? total : start + pageSize;
            List subList = list.subList(start, end);
            result[i] = subList;
        }
        return result;
    }


}


class SumCallable implements Callable<Integer> {
    private List<String> number;

    public SumCallable(List<String> number) {
        this.number = number;
    }

    @Override
    public Integer call() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        int sum = 0;
        for (String n : number) {
            if(h.get(n) == null){
                sum += 1;
                System.out.println(sdf.format(new Date())+" : "+Thread.currentThread().getName() + ":" + n);
                h.put(n,n);
            }else{
                System.out.println(sdf.format(new Date())+" : "+Thread.currentThread().getName() + "重复了:" + n);
            }
        }
        System.out.println(sdf.format(new Date())+" : sum =" + sum);
        return sum;
    }
}
