package NimGame;

public class NimPlayer {
    //protected  修饰符 package可见
    protected String userName;
    protected String familyName;
    protected String givenName;
    protected int playGameCount;
    protected int wonGameCount;

    //构造函数
    public NimPlayer(String userName, String givenName, String familyName) {
        this.userName = userName;
        this.givenName = givenName;
        this.familyName = familyName;
    }

    public void resetStat() {
        playGameCount = 0;
        wonGameCount = 0;
    }

    public void edit(String givenName, String familyName) {
        this.givenName = givenName;
        this.familyName = familyName;
    }

    //重写toString 返回一个字符串
    @Override
    public String toString() {
        return userName + "," + givenName + "," + familyName + "," + playGameCount + " games," + wonGameCount + " wins";
    }

    public double wonPercent() {
        return wonGameCount * 1.0f / playGameCount;
    }

    public String toFullName() {
        return givenName + " " + familyName;
    }

    public String toRankString() {
        return (playGameCount == 0 ? "0" : (wonGameCount * 100 / playGameCount)) + "%" + " | "
                + (playGameCount < 10 ? ("0" + playGameCount) : (playGameCount + "")) + " | "
                + givenName + " " + familyName;
    }
}
