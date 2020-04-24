package assignment4_part02;

public enum Status {
    VENDING_MODE,
    SERVICE_MODE;

    public String getStatus() {
        return this.name();
    }
}
