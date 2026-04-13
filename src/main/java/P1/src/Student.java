import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;
public class Student {
    private String id;
    private String name;
    private LocalDate admissionDate;

    public Student(String id, String name, LocalDate admissionDate) {
        if(isValidId(id)){
            this.id = id;
            this.name = name;
            this.admissionDate = admissionDate;
        }else{
            this.id = "SC0000000";
            this.name = "Invalido";
            this.admissionDate = LocalDate.now();
        }
    }

    public int getSemester(){
        return Period.between(admissionDate, LocalDate.now()).getYears() * 2;
    }


    public String getStateAsString(){
            return String.format("%s | %s | Admission date: %s Semester:%d", id, name, admissionDate,  getSemester());

    }

    public static boolean isValidId(String id){
        if(id == null) return false;
        Pattern pattern = Pattern.compile("[Ss][Cc]\\d{6}[0-9X]");
        return pattern.matcher(id).matches();
    }

    //sem regex, utiliza Character estaticos
//    public static boolean isValidId(String id) {
//        if (id == null) return false;
//        if (id.length() != 9) return false;
//
//        if (Character.toLowerCase(id.charAt(0)) != 's') return false;
//        if (Character.toLowerCase(id.charAt(1)) != 'c') return false;
//
//        for (int i = 2; i <= 7; i++) {
//            if (!Character.isDigit(id.charAt(i))) return false;
//        }
//
//        char last = id.charAt(8);
//        if (!Character.isDigit(last) && Character.toUpperCase(last) != 'X') return false;
//
//        return true;
//    }


    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", admissionDate=" + admissionDate +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

}
