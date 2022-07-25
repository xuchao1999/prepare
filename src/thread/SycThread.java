package thread;

import java.lang.reflect.AccessibleObject;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: SycThread
 * @description:
 * @Author: Chao Xu
 * @Date: 2022/5/12 10:48
 **/
public class SycThread implements Runnable {

    private static Integer count;
    public SycThread(){
        count = 0;
    }

    public void run(){
        synchronized (this){
            for(int i = 0; i < 5; i++){
                synchronized (count){
                    System.out.println(Thread.currentThread().getName() + ": " + count++);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public int getCount(){
        return count;
    }
}
