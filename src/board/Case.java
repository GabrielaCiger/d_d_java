package board;

import personnages.Personnage;

public interface Case {
    String getValue();

    /**
     * Interaction method that modifies the player's state based on certain conditions or actions.
     * This method may involve updating player attributes, applying effects, or triggering events.
     * @param personnage The current player who is affected by the action performed in this method.
     */
    CaseInteractionEnding doAction(Personnage personnage);
}