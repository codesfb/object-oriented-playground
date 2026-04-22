package Generics.EnvelopeSystem;

public class Mail<T>  {
    public static  String imprimirConteudo(Envelope<?>... env) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Processando no Correio: \n");
        for (Envelope<?> tEnvelope : env) {
            stringBuilder.append(tEnvelope.getContent());
        }
        return stringBuilder.toString();
    }
}
