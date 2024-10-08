package Board;

import Personnages.Personnage;

public interface Case {
    String getValue();
    void doAction(Personnage personnage);
}