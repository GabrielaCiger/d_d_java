package board;

public class PlayerOutOfBoardException extends Exception {
    public PlayerOutOfBoardException(String message) {
        super(message);
    }
}
