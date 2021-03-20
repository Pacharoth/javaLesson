public class ThreadTest {
    public static void main(String[] args) {//Main thread
        MyRunnable runnable = new MyRunnable("Th", 300);
        Thread th = new Thread(runnable);//new class implements Runnable interface
        th.start();
        Thread th2 = new Thread(ThreadTest::ActionTh2);//Method ref
        th2.start();
        Thread th3 = new Thread(()->{//Lambda
            
        });
        Thread th4 = new Thread(new Runnable() {//Anonymous class
            @Override
            public void run() {
                
            }
        });
        for(int i=1;i<1000;i++){
            System.out.println("Main " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void ActionTh2(){
        for(int i=1;i<=1000;i++){
            System.out.println("Th2 "+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e){ }
        }
    }
}
class MyRunnable implements Runnable{
    private String prefix;
    private int delay;
    public MyRunnable(String prefix, int delay){
        this.prefix = prefix;
        this.delay = delay;
    }
    @Override
    public void run() {//Child thread
        for(int i=1;i<=1000;i++){
            System.out.println(prefix+" "+i);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}