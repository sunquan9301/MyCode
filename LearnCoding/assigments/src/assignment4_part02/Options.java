package assignment4_part02;

public class Options {
    public static final String ADMIN_PASSWORD = "1234";
    public static final String MACHINE_OWNER = "admin";
    public static final int MAX_ITEM = 10;

    static class MainOption {
        public static final String MAIN_WELCOME = "welcome to use QUB's Automated Retail Department";
        public static final String PURCHASE_ITEMS = "user mode";
        public static final String SERVICE_MODE = "service mode";
        public static final String MAIN_QUIT = "quit the system";
    }

    static class ServiceOption {
        public static final String WELCOME = "Service Mode of QUB's Automated Retail Department";
        public static final String ALL_ITEM_INFO = "detail info of mechine";
        public static final String RESET_MECHINE = "reset mechine";
        public static final String SWITCH_TO_USER_MODE = "switch to user mode";
        public static final String ADD_NEW_VENDITEM = "add new venditem";
        public static final String RESTOCK_AN_ITEM = "restock an item";
        public static final String SERVICE_QUIT = "quit the service mode";
    }

    static class UserOption {
        public static final String WELCOME = "User Mode of QUB's Automated Retail Department";
        public static final String LIST_ITEM = "list item";
        public static final String ENTER_COIN = "insert coin";
        public static final String VIEW_MONEY = "view current money";
        public static final String PURCHASE_ITEM = "purchase item";
        public static final String USER_QUIT = "quit the user mode";

    }

}
