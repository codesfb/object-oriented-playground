package Generics.EnvelopeSystem;

public class Invite {
    final private String event;
    public Invite(String event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "event='" + event + '\'';

    }
}
