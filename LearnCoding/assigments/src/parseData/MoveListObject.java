package parseData;

public class MoveListObject {
    private String id;
    private String name;
    private String type;
    private String category;
    private String pp;
    private String power;
    private String accuracy;

    public static MoveListObject create(String info) {
        String[] split = info.split(",");
        if (split.length != 7) return null;
        MoveListObject bso = new MoveListObject();
        bso.id = split[0];
        bso.name = split[1];
        bso.type = split[2];
        bso.category = split[3];
        bso.pp = split[4];
        bso.power = split[5];
        bso.accuracy = split[6];
        return bso;

    }
}
