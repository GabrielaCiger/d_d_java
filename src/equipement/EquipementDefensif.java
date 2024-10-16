package equipement;
import board.Case;
import board.CaseInteractionEnding;
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
    protected boolean betterDefenseLogic(Personnage personnage){
        return personnage.getEquipmentDefensif().getDefenseLevel() <= this.defenseLevel;
    }

    @Override
    public String getValue() {
        return "Bonus case";
    }

    @Override
    public CaseInteractionEnding doAction(Personnage personnage) {
        ChestMenu.encounterMessage();
        int getNew = chestMenu.applyChoice(ChestMenu.showChoicesUnopened(), this.name, this.type, this.defenseLevel);
        if(getNew == 1){
            getNewEquipement(personnage);
        }
        return CaseInteractionEnding.NONE;
    }

    protected void getNewEquipement(Personnage personnage){}

}
