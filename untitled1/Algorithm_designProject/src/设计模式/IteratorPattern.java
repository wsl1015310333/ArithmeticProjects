package 设计模式;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/6 0006.
 */
/*
android 自身源码也提供了迭代器模式便利数据，Cursor游标对象

 */
public class IteratorPattern {
public static void main(String []args){
    Aggregate<String> a=new ConCreteAggregate<>();
    a.add("Aige");
    a.add("Studio\n");
    a.add("SM");
    a.add("Brother");
    Iterator<String> i= a.iterator();
    while(i.hasNext()){
        System.out.println(i.next());
    }
}
}
  interface Iterator<T>{
      boolean hasNext();
      T next();
  }
//具体迭代器
class ConcreteIterator<T> implements Iterator<T>{
    private List<T> list=new ArrayList<T>();
    private int cursor=0;
    public ConcreteIterator(List<T> list) {
    this.list=list;
    }
    @Override
    public boolean hasNext() {
        return cursor!=list.size();
    }
    @Override
    public T next() {
        T obj=null;
        if(this.hasNext()) {
        obj=this.list.get(cursor++);
        }
        return obj;
    }
}
interface Aggregate<T>{
    void add(T obj);
    void remove(T obj);
    Iterator<T> iterator();
}
class ConCreteAggregate<T> implements Aggregate<T>{
    List <T> list=new ArrayList<T>();
    @Override
    public void add(T obj) {
        list.add(obj);
    }
    @Override
    public void remove(T obj) {
list.remove(obj);
    }
    @Override
    public Iterator<T> iterator() {
        return new ConcreteIterator<T>(list);
    }
}



