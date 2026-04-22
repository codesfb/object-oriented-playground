package Generics.EnvelopeSystem;

public class Letter {
    final private String text;
    public Letter(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "text=" + text + '\'';

    }
}
