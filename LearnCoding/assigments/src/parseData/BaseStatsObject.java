package parseData;

public class BaseStatsObject {
    private String id;
    private String pokemon;
    private int hp;
    private int attack;
    private int defense;
    private int speed;
    private int special;
    private int total;
    private String type;

    public static BaseStatsObject create(String info) {
        String[] split = info.split(",");
        if (split.length < 9) return null;
        BaseStatsObject bso = new BaseStatsObject();
        bso.id = split[0];
        bso.pokemon = split[1];
        try {
            bso.hp = Integer.valueOf(split[2]);
            bso.attack = Integer.valueOf(split[3]);
            bso.defense = Integer.valueOf(split[4]);
            bso.speed = Integer.valueOf(split[5]);
            bso.special = Integer.valueOf(split[6]);
            bso.total = Integer.valueOf(split[7]);
        } catch (Exception e) {

        }
        String one = split[8];
        if (split.length == 10) {
            String two = split[9];
            if (one.toLowerCase().equals("fairy")) {
                bso.type = two;
            } else if (two.toLowerCase().equals("fairy")) {
                bso.type = one;
            } else bso.type = one + " " + two;
        } else bso.type = one;
        if (bso.type.toLowerCase().equals("fairy")) {
            bso.type = "Normal";
        }
        return bso;

    }
}
