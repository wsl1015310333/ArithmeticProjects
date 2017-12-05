import java.util.Scanner;

/**
 * Created by Administrator on 2016/4/3 0003.
 */

 class DATA{
        String key;
      int age;
    String name;
        }
public class SLType {
    public static int MAXKEN=100;
    DATA[] ListDATA=new DATA[MAXKEN+1];
    int length;
public static  void main(String [] args){
    SLType slType=new SLType();
    slType.SLInit(slType);
    Scanner scanner=new Scanner(System.in);

    do{
        System.out.println("输入添加的节点  学号 姓名  年龄");
        DATA data=new DATA();
        data.key=scanner.next();
        data.name=scanner.next();
        data.age=scanner.nextInt();
        //未完成

    }while(true);


}
    void SLInit(SLType LS){
        LS.length=0;
    }
    int  SLlength(SLType slType){
    return  slType.length;
    }
    int SLinsert(SLType slType,int n,DATA data){

    int i;
        if(slType.length<=n){
            System.out.println("分配内存失败");
        }
        for(i=slType.length;i>=n;i--){
            slType.ListDATA[i]=slType.ListDATA[i+1];
        }
        slType.ListDATA[n]=data;
        slType.length+=1;
        return 1;
    }
    int SLAdd(SLType slType,DATA data){
        if(slType.length>=MAXKEN){
            System.out.println("分配内存失败");
        }
        slType.ListDATA[++length]=data;
        return 1;

    }
    int Sldelete(SLType slType,int n){
        int i;
        if(n<0||slType.length+1<n){
            System.out.println("删除节点失败");
        }
        for(i=n;i<slType.length;i++){
            slType.ListDATA[i]=slType.ListDATA[i++];
        }
        slType.length--;
        return 1;
    }

     DATA DATASLFindByNum(SLType slType,int n){
         if(n<1||n>slType.length){
             System.out.println("节点序号错误，不能返回节点！");
             return null;
         }
         return slType.ListDATA[n];

    }
    int SLFindByNumCont(SLType slType,String key){
        int i;
    for(i=1;i<slType.length;i++){
        if(slType.ListDATA[i].key.compareTo(key)==0)
            return i;
    }
        return 0;
    }
    int SLAll(SLType slType){
        int i;
        for(i=1;i<=slType.length;i++){
            System.out.println(slType.ListDATA[i].key+" "+slType.ListDATA[i].name+slType.ListDATA[i].age);
        }
        return 0;
    }
}