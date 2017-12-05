import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2016/4/11 0011.
 */
public class Lianxi implements Runnable {

    public static void main(String[] args) throws InterruptedException{
        Thread t=new Thread(new Lianxi());
        t.start();
        Thread.sleep(2000);
        System.out.print("start");
        t.join();
        System.out.print("stop");
    }

    @Override
    public void run(){

        for(int i=0;i<10;i++){
            System.out.println(i);
        }
    }



}
