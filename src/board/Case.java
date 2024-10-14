package board;

import personnages.Personnage;

public interface Case {
    String getValue();
    void doAction(Personnage personnage);

}