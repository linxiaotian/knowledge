package week04;

import java.util.Vector;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchMethod {
    public static void main(String[] args) throws InterruptedException {
        Vector<Result> vectors = new Vector<Result>();//定义一个Vector做为存储返回结果的容器；
        final CountDownLatch countDownLatch = new CountDownLatch(5);
        // 启动多个工作线程
        for (int i = 0; i < 5; i++) {
            DoWorkThread workThread = new DoWorkThread(countDownLatch);
            workThread.init(vectors);
            workThread.start();
        }
        System.out.println("主线程等待工作线程执行");
        countDownLatch.await();
        for (int i = 0; i < vectors.size(); i++) {
            System.out.println(vectors.get(i).getValue());
        }

    }
}

class DoWorkThread extends Thread {
    private Vector<Result> vectors;

    private CountDownLatch countDownLatch;

    public DoWorkThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void init(Vector<Result> vectors) {
        this.vectors = vectors;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000 * 3);//模拟程序执行
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Result result = new Result();
        result.setValue(Thread.currentThread().getName() + "线程执行完毕，输出结果");
        vectors.add(result);//结果放入Vector中
        countDownLatch.countDown();
    }
}
