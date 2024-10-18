package menu;

public enum StoryOptions {
    APPROACH_GLASSTABLE(1),
    APPROACH_BIRDCAGE(2),
    LEAVE_STORY(3);

    private final int value;

    StoryOptions(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static StoryOptions fromValue(int value) {
        for (StoryOptions storyOption : StoryOptions.values()) {
            if (storyOption.getValue() == value) {
                return storyOption;
            }
        }
        Menu.displayInvalidChoiceMessage();
        return APPROACH_GLASSTABLE;
    }

}
