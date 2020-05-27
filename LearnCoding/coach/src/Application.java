import java.util.Scanner;

public class Application {
    static boolean[] seats;

    public static void main(String[] args) {
        seats = new boolean[11];
        Scanner cin = new Scanner(System.in);
        while (true) {
            System.out.println("Please input a seat type,1 for first class, 2 for economy");
            try {
                int type = cin.nextInt();
                if (type != 1 && type != 2) {
                    System.out.println("The input is incorrect");
                    continue;
                }
                boolean result = checkSeat(type);
                if (!result) {
                    System.out.println((type == 2 ? "Economy section" : "first-class section ") + "is full, can you acceptable " + (type == 2 ? "first-class section " : "Economy section"));
                    System.out.println("Please input if accept another class section, y/n");
                    String opt = cin.nextLine();
                    if(opt.equals("y")){
                        boolean result1 = checkSeat(type == 1?2:1);
                        if(!result1){
                            System.out.println("All seats if full");
                            break;
                        }
                    }else{
                        System.out.println("Next flight leaves in 3 hours");
                    }
                }
            } catch (Exception e) {
                System.out.println("The input is incorrect");

            }
        }
        cin.close();
    }

    public static boolean checkSeat(int type) {
        boolean result = false;
        if (type == 1) {
            for (int i = 1; i <= 5; i++) {
                if (!seats[i]) {
                    seats[i] = true;
                    result = true;
                }
            }
        } else {
            for (int i = 6; i <= 10; i++) {
                if (!seats[i]) {
                    seats[i] = true;
                    result = true;
                }
            }
        }
        return result;
    }
}
