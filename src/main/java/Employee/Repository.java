package Employee;

public interface Repository <T, STRING> {
    void save(T e);
    T findById(STRING id);
}
