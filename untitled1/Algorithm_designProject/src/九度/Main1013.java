package 九度;

import javafx.util.converter.IntegerStringConverter;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/8/21 0021.
 */
/*
题目描述：
    每天第一个到机房的人要把门打开，最后一个离开的人要把门关好。现有一堆杂乱的机房签到、签离记录，请根据记录找出当天开门和关门的人。
输入：
    测试输入的第一行给出记录的总天数N ( N> 0 )，下面列出了N天的记录。
    每天的记录在第一行给出记录的条目数M (M > 0 )，下面是M行，每行的格式为

    证件号码 签到时间 签离时间

    其中时间按“小时:分钟:秒钟”（各占2位）给出，证件号码是长度不超过15的字符串。
输出：
    对每一天的记录输出1行，即当天开门和关门人的证件号码，中间用1空格分隔。
    注意：在裁判的标准测试输入中，所有记录保证完整，每个人的签到时间在签离时间之前，且没有多人同时签到或者签离的情况。
样例输入：
3
1
ME3021112225321 00:00:00 23:59:59
2
EE301218 08:05:35 20:56:35
MA301134 12:35:45 21:40:42
3
CS301111 15:30:28 17:00:10
SC3021234 08:00:00 11:25:25
CS301133 21:45:00 21:58:40
样例输出：
ME3021112225321 ME3021112225321
EE301218 MA301134
SC3021234 CS301133
 */
public class Main1013 {
    public static void main(String[] args) {
        int N,M;
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            N=scan.nextInt();
            int i, j;
            int in=0,out=0;
            int hour,minute,secound;
            int inIime[]=new int[100];
            int outTime[]=new int[100];
            String input;
            String []ID=new String [100];
        for( i=0;i<N;i++){
                M= scan.nextInt();
            for(j=0;j<M;j++){
                String aaa=scan.nextLine();
                aaa=scan.nextLine();

                 String [] iinput=aaa.split(" ");
                 ID[j]=iinput[0];

               // String input=scan.nextLine();

                String []input1=iinput[1].split(":");
             //   String [] input1=iinput[1].split(":");
                hour=Integer.parseInt(input1[0]);
                minute=Integer.parseInt(input1[1]);
                secound= Integer.parseInt(input1[2]);
                inIime[j]=hour*3600+minute*60+secound;
                if(inIime[j]<inIime[in]){
                    in=j;
                }
                String []input2=iinput[2].split(":");
                hour=Integer.parseInt(input2[0]);
                minute=Integer.parseInt(input2[1]);
                secound= Integer.parseInt(input2[2]);
                outTime[j]=hour*3600+minute*60+secound;
                if(outTime[j]>outTime[out])
                {
                    out=j;
                }

            }
            System.out.print(ID[in]+" "+ID[out]);
        }
        }
    }
}
