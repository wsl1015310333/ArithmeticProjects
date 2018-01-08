import sun.rmi.runtime.Log;

import java.util.*;

/**
 * Created by Administrator on 2016/4/11 0011.
 */
public class Lianxi implements Runnable {

    public static void main(String[] args) throws InterruptedException{
//        //集合一
//        List<String> _first=new ArrayList<String>();
//        _first.add("jim");
//        _first.add("tom");
//        _first.add("jack");
////集合二
//        List<String> _second=new ArrayList<String>();
//        _second.add("jack");
//        _second.add("happy");
//        _second.add("sun");
//        _second.add("good");
//
//        Collection exists=new ArrayList<String>(_second);
//        Collection notexists=new ArrayList<String>(_second);
//
//        exists.removeAll(_first);
//        System.out.println("_second中不存在于_set中的："+exists);
//        notexists.removeAll(exists);
//        System.out.println("_second中存在于_set中的："+notexists);
        List<Record> list=new ArrayList<>();
        Record record=new Record();
        record.setId("123");
        record.setName("wangxiaodong");
        list.add(record);
        Record record1=new Record();
        record1.setId("134");
        record1.setName("wangjianguo");
        list.add(record1);

        List<Record> listteu=new ArrayList<>();
        Record record11=new Record();
        record11.setId("123");
        record11.setName("wangxiaodong");
        listteu.add(record11);
        Record record111=new Record();
        record111.setId("134");
        record111.setName("wangjianguo");
        listteu.add(record111);


        Iterator<Record> it = list.iterator();
        while(it.hasNext()) {
            Record x = it.next();
            for (Record xx : listteu) {
                if (x.getId().equals(xx.getId())) {
                    it.remove();
                }
            }
        }



        Integer[] selects = new Integer[]{1,2,3};
        Integer[] input = new Integer[]{0,2,3,8,9};

        int index = 0;
        for (Iterator<Object> itt = input.iterator(); itt.hasNext();) {
    /*
     * 没有it.next();这一行， 就会抛出java.lang.IllegalStateException异常，原因<br>“
     * 要删除集合中某一个不满足条件的元素
     * ，通过Iterator来删除，首先需要使用next方法迭代出集合中的元素
     * ，然后才能调用remove方法，否则集合可能抛出java
     * .lang.IllegalStateException异常。”
     */
            itt.next();
            for (int select : selects) {
                if (select == index) {
                    itt.remove();
                }
            }
            index++;
        }
//        for(Record s:list) {
////        for(Iterator<Record> it = list.iterator(); it.hasNext();){
////            Record s = it.next();
//
//            for (Record read_alarmJson1 : listteu) {
//                if (s.getId().equals(read_alarmJson1.getId())) {
////                    list.remove(s);
//                    System.out.println(s.getId() + "---");
//                }
//            }
//        }
//        String  splilt []={"123","124"};
//
//        for(Record s:list) {
//            s.getId().equals()
//        }
      //  }

        for(Record attribute : list) {
            System.out.println(attribute.getId());
        }
    }

    @Override
    public void run(){

        for(int i=0;i<10;i++){
            System.out.println(i);
        }
    }



}
class Record{
    String name;
    String id;

    public void setId(String id){
        this.id=id;
    }
    public void setName(String id){
        this.name=name;
    }
    public String  getName(){
        return name;
    }
    public String  getId(){
        return id;
    }
}
