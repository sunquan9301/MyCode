package NimGame;//username: zhihangy   student ID: 1050720

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Nimsys {
    private NimGame nimGame;
    protected Scanner input = new Scanner(System.in);
    protected ArrayList<NimPlayer> allNimPlayer = new ArrayList<>();


    public static void main(String[] args) {
        Nimsys nimsys = new Nimsys();
        nimsys.nimGame = new NimGame();
        nimsys.start();
    }

    private void start() {
        System.out.println("Welcome to Nim");
        //while processing, exceptions that may be thrown when cache scanner readLine
        while (true) {
            try {
                System.out.println("");
                System.out.print("$");
                String command = input.nextLine();
                doActionForCommand(command);
            } catch (IllegalArgumentException e) {
                //Interrupt the program by throwing an exception
                break;
            }
        }
        //call close method
        try {
            if (input != null) {
                input.close();
            }
        } catch (Exception e) {

        }
    }


    //determine what command need to execute
    public void doActionForCommand(String command) {
        if (command.startsWith("startgame")) nimGame.doActionForStartGame(command, allNimPlayer, input);
        else if (command.startsWith("addplayer")) doActionForAddPlayer(command);
        else if (command.startsWith("removeplayer")) doActionForRemovePlayer(command);
        else if (command.startsWith("editplayer")) doActionForEditPlayer(command);
        else if (command.startsWith("resetstats")) doActionForResetPlayerStats(command);
        else if (command.startsWith("display")) doActionForDisplayPlayer(command);
        else if (command.startsWith("rankings")) doActionForRankingPlayer(command);
        else if (command.startsWith("exit")) throw new IllegalArgumentException();
        else System.out.println("Please input correct command.");
    }

    //rank the player
    private void doActionForRankingPlayer(String command) {
        String[] param = command.split(" ");
        if (param.length > 2) {
            System.out.println("Please input correct syntax for rankings");
            return;
        }
        if (param.length == 2) {
            String order = param[1];
            //check if it is asc or desc
            if (!order.equals("asc") && !order.equals("desc")) {
                System.out.println("Please input correct syntax for rankings");
                return;
            }
            if (order.equals("asc")) {
                allNimPlayer.sort(new Comparator<NimPlayer>() {
                    @Override
                    public int compare(NimPlayer o1, NimPlayer o2) {
                        if (o1.wonPercent() == o2.wonPercent()) return o1.userName.compareTo(o2.userName);
                        if (o1.wonPercent() < o2.wonPercent()) return -1;
                        return 1;
                    }
                });
            } else if (order.equals("desc")) {
                allNimPlayer.sort(new Comparator<NimPlayer>() {
                    @Override
                    public int compare(NimPlayer o1, NimPlayer o2) {
                        if (o1.wonPercent() == o2.wonPercent()) return o1.userName.compareTo(o2.userName);
                        if (o1.wonPercent() < o2.wonPercent()) return 1;
                        return -1;
                    }
                });
            }
        } else {
            allNimPlayer.sort(new Comparator<NimPlayer>() {
                @Override
                public int compare(NimPlayer o1, NimPlayer o2) {
                    if (o1.wonPercent() == o2.wonPercent()) return o1.userName.compareTo(o2.userName);
                    if (o1.wonPercent() < o2.wonPercent()) return 1;
                    return -1;
                }
            });
        }
        for (NimPlayer nimPlayer : allNimPlayer)
            System.out.println(nimPlayer.toRankString());

    }

    //display the player
    private void doActionForDisplayPlayer(String command) {
        String[] param = command.split(" ");
        if (param.length > 2) {
            System.out.println("Please input correct syntax for displayplayer");
            return;
        } else if (param.length == 2) {
            boolean isExist = false;
            for (NimPlayer player : allNimPlayer) {
                if (player.userName.equals(param[1])) {
                    System.out.println(player.toString());
                    isExist = true;
                }
            }
            if (!isExist) System.out.println("The player does not exist.");
        } else if (param.length == 1) {
            allNimPlayer.sort(new Comparator<NimPlayer>() {
                @Override
                public int compare(NimPlayer o1, NimPlayer o2) {
                    return o1.userName.compareTo(o2.userName);
                }
            });
            for (NimPlayer player : allNimPlayer)
                System.out.println(player.toString());
        }
    }

    //reset the player statistics
    private void doActionForResetPlayerStats(String command) {
        String[] param = command.split(" ");
        if (param.length > 2) {
            System.out.println("Please input correct syntax for reset statistics");
            return;
        } else if (param.length == 2) {
            boolean isEdit = false;
            for (NimPlayer player : allNimPlayer) {
                if (player.userName.equals(param[1])) {
                    player.resetStat();
                    isEdit = true;
                }
            }
            if (!isEdit) System.out.println("The player does not exist.");
        } else if (param.length == 1) {
            System.out.println("Are you sure you want to reset all player statistics?(y/n)");
            while (true) {
                String opt = input.nextLine();
                if (opt.equals("y")) {
                    for (NimPlayer nimPlayer : allNimPlayer) {
                        nimPlayer.resetStat();
                    }
                    break;
                } else if (opt.equals("n")) break;
                else {
                    System.out.println("Please input correct opt(y/n)");
                }
            }
        }
    }

    private void doActionForEditPlayer(String command) {
        String[] param = command.split(" ");
        if (param.length != 2) {
            System.out.println("Please input correct syntax for edit player");
            return;
        }
        String[] names = param[1].split(",");
        if (names.length != 3) {
            System.out.println("Please input correct syntax for edit player");
            return;
        }
        boolean isExist = false;
        for (NimPlayer nimPlayer : allNimPlayer) {
            if (nimPlayer.userName.equals(names[0])) {
                isExist = true;
                nimPlayer.edit(names[2], names[1]);
            }
        }
        if (!isExist) System.out.println("The player does not exist.");
    }

    private void doActionForRemovePlayer(String command) {
        String[] param = command.split(" ");
        if (param.length > 2) {
            System.out.println("Please input correct syntax for removePlayer");
            return;
        } else if (param.length == 2) {
            if (!removePlayer(param[1])) {
                System.out.println("The player does not exist.");
                return;
            }
        } else if (param.length == 1) {
            System.out.println("Are you sure you want to remove all players? (y/n)");
            while (true) {
                String opt = input.nextLine().trim();
                if (opt.equals("y")) {
                    allNimPlayer.clear();
                    break;
                } else if (opt.equals("n")) break;
                else {
                    System.out.println("Please input correct opt(y/n).");
                }
            }
        }
    }

    private boolean isContainsPlayer(String userName) {
        for (NimPlayer player : allNimPlayer) {
            if (player.userName.equals(userName)) return true;
        }
        return false;
    }

    private boolean removePlayer(String userName) {
        int index = -1;
        for (int i = 0; i < allNimPlayer.size(); i++) {
            NimPlayer nimPlayer = allNimPlayer.get(i);
            if (nimPlayer.userName.equals(userName)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        } else {
            allNimPlayer.remove(index);
            return true;
        }
    }

    private void doActionForAddPlayer(String command) {
        String[] param = command.split(" ");
        if (param.length != 2) {
            System.out.println("Please input correct syntax for addplayer");
            return;
        }
        String[] names = param[1].split(",");
        if (names.length != 3) {
            System.out.println("Please input correct syntax for addplayer");
            return;
        }
        if (isContainsPlayer(names[0])) {
            System.out.println("The player already exists.");
            return;
        }
        if (allNimPlayer.size() == 100) {
            System.out.println("The maximum number of players is 100.");
            return;
        }
        allNimPlayer.add(new NimPlayer(names[0], names[2], names[1]));
    }
}
