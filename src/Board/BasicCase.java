package Board;

public class BasicCase implements Case {
protected String value;
    public BasicCase() {
        this.value = "Basic Case";}

    public BasicCase(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public void doAction() {
        System.out.println("I am BasicCase.");
    }
}
