package 设计模式;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/12/7 0007.
 */
/*
访问者模式是一种将数据操作与数据结构分离的设计模式，他是设计模式中最复杂的一个
软件模式中基本实现，软件系统中拥有一个由许多对象构成的，比较稳定的对象结构体，这些对象的类都拥有一个accept
方法用来接收访问者对象的访问，访问这是一个接口，它拥有一个visit方法，这个方法访问到的对象结构中不同类型的元素做出不同的处理，
在对象结构的一次访问过程中，我们遍历整个对象结构，对每个元素都实施accept方法，在每个元素的accept方法中调用访问者的visit方法，
从而使访问者得以处理对象结构的每一个元素，我们可以针对象结构设计部痛的访问者来完成不同的操作，达到区别对待的效果

封装一些作用于某种数据结构中的各元素的操作，他可以在不改变这个数据结构的前提下定义作用于这些元素都操作

访问者模式的使用场景
对象结构比较稳定，但经常需要在此对象结构定义新的操作
需要对一个对象结构中的对象进行很多不同的并且不相关的操作，而需要避免这些操作 ‘污染“
这些对象的类，也不希望在增加新操作时修改这些类

Android 源码中
在现阶段Android开发中，注解越来越流行起来，按照处理时期，注解又可以分为两种类型
一种运行时期注解，另一种编译期注解，,运行时注解由于性能问题，编程注解的核心原理依赖APT实现，例如，著名的ButterKnife、Dagger、Retrofit等开源库都是基于Apt，
那么编译器注解是如何工作的
   编译时Anonotatiion结息的基本原理是，在某些代码上（如类型，函数，字段等）添加注解，在编译时编译器会检查AbstracProcessor的子类，并且调用该类型的process函数
   ，然后添加注解的所有元素都传递到process函数中，使得开发人员可以在编译器进行相应的处理，例如，根据注解生成的新的java类，这也就是butterknife等呢过开源的基本原里

 */
public class VisitorTest {
    public static void main(String []args){
        BusinessReport report=new BusinessReport();
        System.out.println("=====给CEO看的报表======");
        report.showReport(new CEOVisitor());
        System.out.println("=====给CTO看的报表=====");
        report.showReport(new CTOVisitor());
    }
}
 abstract  class Staff{
    public String name;
     public int kpi;
     public Staff(String aName) {
        this.name=name;
         kpi=new Random().nextInt(10);
     }
     public abstract void accept(Visitor visitor);
}
class Engineer extends Staff{

    public Engineer(String aName) {
        super(aName);
    }

    @Override
    public void accept(Visitor visitor) {
             visitor.visit(this);
    }
    public int getCodeLines(){
        return new Random().nextInt(10*10000);
    }
}
 class Manager extends Staff
{
    private int produce;
    public Manager(String aName) {
        super(aName);
    produce=new Random().nextInt(10);
    }
    @Override
    public void accept(Visitor visitor) {
    }
    public  int getProduce(){
        return produce;
    }
}
class BusinessReport{
    List<Staff> mStaffs=new LinkedList<Staff>();
    public BusinessReport(){
        mStaffs.add(new Manager("王经理"));
        mStaffs.add(new Engineer("工程师-Shawn.Xioing"));
        mStaffs.add(new Engineer("工程师-Kael"));
        mStaffs.add(new Engineer("工程师-Chaossss"));
        mStaffs.add(new Engineer("工程师-Tiiime"));
    }
    public void showReport(Visitor visitor){
        for(Staff staff:mStaffs){
            staff.accept(visitor);
        }
    }
}
interface Visitor{
    public void visit(Engineer engineer);
    public void visit(Manager leader);
}
class CEOVisitor implements Visitor{

    @Override
    public void visit(Engineer engineer) {
        System.out.println("工程师: "+engineer.name+",KPI:"+engineer.kpi);
    }

    @Override
    public void visit(Manager leader) {
        System.out.println("经理:"+leader.name+",KPI:"+leader.kpi+",新产品数量："+leader.getProduce());
    }
}
class ReportUtil{
    public  void visit(Staff staff){
        if(staff instanceof Manager){
            Manager mgr=(Manager)staff;
            System.out.println("经理："+mgr.name+",kpi"+mgr.kpi+",新产品数量"+mgr.getProduce());
        }else {
            Engineer engineer=(Engineer)staff;
      System.out.println("工程师："+engineer.name+",KPI"+engineer.kpi);
        }
    }
}
class CTOVisitor implements Visitor{
    @Override
    public void visit(Engineer engineer) {
        System.out.println("工程师："+engineer.name+",代码函数："+engineer.getCodeLines());
    }
    @Override
    public void visit(Manager leader) {
        System.out.println("经理："+leader.name+"产品数量："+leader.getProduce());
    }
}

