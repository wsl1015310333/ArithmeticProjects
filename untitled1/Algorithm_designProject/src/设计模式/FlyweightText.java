package 设计模式;

import java.util.Random;

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

