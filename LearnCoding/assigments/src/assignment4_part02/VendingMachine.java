package assignment4_part02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class VendingMachine {
    private String owner;
    private int maxItems;
    private int itemCount = 0;
    private VendItem[] stock;
    private double totalMoney;
    private double userMoney;
    private Status vmStatus;
    private HashMap<Integer, Integer> moneyValueMapCountInMechine = new HashMap<>();


    public VendingMachine(String owner, int maxItems) {
        this.owner = owner;
        this.maxItems = maxItems;
        stock = new VendItem[maxItems];
    }

    public double getUserMoney() {
        return userMoney;
    }

    private String getAllSockInfo() {
        String info = "";
        for (int i = 0; i < itemCount; i++) {
            info += "VendItem" + i + ":" + stock[i].toString();
        }
        return info;
    }

    public String getSystemInfo() {
        return "  =======Detail Info About the Mechine=======  \n"
                + "owner : " + owner + "\n"
                + "maxItems : " + maxItems + "\n"
                + "itemCount : " + itemCount + "\n"
                + "totalMoney : " + totalMoney + "\n"
                + "totalMoney detail: " + moneyValueMapCountInMechine.toString() + "\n"
                + "userMoney : " + userMoney + "\n"
                + "vmStatus : " + vmStatus.getStatus() + "\n"
                + "all stock Info: \n" + getAllSockInfo() + "\n";
    }

    public void reset() {
        userMoney = 0;
        totalMoney = 0;
        itemCount = 0;
        stock = new VendItem[maxItems];
    }

    public void resetForUser() {
        userMoney = 0;
    }

    //to calcuate if the combine of money can returen user money
    private boolean canBuySucc(double price) {
        double remainMoney = userMoney - price;
        int intRemainMoney = (int) remainMoney;
        if (intRemainMoney != remainMoney) return false;
        int[] coinCount = new int[]{moneyValueMapCountInMechine.getOrDefault(2, 0), moneyValueMapCountInMechine.getOrDefault(1, 0), moneyValueMapCountInMechine.getOrDefault(50, 0), moneyValueMapCountInMechine.getOrDefault(20, 0), moneyValueMapCountInMechine.getOrDefault(10, 0), moneyValueMapCountInMechine.getOrDefault(5, 0)};
        int[] coinsValue = new int[]{200, 100, 50, 20, 10, 5};
        return validBuySucc(intRemainMoney, coinCount, coinsValue, false);
    }


    //after user quit the user mode menu, return user money
    public void returnUserMoney() {
        int[] coinCount = new int[]{moneyValueMapCountInMechine.getOrDefault(2, 0), moneyValueMapCountInMechine.getOrDefault(1, 0), moneyValueMapCountInMechine.getOrDefault(50, 0), moneyValueMapCountInMechine.getOrDefault(20, 0), moneyValueMapCountInMechine.getOrDefault(10, 0), moneyValueMapCountInMechine.getOrDefault(5, 0)};
        int[] coinsValue = new int[]{200, 100, 50, 20, 10, 5};
        validBuySucc((int) userMoney, coinCount, coinsValue, true);
    }

    //the core method to valid if mechine can return money  with the combine of different coins
    private boolean validBuySucc(int value, int[] coinCount, int[] coinsValue, boolean returnUserMoney) {
        if (value == 0) {
            if (returnUserMoney) {
                for (int i = 0; i < coinCount.length; i++) {
                    moneyValueMapCountInMechine.put(coinsValue[i], coinCount[i]);
                }
            }
            return true;
        }
        for (int i = 0; i < coinCount.length; i++) {
            if (coinCount[i] == 0) continue;
            if (value >= coinsValue[i]) {
                coinCount[i]--;
                return validBuySucc(value - coinsValue[i], coinCount, coinsValue, returnUserMoney);
            }
        }
        return false;
    }

    public String purchaseItem(int index) {
        if (vmStatus == Status.SERVICE_MODE) return "mechine is in service mode";
        if (index < 0 || index >= itemCount) return "please select correct item";
        if (stock[index].getQty() <= 0)
            return "the VendItem : " + stock[index].getName() + " is empty";
        if (userMoney < stock[index].getPrice()) return "your cur money is not enough";
        if (canBuySucc(stock[index].getPrice())) {
            stock[index].decrement();
            totalMoney = totalMoney - stock[index].getPrice();
            userMoney = userMoney - stock[index].getPrice();
            return "Thanks for purchasing : " + stock[index].getName();
        }
        return "mechine don't have money to change";
    }

    public boolean insertCoin(int cash) {
        if (cash != 5 && cash != 10 && cash != 20 && cash != 50 && cash != 1 && cash != 2) return false;
        if (cash == 1 || cash == 2) {
            userMoney = userMoney + cash * 100;
            totalMoney = totalMoney + cash * 100;
        } else {
            userMoney = userMoney + cash;
            totalMoney = totalMoney + cash;
        }
        moneyValueMapCountInMechine.put(cash, moneyValueMapCountInMechine.getOrDefault(cash, 0) + 1);
        System.out.println("your current money is " + userMoney);
        return true;
    }

    public boolean addNewItem(VendItem item) {
        stock[itemCount++] = item;
        return true;
    }

    public String[] listItems() {
        String[] names = new String[itemCount];
        for (int i = 0; i < itemCount; i++) {
            names[i] = stock[i].getName() + "," + stock[i].getQty();
        }
        return names;
    }

    public String[] listDetailItems() {
        String[] names = new String[itemCount];
        for (int i = 0; i < itemCount; i++) {
            names[i] = "index:" + i + ";name:" + stock[i].getName() + ";quantity:" + stock[i].getQty() + ";price:" + stock[i].getPrice();
        }
        return names;
    }

    public void setStatus(Status status) {
        this.vmStatus = status;
    }

    //import items for file
    public void importItemsInfo(String path) {
        try {
            String s = HelpUtil.read(new BufferedReader(new FileReader(path)));
            String[] str = s.split("\n");
            maxItems = Math.max(str.length, maxItems);
            for (String s1 : str) {
                String[] str2 = s1.split(",");
                addNewItem(new VendItem(str2[0], Double.parseDouble(str2[2]), (int) Double.parseDouble(str2[1])));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //export items to files
    public void exportItemsInfo(String path) {
        String s = "";
        for (int i = 0; i < itemCount; i++) {
            s += stock[i].toExportString();
        }
        HelpUtil.writeFile(path, s);

    }


    public boolean checkIfExistItem(String name) {
        for (int i = 0; i < itemCount; i++) {
            if (stock[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }


    public String checkIfAddItem(String name) {
        if (itemCount == maxItems) {
            return "mechine can't support more items";
        }
        for (int i = 0; i < itemCount; i++) {
            if (stock[i].getName().equals(name)) {
                return "item exist in the mechine";
            }
        }
        return "";
    }

    public void restock(String name, int quantity) {
        for (int i = 0; i < itemCount; i++) {
            if (stock[i].getName().equals(name)) {
                stock[i].restock(quantity);
            }
        }
    }
}
