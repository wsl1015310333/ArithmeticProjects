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
synchronized
}
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