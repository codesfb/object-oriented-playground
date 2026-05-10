// Esta classe deve estar em um arquivo chamado EntidadeNaoEncontradaException.java
public class EntidadeNaoEncontradaException extends Exception {

    // Construtor que aceita uma mensagem personalizada
    public EntidadeNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}