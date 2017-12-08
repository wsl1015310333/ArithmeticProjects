package 设计模式;

/**
 * Created by Administrator on 2017/12/8 0008.
 */
public class AdapterText {

    public static void main(String []args){
        VoltAdapter adapter=new VoltAdapter();
        System.out.println("输出电压:"+adapter.getVolt5());
    }
}
interface FiveVolt{
    public int getVolt5();

}
class Volt220{
    public int getVolt220(){
        return 220;
    }
}
class VoltAdapter extends Volt220 implements FiveVolt{

    @Override
    public int getVolt5() {
        return 5;
    }
}

