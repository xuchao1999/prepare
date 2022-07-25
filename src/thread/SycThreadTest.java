package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: SycThreadTest
 * @description: todo
 * @Author: Chao Xu
 * @Date: 2022/5/12 10:52
 **/
public class SycThreadTest {

    private static ReentrantLock reentrantLock = new ReentrantLock(false);
    public static void main(String[] args) {


        /*SycThread sycThread = new SycThread();
        Thread thread1 = new Thread(sycThread, "thread1");
        Thread thread2 = new Thread(sycThread, "thread2");
        thread1.start();
        thread2.start();*/


        /*Thread thread1 = new Thread(new SycThread(), "thread1");
        Thread thread2 = new Thread(new SycThread(), "thread2");
        thread1.start();
        thread2.start();*/

        new Thread(){
            public void run(){
                a();
            }
        }.start();
    }

    public static void a(){
        reentrantLock.lock();
        try {

            b();

            System.out.println("aaa");
        }  finally {
            reentrantLock.unlock();
        }
    }

    public static void b(){
        reentrantLock.lock();
        try {

            System.out.println("bbb");
        } finally {
            reentrantLock.unlock();
        }
    }
}
