package 设计模式;

import java.util.Random;

//享元模式是对象池的一种实现，代表轻量级的意思，享元模式用来尽可能减少内存使用量
//它适合用于可能存在的大量重复对象的场景，来缓存可共享的对象，来缓存可共享的对象
//达到对象共享，避免创建过多的对象的效果，这样一来就可以提升性能，避免内存溢出
//享元模式的部分状态是可以共享的，可以共享的的状态成为内部状态，内部状态不会随着环境变化
//不可共享的状态则称之为外部状态，他们会随着的改变而改变，在享元模式中会建立一个对象容器，
//在经典的享元模式中该容器为一个map，它的键值对是享元对象的内部状态，他的值

/**
 * Created by Administrator on 2017/12/10 0010.
 */
public class FlyweightText {

}
interface Ticket{
    public void showTickeInfo(String bunk);
}
class TrainTicket implements Ticket{
    public String from;
    public String to;
    public String bunk;
    public int price;

  public  TrainTicket(String from,String to){
        this.from=from;
      this.to=to;
    }
    @Override
    public void showTickeInfo(String bunk) {
        price=new Random().nextInt(300);
        System.out.println("购买从"+from+"到"+to+"的"+bunk+"火车票"+",价格"+price);
    }
}
class TicketFactory{
    public static Ticket getTicket(String from,String to){
        return new TrainTicket(from,to);
    }
}

