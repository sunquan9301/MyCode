package NimGame;

import java.util.Scanner;

//game入口，里面包含一些属性，isFirstPlayer用于表示是第一个人先玩还是第二个人先玩。
//该类主要负责startGame();因此只执行startGame action
public class NimGame {
    private Nimsys nimsys;
    private int initStones;
    private int upperBound;
    private NimPlayer player1;
    private NimPlayer player2;
    private boolean isFirstPlayer;
    private Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        NimGame nimGame = new NimGame();
        //把 scanner当作参数传入nimsys;
        nimGame.nimsys = new Nimsys(nimGame.in);
        nimGame.start();
    }

    private void start() {
        System.out.println("Welcome to Nim");
        //循环处理，cache scanner readLine的时候可能抛出的异常。
        while (true) {
            try {
                System.out.println("");
                System.out.print("$");
                //trim()用于删除2边的空格。
                String command = in.nextLine().trim();
                doActionForCommand(command);
            } catch (IllegalArgumentException e) {
                //通过抛异常来中断程序的运行。
                break;
            }
        }
        //close方法的调用。 可能IllegalStateException 所以try cache
        try {
            if (in != null) {
                in.close();
            }
        } catch (Exception e) {

        }
    }

    //调用startswith判断是哪一个命令
    private void doActionForCommand(String command) {
        if (command.startsWith("startgame")) doActionForStartGame(command);
        else nimsys.doActionForCommand(command);
    }

    private void doActionForStartGame(String command) {
        //判断是否由空格隔开2部分，否则提示
        String[] param = command.split(" ");
        if (param.length > 2) {
            System.out.println("Please input correct syntax for startgame initialstones,upperbound,username1,username2");
            return;
        }
        if (param.length == 2) {
            String[] value = param[1].split(",");
            //附带的参数必须为4个
            if (value.length != 4) {
                System.out.println("Please input correct syntax for startgame initialstones,upperbound,username1,username2");
                return;
            }
            try {
                //value[2] value[3]为2个player的username;
                NimPlayer p1 = nimsys.findPlayerByName(value[2]);
                NimPlayer p2 = nimsys.findPlayerByName(value[3]);
                if (p1 == null || p2 == null) {
                    System.out.println("One of the players does not exist.");
                    return;
                }
                player1 = p1;
                player2 = p2;
                //valueof string -> int 会抛 NumberFormatException 需要try cache
                initStones = Integer.valueOf(value[0]);
                upperBound = Integer.valueOf(value[1]);
                startGameFinal();
            } catch (Exception e) {
                System.out.println("Please input correct count for initialstones and upperbound.");
            }
            return;
        }
        System.out.println("Please input correct syntax for startgame initialstones,upperbound,username1,username2");
    }

    //根据initStones拼出 ***
    private String getStoneStr() {
        String s = "";
        for (int i = 0; i < initStones; i++) {
            s += " *";
        }
        //substring1 是因为一开始 s += " *"; 前面有个空格
        return s.substring(1);
    }

    private void startGameFinal() {
        System.out.println();
        System.out.println("Initial stone count: " + initStones);
        System.out.println("Maximum stone removal: " + upperBound);
        System.out.println("Player 1: " + player1.toFullName());
        System.out.println("Player 2: " + player2.toFullName());
        isFirstPlayer = true;

        while (true) {
            System.out.println();

            System.out.println(initStones + " stones left: " + getStoneStr());
            System.out.println((isFirstPlayer ? player1.givenName : player2.givenName) + "\'s turn - remove how many?");
            while (true) {
                try {
                    String countStr = in.nextLine().trim();
                    int count = Integer.valueOf(countStr);
                    if (count <= 0 || count > Math.min(upperBound, initStones)) {
                        System.out.println();
                        System.out.println("Invalid move. You must remove between 1 and " + Math.min(upperBound, initStones) + " stones.");
                        System.out.println();
                    }
                    else {
                        initStones = initStones - count;
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Please input a number");
                }
            }
            //0的时候更新战绩，结束游戏
            if (initStones == 0) {
                System.out.println("Game Over");
                System.out.println((isFirstPlayer ? player2.toFullName() : player1.toFullName()) + " wins!");
                player1.playGameCount = player1.playGameCount + 1;
                player2.playGameCount = player2.playGameCount + 1;
                if (isFirstPlayer) player2.wonGameCount = player2.wonGameCount + 1;
                else player1.wonGameCount = player1.wonGameCount + 1;
                break;
            }
            //切换玩家
            isFirstPlayer = !isFirstPlayer;
        }
    }
}
