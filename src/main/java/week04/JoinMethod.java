package week04;

public class JoinMethod {
    public static void main(String[] args) throws InterruptedException {
        Result result = new Result();
        WorkThread workThread = new WorkThread();
        workThread.init(result);
        System.out.println("线程启动");
        workThread.start();
        System.out.println("线程等待");
        // 等待work线程运行完再继续运行
        workThread.join();
        System.out.println("线程执行结果：" + result.getValue());
    }
}

class WorkThread extends Thread {

    private Result result;

    public void init(Result result) {
        this.result = result;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000 * 10);//模拟程序执行
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        result.setValue("线程执行完毕，输出结果");
    }

}
