package assignment4_part02;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    //different menu main menu the entrance of system
    private Menu mainMenu;
    //service menu for engineer
    private Menu serviceMenu;
    //user menu for user to buy item
    private Menu userMenu;
    //record current menu
    private Menu curMenu;
    //mechine
    private VendingMachine vm;
    //input to get info
    private Scanner input;        // for KB input

    public static void main(String[] args) {
        Main m = new Main();
        m.init();
        m.start();
    }

    //init info
    private void init() {
        mainMenu = new Menu(Options.MainOption.MAIN_WELCOME, new String[]{Options.MainOption.PURCHASE_ITEMS, Options.MainOption.SERVICE_MODE, Options.MainOption.MAIN_QUIT});
        serviceMenu = new Menu(Options.ServiceOption.WELCOME,
                new String[]{Options.ServiceOption.ALL_ITEM_INFO, Options.ServiceOption.ADD_NEW_VENDITEM, Options.ServiceOption.RESTOCK_AN_ITEM, Options.ServiceOption.RESET_MECHINE, Options.ServiceOption.SWITCH_TO_USER_MODE, Options.ServiceOption.SERVICE_QUIT});
        userMenu = new Menu(Options.UserOption.WELCOME, new String[]{Options.UserOption.LIST_ITEM, Options.UserOption.ENTER_COIN, Options.UserOption.VIEW_MONEY, Options.UserOption.PURCHASE_ITEM, Options.UserOption.USER_QUIT});
        vm = new VendingMachine(Options.MACHINE_OWNER, Options.MAX_ITEM);
        vm.importItemsInfo("item.csv");
        curMenu = mainMenu;
        input = new Scanner(System.in);
    }

    private void start() {
        while (true) {
            try {
                //do action for different menu
                int chooseIndex = curMenu.getChoice();
                if (curMenu == mainMenu) doActionForMainMenu(chooseIndex);
                else if (curMenu == serviceMenu) doActionForServiceMenu(chooseIndex);
                else if (curMenu == userMenu) doActionForUserMenu(chooseIndex);
            } catch (Exception e) {
                if (e instanceof IllegalStateException) {
                    vm.exportItemsInfo("item.csv");
                    break;
                } else if (e instanceof IllegalArgumentException)
                    System.out.println("please input correct option index");
                else {
                    e.printStackTrace();
                    break;
                }
            }
        }
        try {
            input.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private void doActionForAddNewItem() {
        System.out.println("please input new item info with name and price splited with ,");
        //user n to exit menu
        while (true) {
            String pass = input.next();
            if (pass.equals("n")) break;
            String[] strs = pass.split(",");
            if (strs.length != 2) {
                System.out.println("please input correct info, n back to last opteration");
                continue;
            }
            String name = strs[0];
            String checkInfo = vm.checkIfAddItem(name);
            if (!checkInfo.equals("")) {
                System.out.println(checkInfo + ",please input new name, n back to last opteration");
                continue;
            }
            int price = 0;
            try {
                price = Integer.valueOf(strs[1]);
            } catch (Exception e) {
                System.out.println("please input correct price, n back to last opteration");
                continue;
            }
            vm.addNewItem(new VendItem(name, price));
            System.out.println("add success");
            break;
        }
    }

    private void doActionForRestockItem() {
        System.out.println(Arrays.toString(vm.listItems()));
        System.out.println("please input exist item name and new quantity splited with ,");
        while (true) {
            String pass = input.next();
            if (pass.equals("n")) break;
            String[] strs = pass.split(",");
            if (strs.length != 2) {
                System.out.println("please input correct info, n back to last opteration");
                continue;
            }
            String name = strs[0];
            if (!vm.checkIfExistItem(name)) {
                System.out.println("please input exist item name, n back to last opteration");
                continue;
            }
            //check the input quantity
            int quantity = 0;
            try {
                quantity = Integer.valueOf(strs[1]);
            } catch (Exception e) {
                System.out.println("please input correct quantity, n back to last opteration");
                continue;
            }
            if (quantity <= 0) {
                System.out.println("please input correct quantity, n back to last opteration");
                continue;
            }
            vm.restock(name, quantity);
            System.out.println("restock success");
            break;
        }
    }

    private void doActionForUserMenu(int chooseIndex) {
        if (chooseIndex == 1) System.out.println(Arrays.toString(vm.listItems()));
        else if (chooseIndex == 2) doActionForInsertCoin();
        else if (chooseIndex == 3) System.out.println("your current money is " + vm.getUserMoney());
        else if (chooseIndex == 4) doActionForPurchaseItem();
        else if (chooseIndex == 5) {
            vm.returnUserMoney();
            vm.resetForUser();
            curMenu = mainMenu;
        } else throw new IllegalArgumentException(chooseIndex + "");
    }


    private void doActionForPurchaseItem() {
        System.out.println(Arrays.toString(vm.listDetailItems()));
        System.out.println("please select item with index");
        while (true) {
            String inputStr = input.next();
            if (inputStr.equals("n")) break;
            int index = 0;
            try {
                index = Integer.valueOf(inputStr);
            } catch (Exception e) {
                System.out.println("please select correct index, n back to menu");
                continue;
            }
            String resultStr = vm.purchaseItem(index);
            System.out.println(resultStr + ", your current money is " + vm.getUserMoney() + ", please continue select item or n back to menu");
        }
    }

    private void doActionForInsertCoin() {
        System.out.println("please insert coin with 5(5p),10(10p),20(20p),50(50p),1(f1),2(f2)");
        while (true) {
            String pass = input.next();
            if (pass.equals("n")) break;
            if (!pass.trim().equals("5") && !pass.trim().equals("10") && !pass.trim().equals("20") && !pass.trim().equals("50") && !pass.trim().equals("1") && !pass.trim().equals("2")) {
                System.out.println("please insert correct coin, n back to last opteration");
                continue;
            }
            int coin = Integer.valueOf(pass);
            vm.insertCoin(coin);
            System.out.println("please continue insert coin, n back to last opteration");
        }
    }

    private void doActionForServiceMenu(int chooseIndex) {
        if (chooseIndex == 1) System.out.println(vm.getSystemInfo());
        else if (chooseIndex == 2) doActionForAddNewItem();
        else if (chooseIndex == 3) doActionForRestockItem();
        else if (chooseIndex == 4) vm.reset();
        else if (chooseIndex == 5) {
            curMenu = userMenu;
            vm.setStatus(Status.VENDING_MODE);
        } else if (chooseIndex == 6) {
            curMenu = mainMenu;
        } else throw new IllegalArgumentException(chooseIndex + "");
    }

    private void doActionForMainMenu(int chooseIndex) throws Exception {
        if (chooseIndex == 1) {
            curMenu = userMenu;
            vm.setStatus(Status.VENDING_MODE);
        } else if (chooseIndex == 3) throw new IllegalStateException("exit system");
        else if (chooseIndex == 2) {
            System.out.println("please input password");
            while (true) {
                String pass = input.next();
                if (pass.equals(Options.ADMIN_PASSWORD)) {
                    curMenu = serviceMenu;
                    vm.setStatus(Status.SERVICE_MODE);
                    break;
                } else if (pass.equals("n")) break;
                else System.out.println("please input correct passward, n back to last opteration");
            }
        } else {
            throw new IllegalArgumentException(chooseIndex + "");
        }
    }

}
