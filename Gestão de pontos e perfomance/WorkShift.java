import java.time.*;
import java.time.format.DateTimeFormatter;

public class WorkShift {
    private LocalDate shiftDate;
    private LocalTime expectedStartTime;
    private LocalTime expectedEndTime;
    private LocalDateTime actualCheckIn;
    private LocalDateTime actualCheckOut;

    public WorkShift(LocalDate shiftDate, LocalTime expectedStartTime, LocalTime expectedEndTime) {
        this.shiftDate = shiftDate;
        this.expectedStartTime = expectedStartTime;
        this.expectedEndTime = expectedEndTime;
    }


    public static WorkShift of(LocalDate shiftDate, LocalTime expectedStartTime, LocalTime expectedEndTime) {

        // VALIDAÇÃO 1: Data não pode ser nula
        if (shiftDate == null) {
            throw new IllegalArgumentException("A data do turno é obrigatória.");
        }

        // VALIDAÇÃO 2: Horário de término deve ser após o de início
        // (Assumindo que o turno não vira a noite no mesmo objeto)
        if (expectedEndTime.isBefore(expectedStartTime)) {
            throw new IllegalArgumentException("O horário de término não pode ser antes do início!");
        }

        return new WorkShift(shiftDate, expectedStartTime, expectedEndTime);
    }


    public void doCheckIn(LocalDateTime time) {
        this.actualCheckIn = time;

    }

    public void doCheckOut(LocalDateTime time) {
        this.actualCheckOut = time;
    }

    public long getWorkedMinutes() {
        if(actualCheckIn == null || actualCheckOut == null) return 0;
        return Duration.between(actualCheckIn, actualCheckOut).toMinutes();
    }

    public String getFormattedShiftReport() {
        DateTimeFormatter p = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        //LocalDateTime actualCheckInFormated = LocalDateTime.parse(actualCheckIn, p);

        return String.format("""
                Horas esperadas : %d\s
                O trabalhador Entrou no trabalho:%s horas
                O tabalhdor saiu:%s
                Minutos Trabalhados %d""", Duration.between(expectedStartTime, expectedEndTime).toHours(), p.format(actualCheckIn), p.format(actualCheckOut), getWorkedMinutes());
    }

    @Override
    public String toString() {
        return "WorkShift{" + "shiftDate=" + shiftDate + ", expectedStartTime=" + expectedStartTime + ", expectedEndTime=" + expectedEndTime + ", actualCheckIn=" + actualCheckIn + ", actualCheckOut=" + actualCheckOut + '}';
    }

    public LocalDate getShiftDate() {
        return shiftDate;
    }

    public LocalTime getExpectedStartTime() {
        return expectedStartTime;
    }

    public LocalTime getExpectedEndTime() {
        return expectedEndTime;
    }

    public LocalDateTime getActualCheckIn() {
        return actualCheckIn;
    }

    public LocalDateTime getActualCheckOut() {
        return actualCheckOut;
    }
}
