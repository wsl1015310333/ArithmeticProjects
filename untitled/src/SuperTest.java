/**
 * Created by Administrator on 2016/3/24 0024.
 */


public class SuperTest extends  Thread{
        private static final long serialVersionUID = 1L;
        private void test(){
            System.out.println(super.getClass().getName());
        }

        public static void main(String[]args){
            new SuperTest().test();
        }
    }