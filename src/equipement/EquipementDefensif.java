package equipement;
import board.Case;
import menu.ChestMenu;
import personnages.Personnage;

public abstract class EquipementDefensif implements Case {
    protected ChestMenu chestMenu = new ChestMenu();
    protected String name;
    protected int defenseLevel;
    protected String type;

    public EquipementDefensif() {
        this.name = "Defense weapon";
    }
    public EquipementDefensif(String newName, int newDefenseLevel) {
        this.name = newName;
        this.defenseLevel = newDefenseLevel;
        this.type = "Defense";
    }

    public String getDefenseWeaponName() {
        return name;
    }
    public int getDefenseLevel() {
        return defenseLevel;
    }
    public boolean betterDefenseLogic(Personnage personnage){
        return personnage.getEquipmentDefensif().getDefenseLevel() <= this.defenseLevel;
    }

    @Override
    public String getValue() {
        return "Bonus case";
    }

    @Override
    public void doAction(Personnage personnage) {
        ChestMenu.encounterMessage();
        int getNew = chestMenu.applyChoice(ChestMenu.showChoicesUnopened(), this.name, this.type, this.defenseLevel);
        if(getNew == 1){
            chestMenu.getNewEquipmentSuccess(this.type);
            getNewEquipement(personnage);
        }
    }

    public void getNewEquipement(Personnage personnage){}

}
