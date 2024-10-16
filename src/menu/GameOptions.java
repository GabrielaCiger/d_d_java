package menu;

public enum GameOptions {
    ROLL_DICE(1),
    SHOW_STATS(2),
    QUIT_GAME(3),
    REPLAY_GAME(4);

    private final int value;

    GameOptions(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static GameOptions fromValue(int value) {
        for (GameOptions gameOption : GameOptions.values()) {
            if (gameOption.getValue() == value) {
                return gameOption;
            }
        }
        Menu.displayInvalidChoiceMessage();
        throw new IllegalArgumentException("Invalid menu option value: " + value);
    }

}
