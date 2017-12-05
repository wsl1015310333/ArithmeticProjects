/**
 * Created by Administrator on 2016/4/10 0010.
 */
public class PreferctNum1 {
    public static void main(String args[])

    {

        int i=1,j,add;

        String s;

        while(i<10000)

        {

            add=1;

            s=i+"=1";

            for(j=2;j<=i/2;j++)

            {

                if(i%j==0)

                {

                    s=s+"+"+j;//将因子转化成字符输出

                    add=add+j;

                }

            }

            if(i==add&&i!=1)

            {

                System.out.println(s);

            }

            i++;

        }

    }

}
