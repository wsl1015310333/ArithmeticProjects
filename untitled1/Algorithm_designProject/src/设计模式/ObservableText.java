package 设计模式;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Administrator on 2017/12/5 0005.
 */
/*
它最常用的地方就是GUI系统、订阅发布系统，因为这个模式的一个重要作用就是解耦，将被观察者和观察者解耦，使得他们之间的依赖性变小
甚至做到毫无依赖，以GUI系统来说，应用的UI具有易变性，尤其是前期随着业务的改变或者产品的需求修改，应用界面也会经常变化，
但是页面逻辑基本变化不大
此时，GUI系统需要一套机制来应对这种情况，使得UI层与具体的业务解耦。

观察者模式的定义
定义对象间一对多的依赖关系，使得每当一个对象改变状态，则所有依赖他的对象都会通知并被更新被自动更新

观察则模式的使用场景
关联行为场景，需要注意的是，关联行为是可拆封的，而不是组合关系
事件多级触发场景
跨系统的消息交换场景，如消息队列，事件总线的处理机制


ListView是Android中最重要的组件之一，而listview最重要定义功能就是Adapter，
后面我们会分析Adapter模式，通常，在我们往ListView添加数据后，都会调用Adapter
norifyDataSetChaned()方法，这是为什么呢
第一步我们就跟进这个方法，norifyDataSetChanged，这个方法定义在BaseAdapter

public abstarct class BaseAdapter implements ListAdapter ,SpinnerAdapter{
private final DattaSetObservable mDataSetObservable =new DataSetObseVale();
public void registerDataSetObserver(DataSetObserver observer){
mDataSetObsedrvable.unregisterObserver(observer);
}
public void norifyDataSetChanged(){
//当数据集变化，通知所有的观察者
mDataSetObservable.norifyChanged()
}
我们看看mDataSetObserver.norifyChanged()函数中看
public class DataSetObservable extends Observable<DataSetObserver>{
public void notifyChanged(){
synchronized（mObservers）{
for (int i=mObservers.size()-1,i>=0;i++){
mObservers.get(i).onChanged();
}
}
}
}
这个代码很简单，就是砸死mDatasetObservable.norifyChanged中遍历所有的观察者
并调用他们车onchanged方法，从而告知观察者发生了变化

   那些观察者是从哪里来的呢， 其实这些贯彻着就是listview通过setAdapter方法设置
   Adapter产生的
   public void setAdapterI(ListAdapter adapter){
   if(mAdapter!=null&&mDSataSetObserver!=null({
   mAdapter.unregisterDataSetOBserver(mDataSetObserver)
   }
   super.setAdapter(adapter)
   if(mAdapter!=null){
   mAreAllItemSelectable=mAdapter.areAllItemsEnabled();
   mOldItemCoutn=mItemCount();
   mItemCount=mAdaspter.getCount();
   checkFDorcus();
   mDataSetObserver=new AdapterDataSetObserver();
   mAdapter.registerDataSetObserver(mDataSetObserver);
   }
   else{
   ...
   }
   }
    从程序中可以看到，在设置Adapter时会创建一个AdapterDataSetObserver，这就是上面所说是的观察者，
    最后将这个观察者注册到Adapter中，这样我们的观察者】被观察者都有了，
    AdapterDataSetObserver是什么？他是如何运作的，
    AdatperDatasetObserver，AdatpterDataSetObsedr定义在LIstview的父类AbsListVIew中，
    class AdapterDataSetObsedrver extends AdapterVIew（ListVIew）.AdapterDataSetObser{
    public void onCHanged(){
    super.onChanged();
    if(mFastScroller!=null){
    mFastScroller.onSectionsChanged();
    }
    }
    public void onInvalidated(){
    super.onInvalidated();
    if(mFasScroller!=null){
    mFastScroller.onSectionsChanged();
    }
    }
    }
     它又继承了AbsListVIew的父类，AdapterVIew的AdapterDataSetObserver
     class jkAdatperDataSetObserver extends DataSetObsedrver{
     private Parcelable mInstanceState=null;
     public void on Changed(){
     mDataChanged=true;
     mOldItemCount=mIntemCount;
     mItemCount=getAdapte()-getCount();
     if(AdapteView.this.getAdapte().hasStableIds)(&&mInstanceState!=nullAdaterView.this.onRestoreInstanceState(mInstanceState)；
     mInstanceState=null;
     }else{
     rememberSyncState();
     }
     checkForcus();
     reqauestLayout();
     }
     public void clearSavedState(){
     mInstanceState=null;
     }
     到这里我们就知道了，当listeview数据变化的时候，调用Adapte的notifyDataSetChanged函数，
     这个函数会调用DataSetObservable的norifyChanged函数，这个函数会调用所有观察者AdapteDataSetObservable
     的onchanged方法，1在onchanged函数中又会调用Listviedw重新布局的函数使得Lisetview刷新界面，
     这既是一个观察者模式
  AdapteVIew中有一个内部类AdapteDataSetObservable，在listview中设置Adapte时会创建一个AdapteDataSetObserver，并且
  注册到Adapte中，这就是一个观察者，erAdapte中包含一个数据集可观察者DataSetObservable，在数据集发生变更时，开发者手动调用
  Adapter.norifyDataSetChanged ,而notifyDataSetChanged实际上会调用AdapteDataSetOsedrver的onChanged函数怒，该函数会遍历所有的观察者，onChanged函数，在Adapte
  DataSetObser的onchanged函数中获取Adapte中数据记得新数量

  BroadCastReceiver他作为应用内，进程间的一种重要通信手段，能够将某个消息通过广播形式传递给他的注册的对应广播接收器的对象，
  接受对象需要通过context的registerReceiver函数注册到Ams中，当通过sendBroadCast发送广播时，所有注册了对应的IntentFilter的
  BroadCastReceiver对象就会接收到这个消息，BroadCastReceiver的onreceive方法就会被调用

     我们发现registerReceiver函数并不是在Activity中实现，因此，我们把目标移到Activity父类ContextWrapper
     resisterReceiver函数中
     public class ContextWrapper extends Context{
     Context mBase;
     public Intent registerReceiver{{
     BroadCasttReceiver receiver,intentFilter filter){
     return mBase.registerReceiver(receiver,filter)
     }
     }
     }
     这里的成员变量吗mBase，我们讲过这个mBase对象是一个ContextImpl类的实例
     继续转移到COntextImpl的ergisterreceiver函数

     class ContextImpl extends Context{
     publci intent regiterReceiver(broadcastreceiver receiver,IntentFilter filter){
     return registerReceiver(receiver ,filter,null,null)；
     }
     publci Intent registerReceiver(BroadCastReceiver receiver,IntentFIlter filter,String broadCastPermission
     Handler sceduler){
     return registerReceiverInternal(receiver ,filter,broadcastPermission,schedulter,getOuterContext());
     }
     private Intent registerRecevierIntentnal(BroadCastRecevier receiver,IntentFIlter filter,String broadCastPerssion,Handler scheduler
     ,Context context){
     IIntentReceiver rd=null;
     if(receiver!=null){
    if(mPackageInfo!=null&&context!=null)
    {
    if(scheduler==null){
    scheduler=mMaintHREAD.mMainTHread.getHanler();//获取Handler来投递的消息
    }
    //获取IItenteReceiver对象，通过他与AMS交互，并且通过Handler传递消息
    rd =mPackagedInfo.getReceiverDisaptcher(receiver,context,scheduler,mMainThread.getInstrumentation(),true);
    }else{

    }
     }
     try{
     //调用ActivitMangerNative的RegisterRecever
     return ActivityM<anagerNative.getDefault().registerReceiver(
     mmainThread.getApplicationTHread(),rd,filter,broadCastPermission);
     }
     }
     }
     注册广播接收器的函数调用的最终进入到了ContextImpl的registerReceiver这个函数，
     这个里面的成员变量，吗，PackAgeInfo是一个LoaderAPK实例，它是用来负责处理广播的接收，
     参数broadCastpermssion和scheduler都是为null，而参数context是上面的的函数通过调用函数getOuterContext得到
     这里他指向的是MainActivyt
       由于条件mPageInfo！=null和context！=null都成立
       ，而且条件scheduler==null也成立，于是就调用mMainThread.getHandler来获取到一个Handler
       这个handler是用来分发ActivityManagerService发送过的广播
       这里的成员变量mMainThread是一个ActivityThrad实例，我们先来看看，
       ActivityThread.getHandler函数的实现，然后再回头过来继续分析ContextImpl.registerReceiverInternal函数
       public final classs ActivityThread{{
       final H mH=new H();
       private final class H extends Handler{
       public void handlerMessage(Message msg){
       switch(msg.what)
       {
       }
       }
       final Handler getHandler(){
       return mH;
       }
       }
       }
       有了这个Handler之后，就可以分析消息给应用程序处理了，
       在回到上一步ContextImpl.registerReceiverInternal函数中，他通过mPackageInfo.getReceiverDispatevher函数获取到一个IIntentReceiver
       接口对象rd，zheshiyigeBinder对象，接下来会把它传递到ActivityManagerSErviece，Activity《MangerServiec在收到相应的广播时
       就通过这个人Binder对象来通知MainActiviyt来接收我们看看mPackageinfo.getReiverDispatcher函数实现
       final class LoaderAPk{
       public IIntentReciever getReceiverDispatcher(Broadcasrecie r,Context context,Handler handler,Instrumentation,boolean registreerd
      )
      yy
       }
      */


public class ObservableText {
        public static void main(String args[]) {
            DevTechFrontier devTechFrontier = new DevTechFrontier();
            Coder coder1 = new Coder("mr.wsl");
            Coder coder2 = new Coder("code1");

            devTechFrontier.addObserver(coder1);
            devTechFrontier.addObserver(coder2);
            devTechFrontier.postNewPublication("Android程序设计");
        }
    }

class DevTechFrontier extends Observable {
    public void postNewPublication(String content) {
        setChanged();
        notifyObservers(content);
    }
}
class Coder implements Observer {
    public String name;

    public Coder(String aName) {
        name = aName;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Hi" + name + "更新内容为" + arg);
    }

    @Override
    public String toString() {
        return "码农" + name;
    }
}