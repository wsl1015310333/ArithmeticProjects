package 设计模式;

/**
 * Created by Administrator on 2017/12/6 0006.
 */
/*
 在android AsyncTask 是比较常用的一种类型，这个类就是使用了模板方法模式，
 在使用Asynctask时，我们都知道把耗时的方法放在doInBackground（Params ..params)中，
 在doInBackground之前，如果还想做一些初始化操作，可以把实现写在onProExecute方法，
 而我们只需要构建Asynctask对象，然后执行execute方法即可，我们可以看到，调用execute
 会依次执行onPreExecute 、doInbackground、onPostExecute 当然也可以通过onprogressUpdate
 我们看看 execute
 可以看到execute方法是一个final 方法，它调用了executeOnexecutor方法，在该方法中判断该任务的状态
 ，如果不是PENDING状态则抛出异常，这也解释了为什么Asynctask只能够执行一次
 因为AsynctaskRunning和FinishHend状态都会抛出异常，因此，每次使用Asynctask时都需要重新创建一个对象
  在executeOnexecutor方法中首先执行了onPreExecute方法，因为Asynctask的需求是需要在UI线程中调用execut方法
  因此，onPreExecute方法也执行在UI线程，然后将params参数传递给mWorke对象的mParams字段，并且执行exec.execute(mFuture)
  方法
  mWorkr和mFuture又是什么：其实mWorker只是实现了Callable接口，并添加了一参数数组字段，我们分别来分析

   mFuture保证了这个Mworker对象，在这个mFuture对象的run函数中又会调用mWorker对象的call方法，在call方法中又调用了doInBackground
   ，因为mFuture提交给了线程池执行，所以，使得doInaBackground执行在非UI线程，得到doInBackground的结果，通过
   postResult传递给结果UI线程。得到 doInBackground 的结果 后通过postresult传递给UI线程，我们再看看postResult的实现
   从 程序中可以看到，postresult 就是把一个消息msg.what==MESSAGE_POST_RESULT发送sHandler，sInternalHandler类型，
   当InternalHandler接到MESSAGE_Post——Result类型的消息时就会调用result.mTask.finish(result.mData[0]方法，
   AsynctaskResult类型

   从上述程序中可以看到meTask就是Asynctask对象，调用AsyncTask对象的finish方法时又调用了onPostExecute
     总之， execute方法内部封装了onPreExecute、doInBackGround、onPreExecute这个逻辑流程
     用户可以根据自己的需求在复写这几个方法，使得用户可以很方便使用异步任务来完成耗时的操作以及更新UI
     这其实就是通过线程池来执行耗时的任务，得到结果之后，通过Hanlder将结构传递给UI线程来执行


     另一个 模板模式就是Activitiyh的生命周期函数，例如，Activity从启动到显示到窗口中会经过以下过程
     onCraate onStart onResumt 这就是一个典型的Activity启动流程，也是一个模板方法的运用
         我们知道，在androiud系统启动时，第一个启动起来的进程就是zygore进程，然后由zygote启动systemServer，在后就是
         启动ActivitymanageServer、WindowsMangerService 等系统核心服务与进程之外
         普通的用户进程也是由zygote进程fork而来的，当一个应用进程启动
 */
public class AbsTemplate {
    public  static  void main(String []args){
        AbstractComputer  computer=new CoderComputer();
        computer.startUp();
        computer=new MilitaryComputer();
        computer.startUp();
    }
}
abstract  class AbstractComputer{
    protected void powerOn(){
        System.out.println("开启电脑");
    }
    protected void checckHardware(){
        System.out.println("硬件检查");
    }
    protected  void loadOS(){
        System.out.println("载入操作系统");
    }
    protected void login(){
        System.out.println("小白的计算机无验证,直接进入系统");
    }
    public final void startUp(){
        System.out.println("-----开机start------");
      powerOn();
        checckHardware();
        loadOS();
        login();
        System.out.println("-----关机 END ------");
    }



}
class CoderComputer extends AbstractComputer{
    @Override
    protected void login() {
        System.out.println("程序员员只需要进行用户和密码验证就可以了");
    }
}
class MilitaryComputer extends AbstractComputer{
    @Override
    protected void checckHardware() {
        super.checckHardware();
        System.out.println("检查硬件防火墙");
    }

    @Override
    protected void login() {
        System.out.println("进行指纹识别等复杂的用户验证");
    }
}


