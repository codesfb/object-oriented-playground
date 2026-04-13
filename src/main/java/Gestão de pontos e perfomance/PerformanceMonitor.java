import java.time.Duration;
import java.time.Instant;

public class PerformanceMonitor {
    private Instant start;
    private Instant end;

    public void startProcess() {
        this.start = Instant.now();
        this.end = null; // Reseta o fim caso o monitor seja reusado
    }

    public void endProcess() {
        if (this.start == null) {
            throw new IllegalStateException("Processo não foi iniciado! Chame startProcess() primeiro.");
        }
        this.end = Instant.now();
    }

    public long getExecutionTimeMillis() {
        // Se o processo ainda está rodando, podemos calcular até o momento atual ("agora")
        // ou avisar que ainda não terminou.
        if (start == null) return 0;

        Instant pontoFinal = (end != null) ? end : Instant.now();
        return Duration.between(start, pontoFinal).toMillis();
    }
}