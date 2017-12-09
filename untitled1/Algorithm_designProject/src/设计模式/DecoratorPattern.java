package 设计模式;

/**
 * Created by Administrator on 2017/12/8 0008.
 */
public class DecoratorPattern {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        Decorator decorator = new ConcreteDecoratorA(component);
        decorator.operate();
        Decorator decoratorB=new ConcreteDecoratorB(component);
decorator.operate();
    }
}
abstract  class Component{
    public abstract void operate();
}
 class ConcreteComponent extends Component{

    @Override
    public void operate() {
        System.out.println("This is Apply");
    }
}
abstract class Decorator extends Component{
    private Component component;
 public Decorator(Component component){
     this.component=component;
 }
    @Override
    public void operate() {
        component.operate();
    }
}
class ConcreteDecoratorA extends Decorator{

    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void operate() {
       operateA();
        super.operate();
    operateB();
    }
    public void operateA(){

    }
    public void operateB(){

    }

}
class ConcreteDecoratorB extends Decorator{

    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void operate() {
        operateA();
        super.operate();
        operateB();
    }
    public void operateA(){

    }
    public void operateB(){

    }

}


