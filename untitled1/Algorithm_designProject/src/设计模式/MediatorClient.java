//package 设计模式;
//
//import sun.plugin2.gluegen.runtime.CPU;
//
///**
// * Created by Administrator on 2017/12/7 0007.
// */
//public class MediatorClient {
//
//}
////抽象中介者
//abstract class Mediator{
//    public abstract void changed(Colleague c);
//}
////主板中介者
//class MainBoard extends Mediator{
//private CDDvice cdDvice;//光驱设备
//private CPU cpu;//Cpu
//    private SoundCard soundCard//声卡设备
//    private GraphicsCard graphicsCard;//显卡设备
//    @Override
//    public void changed(Colleague c) {
//        if(c==cdDvice){
//            handleCD(CDDevice c);
//        }
//        else if(c==cpu){
//            handleCPU(CPU )
//        }
//    }
//}
//
