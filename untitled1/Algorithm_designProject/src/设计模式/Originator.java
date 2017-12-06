package 设计模式;

/**
 * Created by Administrator on 2017/12/6 0006.
 */
public class Originator {
    public static void main(String[] args) {

        CallOfDuty game = new CallOfDuty();
 game.play();
        Catetaker catetaker=new Catetaker();
        catetaker.archive(game.ceateMemoto());
        game.quit();
        CallOfDuty newGame=new CallOfDuty();
        newGame.reatore(catetaker.getmMemoto());
    }
}
class  CallOfDuty {



   public  int mCheckpoint = 1;
    public int mLifeValue = 100;
    public String mWeapon = "沙漠之鹰";

    public void play() {
        System.out.println("玩游戏" + String.format("第%d关", mCheckpoint) + "奋战中");
        mLifeValue -= 10;
        System.out.println("进度升级啦");
        mCheckpoint++;
        System.out.println("到达" + String.format("第%d关", mCheckpoint));
    }

    public void quit() {
        System.out.println("------");
        System.out.println("退出当前游戏属性" + this.toString());
        System.out.println("退出游戏");
        System.out.println("------");
    }

    public Memoto ceateMemoto() {
        Memoto memoto = new Memoto();
        memoto.mCheckpoint = mCheckpoint;
        memoto.mLifeValue = mLifeValue;
        memoto.mWeapon = mWeapon;
        return memoto;
    }

    public void reatore(Memoto memoto) {
this.mCheckpoint=memoto.mCheckpoint;
        this.mLifeValue=memoto.mLifeValue;
        this.mWeapon=memoto.mWeapon;
        System.out.println("恢复后的属性"+this.toString());
    }

    public int getmCheckpoint() {
        return mCheckpoint;
    }

    public void setmCheckpoint(int mCheckpoint) {
        this.mCheckpoint = mCheckpoint;
    }

    public int getmLifeValue() {
        return mLifeValue;
    }

    public void setmLifeValue(int mLifeValue) {
        this.mLifeValue = mLifeValue;
    }

    public String getmWeapon() {
        return mWeapon;
    }

    public void setmWeapon(String mWeapon) {
        this.mWeapon = mWeapon;
    }

    @Override
    public String toString() {
        return  "CallofDuty [mCheckpoint="+mCheckpoint+",mLifeValue="+mLifeValue+",mWeapon="+mWeapon+"]";
    }
}
class Memoto{
    public int mCheckpoint;
    public int mLifeValue;
    public String mWeapon;

    @Override
    public String toString() {
        return "Memoto [mCheckpoint="+mCheckpoint+",mLifeValue="+mLifeValue+",mWeapon="+mWeapon+"]";
    }
}

class Catetaker {
    Memoto mMemoto;

    public void archive(Memoto memoto) {
        this.mMemoto = memoto;
    }

    public Memoto getmMemoto() {
return mMemoto;
    }

}

