package 设计模式;

/**
 * Created by Administrator on 2017/12/8 0008.
 */
public class PersonAdapter {

}
abstract  class Person{
    public  abstract void dessed();
}
class Boy extends Person{

    @Override
    public void dessed() {
        System.out.println("穿了内衣内裤");
    }
}
abstract  class PersonCloth extends Person{
    protected Person mPerson;
    public PersonCloth(Person mPerson){
        this.mPerson=mPerson;
    }
    public void dressed(){
        mPerson.dessed();
    }
}
