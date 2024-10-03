import java.util.Scanner;

public class Personnage {
    String type;
    String name;
    int life;
    int attackStrength;
    EquipementOffensif equipmentOffensive;
    EquipementDefensif equipmentDefensif;

    /* ! Should I add a position in here? And update it through the function? */
//    int position = 1;

    /* * SETTERS */
    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        switch (type) {
            case "warrior":
                this.type = "warrior";
                this.life = 10;
                this.attackStrength = 10;
                this.equipmentOffensive = new EquipementOffensif("arme");
                this.equipmentDefensif = new EquipementDefensif("bouclier");
                break;

            case "wizard":
                this.type = "wizard";
                this.life = 6;
                this.attackStrength = 15;
                this.equipmentOffensive = new EquipementOffensif("sort");
                this.equipmentDefensif = new EquipementDefensif("philtre");
                break;

            default:
                System.out.println("[You babbled something, you're a warrior, remember?]");
                this.type = "warrior";
                this.life = 10;
                this.attackStrength = 10;
                this.equipmentOffensive = new EquipementOffensif("arme");
                this.equipmentDefensif = new EquipementDefensif("bouclier");
                break;
        }
    }

    /* ! CONSTRUCTORS: */
    public Personnage() {
        this("Player");
    }
    public Personnage(String name) {
        this(name, "warrior");
    }
    public Personnage(String name, String type) {
        setName(name);
        setType(type);
    }

}
