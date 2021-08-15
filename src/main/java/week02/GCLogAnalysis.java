package week02;

import org.omg.CORBA.TIMEOUT;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

public class GCLogAnalysis {

    private static Random random = new Random();

    public static void main(String[] args) {
        long startMills = System.currentTimeMillis();
        long timeoutMills = TimeUnit.SECONDS.toMillis(1);
        long endMills = startMills + timeoutMills;
        LongAdder longAdder = new LongAdder();
        System.out.println("正在执行");
        int cacheSize = 2000;
        Object[] cacedGarbage = new Object[cacheSize];
        while (System.currentTimeMillis() < endMills) {
            Object garbage = generateGarbage(100 * 1024);
            longAdder.increment();
            int randomIndex = random.nextInt(2 * cacheSize);
            if (randomIndex < cacheSize) {
                cacedGarbage[randomIndex] = garbage;
            }
        }
        System.out.println("执行结束！共生成对象次数：" + longAdder.longValue());
    }

    private static Object generateGarbage(int max) {
        int randomSize = random.nextInt(max);
        int type = randomSize % 4;
        Object result = null;
        switch (type) {
            case 0:
                result = new int[randomSize];
                break;
            case 1:
                result = new byte[randomSize];
                break;
            case 2:
                result = new double[randomSize];
                break;
            default:
                StringBuilder builder = new StringBuilder();
                String randomString = "randomString-anything";
                while (builder.length() < randomSize) {
                    builder.append(randomString);
                    builder.append(max);
                    builder.append(randomSize);
                }
                result = builder.toString();
                break;
        }
        return result;
    }

}
