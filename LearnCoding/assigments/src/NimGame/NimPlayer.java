package NimGame;//username: zhihangy   student ID: 1050720

public class NimPlayer {
    
    public String userName;
    public String familyName;
    public String givenName;
    public int playGameCount;
    public int wonGameCount;

    //constructor
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

    //rewrite toString method to return a string
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
        return (playGameCount == 0 ? "0" : (int)((wonGameCount * 100f / playGameCount)+0.5)) + "%" + " | "
                + (playGameCount < 10 ? ("0" + playGameCount + " games") : (playGameCount + " games")) + " | "
                + givenName + " " + familyName;
    }
}
