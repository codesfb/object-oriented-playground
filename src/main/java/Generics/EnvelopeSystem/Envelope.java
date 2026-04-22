package Generics.EnvelopeSystem;

public class Envelope <T>{
    final private T content;

    public Envelope(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }
}
