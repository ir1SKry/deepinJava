package com.ustbcafe.deepin.thread;

/**
 * Created by Rudy Steiner on 2017/1/4.
 */
public class WaitNotify {
      final  static Sum sum=new Sum();
    public static class Reader extends  Thread{
        public void run(){

                synchronized (sum) {
                    System.out.println(System.currentTimeMillis() + ":Reader started!");
                    try {
                        sum.wait(1000);
                        System.out.println( sum.getSum());
                    } catch (InterruptedException ite) {
                        ite.printStackTrace();
                    }
            }
        }
    }
    public static class Writer extends Thread{
        public void run(){
            synchronized (sum){
                System.out.println(System.currentTimeMillis() + ":Writer started !");
                try {
                    Thread.sleep(2000);
                }catch (InterruptedException ite){
                    ite.printStackTrace();
                }
                sum.setSum(100);
                sum.notify();
                System.out.println(System.currentTimeMillis() + ":Writer end !");
            }
            //writer releas sum lock
        }
    }
    public static void main(String[] args){
        new Reader().start();
        new Writer().start();
    }
}
