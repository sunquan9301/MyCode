package NimGame;//username: zhihangy   student ID: 1050720


import java.util.ArrayList;
import java.util.Scanner;

public class NimGame {
    private int initStones;
    private int upperBound;
    private NimPlayer player1;
    private NimPlayer player2;
    private boolean isFirstPlayer;


    //find the corresponding player based on the name
    public NimPlayer findPlayerByName(ArrayList<NimPlayer> allNimPlayer, String userName) {
        for (NimPlayer nimPlayer : allNimPlayer) {
            if (nimPlayer.userName.equals(userName))
                return nimPlayer;
        }
        return null;
    }

    public void doActionForStartGame(String command, ArrayList<NimPlayer> allNimPlayer, Scanner in) {
        //Determine whether 2 parts are separated by a space, otherwise prompt
        String[] param = command.split(" ");
        if (param.length > 2) {
            System.out.println("Please input correct syntax for startgame initialstones,upperbound,username1,username2");
            return;
        }
        if (param.length == 2) {
            String[] value = param[1].split(",");
            //The attached parameters must be 4
            if (value.length != 4) {
                System.out.println("Please input correct syntax for startgame initialstones,upperbound,username1,username2");
                return;
            }

            //value [2] value [3] must be the username of 2 players;
            NimPlayer p1 = findPlayerByName(allNimPlayer, value[2]);
            NimPlayer p2 = findPlayerByName(allNimPlayer, value[3]);
            if (p1 == null || p2 == null) {
                System.out.println("One of the players does not exist.");
                return;
            }
            player1 = p1;
            player2 = p2;

            initStones = Integer.valueOf(value[0]);
            upperBound = Integer.valueOf(value[1]);
            startGameFinal(in);
            return;
        }
        System.out.println("Please input correct syntax for startgame initialstones,upperbound,username1,username2");
    }

    //show the stars
    private String getStoneStar() {
        String s = "";
        for (int i = 0; i < initStones; i++) {
            s += " *";
        }
        //substring1 because there is a space at the beginning s + = "*"
        return s.substring(1);
    }

    private void startGameFinal(Scanner input) {
        System.out.println();
        System.out.println("Initial stone count: " + initStones);
        System.out.println("Maximum stone removal: " + upperBound);
        System.out.println("Player 1: " + player1.toFullName());
        System.out.println("Player 2: " + player2.toFullName());
        isFirstPlayer = true;

        while (true) {
            System.out.println();

            System.out.println(initStones + " stones left: " + getStoneStar());
            System.out.println((isFirstPlayer ? player1.givenName : player2.givenName) + "\'s turn - remove how many?");
            while (true) {
                try {
                    String countStar = input.nextLine().trim();
                    int count = Integer.valueOf(countStar);
                    if (count <= 0 || count > Math.min(upperBound, initStones)) {
                        System.out.println();
                        System.out.println("Invalid move. You must remove between 1 and " + Math.min(upperBound, initStones) + " stones.");
                        System.out.println();
                    } else {
                        initStones = initStones - count;
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Please input a number");
                }
            }
            //Update the record at 0 and end the game
            if (initStones == 0) {
                System.out.println("Game Over");
                System.out.println((isFirstPlayer ? player2.toFullName() : player1.toFullName()) + " wins!");
                player1.playGameCount = player1.playGameCount + 1;
                player2.playGameCount = player2.playGameCount + 1;
                if (isFirstPlayer) player2.wonGameCount = player2.wonGameCount + 1;
                else player1.wonGameCount = player1.wonGameCount + 1;
                break;
            }
        }
    }
}
