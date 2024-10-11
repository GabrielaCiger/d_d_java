package equipement;
import board.Case;
import menu.ChestMenu;
import personnages.Personnage;

public abstract class EquipementOffensif implements Case {
    protected ChestMenu chestMenu = new ChestMenu();
    protected String name;
    protected int attackLevel;
    protected String type;

    public EquipementOffensif() {
        this.name = "Basic attack";
        this.attackLevel = 0;
    }

    public EquipementOffensif(String name, int attackLevel) {
        this.name = name;
        this.attackLevel = attackLevel;
        this.type = "Attack";
    }

    public String getWeaponName() {
        return name;
    }
    public Integer getAttackLevel() {
        return attackLevel;
    }

    @Override
    public String getValue() {
        return "Bonus case";
    }
    @Override
    public void doAction(Personnage personnage) {
        ChestMenu.encounterMessage();
        int getNew = chestMenu.applyChoice(ChestMenu.showChoicesUnopened(), this.name, this.type, this.attackLevel);
        if(getNew == 1){
            chestMenu.getNewEquipmentSuccess(this.type);
            getNewEquipement(personnage);
        }
    }
    public void getNewEquipement(Personnage personnage){}

    public boolean betterAttackLogic(Personnage personnage){
        return personnage.getEquipmentDefensif().getDefenseLevel() <= this.attackLevel;
    }
}
