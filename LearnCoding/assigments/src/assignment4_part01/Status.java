package assignment4_part01;

public enum Status {
    VENDING_MODE,
    SERVICE_MODE;

    public String getStatus() {
        return this.name();
    }
}
