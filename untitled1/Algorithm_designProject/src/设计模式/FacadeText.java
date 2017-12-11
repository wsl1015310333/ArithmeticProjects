package 设计模式;

import javafx.scene.Camera;

/**
 * Created by Administrator on 2017/12/10 0010.
 */
/**
 *  再用android开发过程中，context最重要的一个类型，context一位上下文，也就是程序的运行环境
 *  ，他封装了很多重要的操作，如startActivity、sendBroadCast、bindService等，1因此
 *  context对开发者来说是重要的高层接口，coentext只是一个定义了很多借口的抽象类，这些接口的功能实现
 *  通过ActivityManagerService获取应用包相关的消息，则通过PackageManagerService，Context只是做了一个高层次的
 *  封装，正如上下文所示，contxt只是一个抽象类 ，他的真正实现在contextimpl类中，1contextImpl就是我们今天要分析的外观类
 *
 *  在本数据的前面章节，在启动时，首先会fork一个子进程，并且调用ActiivytTHrad.main方法启动该程序，ActiitytHread又会创建Application
 *  然后和Actiity、ComtextImpl关联起来，最后会调用Actiivyt的onCreate，onrresume函数使Activityh运行起来，此时应用的界面就成现在我们的眼前
 *  最后会调用Activiyt的onCreate onStart onResumt 函数使Activity运行起来 此时应用的用户界面 就成现在我们眼前，main函数会间接调用ActivityTread
 *  中的含handleLaunchActivity函数启动默认的的Activity，handleLaunchActivity
 *   在handleLauncher函数中调用perfromlaunchActivity函数执行Application、Contextimpl、activityu创建工作，并且通过Activity类attach函数
*   将这三者关联起来，
 */
//public class FacadeText {
//
//}
//class MobilePhone {
//    private Phone mPhone = new PhoneImpl();
//    private Camera mCamer=new SamsungCamera();
//    public void dail(){
//        mPhone.dail();
//    }
//    public void voideoChat(){
//        System.out.println(":---->");
//        mCamer.open();
//        mPhone.dai
//    }
//}
