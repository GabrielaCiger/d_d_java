package menu;

public enum MenuOptions {
    START_GAME_WITH_INTRO(1),
    START_GAME_WITHOUT_INTRO(2),
    QUIT_GAME(3);

    private final int value;

    MenuOptions(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MenuOptions fromValue(int value) {
        for (MenuOptions menuOption : MenuOptions.values()) {
            if (menuOption.getValue() == value) {
                return menuOption;
            }
        }
        Menu.displayInvalidChoiceMessage();
        throw new IllegalArgumentException("Invalid menu option value: " + value);
    }

}
