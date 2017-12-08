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
//适配器就是将两个兼容的类融合在一起，他有点像粘合剂，将不同的东西通过一种转换使得他们能够协作起来
/*
适配器模式是把类的接口转换层客户端所期待的另一种接口，从而使原本因为接口不匹配而无法在一起的两个类能够在一起工作

使用场景
系统需要使用现有的类，而此类的接口不符合系统的需要，即接口不兼容
想要建设一个可以重复使用的类，用于一些彼此之间没有太大关联的一些类，
包括一些可能将引进来的类一起工作
需要一个统一输出接口，从而输入端的类型不可预知


增加一个Adapter层来隔离变化，将ListVIew需要的关于ItemView接口抽象到Adapter对象，并且在ListView内部调用Adapter这些接口完成布局等操作，
这样只要用户实现了Adapter接口，并且将该Adapter设置给ListVIew，ListVIew就可以按照用户设定的UI效果、数量、数据来显示每一项数据，ListView
最重要的问题就是要解决每一项Item视图的的输出，ItemtVIew千变万化，但终究它都是View类型，Adapte统一将ItemtView输出为VIew，这样很好
对应了Itemt VIew
 */


