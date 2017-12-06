package 设计模式;

/**
 * Created by Administrator on 2017/12/6 0006.
 */
/*
    在状态模式应用就是Activity中的状态保存,也就是里面的onsaveinstancestate和onRestoreInstanceState，
    当Activit不是正常方式退出，且Activity在随后的时间内被系统杀死之前都会调用这两个方法让开发者人员有机会存储
    Actiivty相关的信息，并且下次返回Activity时恢复这些数据，通过这两个函数，提升用户体验
    例如用户在写了一大段表白短信后，此时一个电话打进来，用户的短信输入界面被退到后台，如果再打电话的过程中短信被系统杀死了
    那么在用户再次进入到短信应用时，上一次输入的内容将不会存在，Activity的状态存储机制就是为了应对这些情况出现的

      onSaveInstanceState和onRestoreInstanceState都是Activity中的函数，我们首先来分析onsaveInstanceState
      protected void onSaveInstanceSate（Bundler outState）
      {
     //存储当前窗口的视图树的状态
      outState.putBundler(WINDOS_HIERARCHY_TAG,mWIndow.saveHierarchyState());
      //储存Fragment状态
      Parcelable p=mFragment.saveAllState();
      if(p!=null){
      outState=putParcelable(FRAGMENTS_TAG,p)
      }
      //如果用户还设置了Activity的AcvtivityLifecyhclerCallbacks
      //那么调用这些ActiviytLifecyclerCallcaks的onSaveInstanceState进行存储
      getApplication().dispatchActivitySvaeInsatanmnceState(this,outState)

      上述OnSaveinstancestate函数中
      （1）存储窗口视图树的状态
      (2)存储Fragment的状态
      （3）调用Activity的ActivityLifecyclerCallback的onSaveInstanceState函数进行存储

      我们先看第一步 在这一步中windows对象中视图树中各个View状态存储到Bundler中，这样一来，
      当用户重新进入到Activity时，用户UI的结构，状态才会被重新恢复，以此来保证用户界面一致性，
      windows的具体实现类是PhoneWindows，我们看看 PhoneWindos中saveHierachySatte
      public Bundler saveHierarchySate(){
      Bundle outState=new Bundler();
      if(mContentParent==null){
      return oustate;
      }
      //通过SparSeArray 类来存储，这相当于一个key为整数型的map
      SparseArray<Parcelable>states=new SparseArray<Parcelable>();
      //调用mContentParentde1saveHierachyState方法，这个2mContentParent就是调用Activity的
      //setContentVIew函数设置的内容视图，他是内容视图的根节点，在这里存储整个视图树的结构
      mContentParent.savaHierachyState(States);
      //保存当前界面中了焦点VIew
      VIew foucuedView=m,ContentParent.findDFocus();
      if(focusedView!=null){
      if(focusedView.getId()!=View.NO_Id){
      outState.putInt(FOCUSED_ID_TAG,focusedView.getId();
      }else{
      }
      SpareArray<Parcelable>panelStates=new SpareArray<Parcelable>()
      if(panelstates.size()>0)
      outSize.putSparseParcelableArray(PANIELS_TAG,PanelStates);
      }
      if(mActionAbar!=null)
      {
      SparseArray<Parcelable>actionBarStates=new SparseArray{Parcelable>()
      mActionBar.saveHierarchyState(actionBarStates);
      outState.putSpparseParceArray(Action_bar_tag,actionbarStates)
      }
      return outState；
      }
      在saveHierarchyState函数中，主要是存储了与当前UI，ActionBar相关的view状态，这里用mContentParent来分析，
      这个mContentParent就是我们通过Activity的setcontentview函数设置的内容视图，它是整个内容视图的根节点，
      存储他层级结构的view状态也就是存储了用户界面的状态，mContentParent是一个viewGroup对象，但是，saveHierarchyState
      并不是在Viewgroup中，而是在viewgroup的父类VIew中，我们看看下面程序
      pubcli void saveHierachyState(sparseArray<Parceable>conteiner){
      dispatchSaveInstanceState(container)
      }

     protected void dispatchSaveInstanceState(SparceArray<Parcelable>container){
     if(mID!=NO_ID&&(mViewFlags&SAVE_DISABLED_MASK)==0)
     mPrivaterFlags&=~PFLAG_SATE_CALLED;
     if(mPrivateFlags&PFLAG_SAGE_STATE_CALLED)==0)
     }

      }
    上面代码主要是讲：
    1 注意 如果view没有设置id，那么这个状态将不会被存储
    2调用onsaveInstanceSatet函数存储自身状态
    3将自身状态放到container中，key为id，value为自身状态
    //view类默认存储的状态为空
    在view类中saveHierarchyStae函数中调用了，dispatchSaveInstanceState函数来存储自身的状态，
    而viewGroup则复写了dispatchSaveInstanceState函数来存储自身的状态以及子视图的状态，viewgroup
    的dispatchSaveInstanceStateInstanceStateh函数

   在vewgruop的dispatchSaveInstanceState函数中会调用super.dispatchSaveInstanceSate函数存储自身的状态，
   然后遍历所有的子视图，并且调用子视图的dispatchSaveInstanceStae函数来村出他他们状态，如果这个子视图
   Viewgroup类型，那么调用的是viewd的dispatchSaveInstanceStae函数，在view类的dispatchSaveInstancestate函数就是在
   view没有设置id时，这个view的状态不会被存储到不能bundler中，这个id就是我们平时在xml中通过android属性来设置的标识
   view‘的唯一id

   为什么这些id不能被存储，因为view的状态是通过SparseArray 来存储的，这相当于一个map，他的key是view的id，value为view
   的状态，这就意味着，当我们需要存储view的状态时，需要复写onSaveInstanceStae方法，将要存储的数据放到parcelable对象中，
   并且将让他返回，
   我们看看TextViuew实现
   它存储了TextView的start、end及文本信息
   调用了View的onsaveInstanceState函数之后就得到了viedw要存储的数据，此时执行到 这里以view的id为key，以状态为值
   存储到container（SparseArray类型中）
   if(state!=null)
   container.put(mID,state)
  经过一层一层的遍历，整个视图树状态就被保存起来
  存储完了windows视图树状态信息之后，便会执行存储Fragment中的状态信息，回退栈等2.
  这个存储Fragmen状态信息也是调用onSaveInstanceState方法，存储Fragment的view视图树
  状态，最后就是调用用户设置的ActivityLifecycleCallbacks的onSaveinstanceState方法
  让用户能够在做一些而外的处理，整个存储过程就完后了
    调用onSaveINstanceState是在activity被销毁之前，更确切的说就是在调用activityonstop之前，activity onstop方法2在
    activityThread 的performStopAcitiviyt函数中


    在performstopActivity函数中通过token从mactivity中获取到一个activityClientRecord对象，这个对象就存储了2Activit信息，
    我们的存储信息就保存到其中，获取到这个ActivityClientRecord之后，调用了performStopActivityInner函数
    （1）判断是否需要存储activity状态
    （2）如果需要存储activity状态，调用onSaveInstanceState函数
    （3）将状态信息存储到ActivityClinentRecord对象的state字段中
     （4）调用Activity的onstop方法
     也就是说执行onstop函数之前，系统会根据情况选择是否存储Activity状态，并且这些状态2存储到mactivty中，
     这个mactivity维护了一个activity信息表，当activity重新启动时，会从这些mActivity查询对应的ActivityClientRecord，
     如果这个记录对象中有状态信息，那么则会调用Actiivyt的onRestoreInstanceSate函数
     private Activity performLauncherActivity
     这个函数主要是执行了
     1构建activity
     2 创建一个Application
     创建context类型为contextImpl
     3关联appContext、Applicatoin对象到Actiivyt中
     4调用Activity的onCeate方法
     5调用Activity的onRestoreInstanceState恢复状态
     6.将Activity的信息记录对象存储到mActivityh中

    在第五处 系统会判断ActivityClientRecord对象中state是否为空，如果不为空则说明存储了该
    Activity的状态，此时就会调用，Activity的onCreate函数，使得用户可以在onCreate函数中恢复UI的状态
      在这个过程中，Activity扮演了Careker角色，负责恢复、恢复UI的状态信息，Actiivty、Fragment、View
      ViewGroup等对象为Originator角色，也就是需要存储状态的对象，Memoto则是由Bundler类扮演，Activity在停止之前
      会根据Activity的退出情景来询者是否需要存储状态，在重新启动该Activity时会判断ActivityClientRecord对象是否存储
      Activity状态，如果含有状态则调用Activity的onRestoreInstanceState函数，从而使得Activity的UI效果与上一次保持一致
      这样一来，就保证了在非正常情况下退出actiivyt时不会丢失数据的情况下，很好地提升了用户体验

      onSaveInstanceState调用时机
      在上文中我们说到，onSaveInstanceState并不是在每次Actiivty退出之前都会被调用，只是在某些特定情况下它才会被调用，那么这些特定场景又是什么
      （1）home键
      （2）长按Home键，选择这些运行其他的程序时
      （3）按下电源键
      （4）长按Home键，选择运行其他的程序
      （5）屏幕方向切换，
      （6）电话打入等情况发生
         一句话概括就是，不是用户主动退出某个Activity或者跳过其他Activity的情况下就会触发onSaveInstanceState，话句话来说
         onSveInstanceStae调用尊徐一个：未经你许可 销毁 会被调用

         使用较老的supoortv4包中 FragmentActiivty来用Fragment时，可能会遇到这样一个空指针异常
          原因是：如果一个Fragment保存视图状态为空，并且用户可见提示为真，那么result这个Bundler对象就不会被初始化，。
           但是若使用这个对象，就会导致空指针异常

           解决这个问题2就是复写FragmentActiivty中的onSaveInstanceState方法，不调用父类中的
           onSaveInstanceState，也就是说不保存该Activity的中所有的view’状态，这样也就不会调用到
           上述崩溃的代码了
           protected vodi onsaveInstaanceState(Bunndler onstate){

           }
           还有一种方法就是复写，Fragment中的onSaveInstanceState方法，在这个方法中随便存储一个数据
           publci claas MyFragment extends Fragment{
           public void onSaveInsatanceState(Bundler bundler){
           oustate.putString("do nor crash","Baby")；
           }
           }
           这样保证了原来的saveFragemnt‘BasicState中引发崩溃的result被指向Fragment存储状态的Bunder

           这样保证了原来saveFramentBasicState中引发崩溃的result对象被指向Fragment存储状态信息，
           Budnler对象，
           在App开发过程中尽肯能使用Framgnet代替Activty 但是framgne也有缺点：
           在使用Fragment中，只能选择使用默认的构造方法，，而不能自由构造我们想要的构造方法
          在嵌套使用Framgne很容易出现各种bug，或者是受限种种限制
          复杂的生命周期


          */

