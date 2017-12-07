package 设计模式;

/**
 * Created by Administrator on 2017/12/7 0007.
 */
public class MediatorPattern {
}
abstract class Mediator {
    protected ConCreteColleagueA ColleagueA;
    protected ConcreteColleagueB colleagueB;

    public abstract void method();

    public void setColleagueA(ConCreteColleagueA colleagueA) {
        ColleagueA = colleagueA;
    }

    public void setColleagueB(ConcreteColleagueB colleagueB) {
        this.colleagueB = colleagueB;
    }
}
class ConcreateMediator extends Mediator{

    @Override
    public void method() {
        colleagueB.action();
        ColleagueA.action();
    }
}
abstract  class Colleague{
    protected Mediator mediator;
   public Colleague(Mediator mediator){
       this.mediator=mediator;
   }
    public abstract void action();
}
 class ConCreteColleagueA extends Colleague{

    public ConCreteColleagueA(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void action() {
        System.out.println("ColleagueA 将信息交给中介者处理");
    }

}
class ConcreteColleagueB extends Colleague{

    public ConcreteColleagueB(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void action() {
        System.out.println("ColleagueB 将信息交给中介则处理");
    }
}