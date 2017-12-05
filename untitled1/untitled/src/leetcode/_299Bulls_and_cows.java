package leetcode;

/**
 * Created by Administrator on 2016/10/30 0030.
 */
public class _299Bulls_and_cows {
    public static void main(String args[]){
        System.out.println(getHint("1801","0118"));//位置对为A，选中数字为B
        System.out.println(getHint("1801","1810"));
    }

        public static String getHint(String secret, String guess) {
            int[] nCnt = new int[10];
            int aCnt = 0, bCnt = 0;
            char[] secChar = secret.toCharArray();
            char[] gusChar = guess.toCharArray();
            for (int i = 0; i < secChar.length; ++i) {
                if (secChar[i] == gusChar[i]) {
                    aCnt++;
                } else {
                    bCnt = (nCnt[secChar[i]-'0'] < 0) ? bCnt+1: bCnt;
                    bCnt = (nCnt[gusChar[i]-'0'] > 0) ? bCnt+1: bCnt;
                    nCnt[secChar[i]-'0']++;
                    nCnt[gusChar[i]-'0']--;
                }
            }
            return ""+aCnt +"A"+bCnt+"B";
        }
    }

