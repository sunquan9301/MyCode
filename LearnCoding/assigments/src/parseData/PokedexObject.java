package parseData;

import java.util.ArrayList;

public class PokedexObject {
    public String id;
    private String name;
    private String type = "";
    private ArrayList<Skill> skills = new ArrayList<>();

    public static PokedexObject create(String s) {
        String[] split = s.split("\t");
        PokedexObject po = new PokedexObject();
        po.id = split[0].substring(1);
        po.name = split[1];
        for (int i = 2; i < split.length; i++) {
            po.type = po.type + " " + split[i];
        }
        po.type = po.type.substring(1);
        return po;
    }

    public void addSkill(String s) {
        skills.add(Skill.create(s));
    }

}

class Skill {
    private String id;
    private String name;
    private String type;
    private String category;
    private String pp;
    private String power;
    private String accuracy;

    public static Skill create(String s) {
        Skill skill = new Skill();
        String[] split = s.split("\t");
        skill.id = split[0];
        skill.name = split[1];
        skill.type = split[2];
        skill.category = split[3];
        if (split.length > 4) skill.pp = split[4];
        if (split.length > 5) skill.power = split[5];
        if (split.length > 6) skill.accuracy = split[6];
        return skill;
    }
}
