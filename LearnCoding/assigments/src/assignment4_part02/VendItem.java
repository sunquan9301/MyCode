package assignment4_part02;

public class VendItem {
    static int ID = 0;
    private int nextId;
    private int itemId;
    private String name;
    private double unitPrice;
    private int qtyAvailable;

    public VendItem(String name, double unitPrice, int qtyAvailable) {
        this.itemId = ID++;
        this.name = name;
        this.unitPrice = unitPrice;
        this.qtyAvailable = qtyAvailable;
    }

    public VendItem(String name, double unitPrice) {
        this.itemId = ID++;
        this.name = name;
        this.unitPrice = unitPrice;
        this.qtyAvailable = 1;
    }

    @Override
    public String toString() {
        return " itemId = " + itemId + ", nextId = " + nextId + ", name = " + name + ", unitPrice = " + unitPrice + ", qtyAvailable = " + qtyAvailable + "\n";
    }

    public String toExportString() {
        return name+","+unitPrice+","+qtyAvailable+"\n";
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return unitPrice;
    }

    public int getQty() {
        return qtyAvailable;
    }

    public boolean restock(int quantity) {
        this.qtyAvailable = quantity;
        return true;
    }

    public void decrement() {
        this.qtyAvailable--;
    }
}
