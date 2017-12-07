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
   对于编译器来说，代码中的元素结构不变的，例如，组成代码的基本元素有包、类、函数、字段、类型参数、变量。JDK中的为了这些元素定义了一个基类，也就是Element类，
  packageElement----包元素，包含了某个包下的信息，可以获取到包名等
  TypeELement---类型元素，如某个字段属于某种类型
  ExecutableElement---可执行元素，代表了函数类型的元素
  VariableElement----变量元素
  TypeParameterElement----类型参数元素
    因为注解可以指定作用在哪些元素上，因此，通过上述的抽象类对应这些元素
     @Target(element.type)
     @Retention(RetentionPolicy.Class)
     @interface Test{
     String value();
     }
     该注解只能作用于函数类型，因此，它对应的元素类型就是ExecutableElement，当我们想通过APT处理
     这个注解时就可以获取目标对象的Text注解，并且将所有这些元素转换为ExecutableElemenmt元素，
     以便获取到他们的对应信息
     public interface element{
     //代码省略
     //获取元素类型
     ElementKind getKind(){
     }
     //获取修饰符，如public、static、final 等
     Set<Modifier>getModifiers();
     <R,P> R accept<ElementVisitor<R,P>v,p,p);
     }
         我们看到Element定义了一代吗元素的一些通用接口，其中很显眼的就是accept函数，这个函数接受一个ElementVisitor和类型为P的参数，
         ElementVisitor就是访问者类型，而P则用于传递一些额外的从参数给Visitor，到这里读者应该明白访问者模式了
         public interface ElementVisitor<R,P>
         {
         R visit(Element e,P p);
         R visitPackage(PackageElement e,P p)
         R visitVariable(VariableElement e,P p)
         R visitExecutable<ExecutableElement e,P p)
         R visitTypePatameter(TypeParameterElement e,P p)
         R visitUnmknown(Element e,P p)
         }
            在 ElementVisitor中定义了多个visit接口，每个接口处理一种元素类型，这就是典型的访问者模式
            我们知道，一个类型元素和函数元素都是完成不一样的，他们的结构不一样，因此，编译器对他们的操作肯定不一样
            
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