public class Originator {
    public static void main(String[] args) {

        CallOfDuty game = new CallOfDuty();
 game.play();
        Catetaker catetaker=new Catetaker();
        catetaker.archive(game.ceateMemoto());
        game.quit();
        CallOfDuty newGame=new CallOfDuty();
        newGame.reatore(catetaker.getmMemoto());
    }
}
class  CallOfDuty {



   public  int mCheckpoint = 1;
    public int mLifeValue = 100;
    public String mWeapon = "沙漠之鹰";

    public void play() {
        System.out.println("玩游戏" + String.format("第%d关", mCheckpoint) + "奋战中");
        mLifeValue -= 10;
        System.out.println("进度升级啦");
        mCheckpoint++;
        System.out.println("到达" + String.format("第%d关", mCheckpoint));
    }

    public void quit() {
        System.out.println("------");
        System.out.println("退出当前游戏属性" + this.toString());
        System.out.println("退出游戏");
        System.out.println("------");
    }

    public Memoto ceateMemoto() {
        Memoto memoto = new Memoto();
        memoto.mCheckpoint = mCheckpoint;
        memoto.mLifeValue = mLifeValue;
        memoto.mWeapon = mWeapon;
        return memoto;
    }

    public void reatore(Memoto memoto) {
this.mCheckpoint=memoto.mCheckpoint;
        this.mLifeValue=memoto.mLifeValue;
        this.mWeapon=memoto.mWeapon;
        System.out.println("恢复后的属性"+this.toString());
    }

    public int getmCheckpoint() {
        return mCheckpoint;
    }

    public void setmCheckpoint(int mCheckpoint) {
        this.mCheckpoint = mCheckpoint;
    }

    public int getmLifeValue() {
        return mLifeValue;
    }

    public void setmLifeValue(int mLifeValue) {
        this.mLifeValue = mLifeValue;
    }

    public String getmWeapon() {
        return mWeapon;
    }

    public void setmWeapon(String mWeapon) {
        this.mWeapon = mWeapon;
    }

    @Override
    public String toString() {
        return  "CallofDuty [mCheckpoint="+mCheckpoint+",mLifeValue="+mLifeValue+",mWeapon="+mWeapon+"]";
    }
}
class Memoto{
    public int mCheckpoint;
    public int mLifeValue;
    public String mWeapon;

    @Override
    public String toString() {
        return "Memoto [mCheckpoint="+mCheckpoint+",mLifeValue="+mLifeValue+",mWeapon="+mWeapon+"]";
    }
}

class Catetaker {
    Memoto mMemoto;

    public void archive(Memoto memoto) {
        this.mMemoto = memoto;
    }

    public Memoto getmMemoto() {
return mMemoto;
    }

}

