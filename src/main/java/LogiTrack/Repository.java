package LogiTrack;

public interface Repository <T,K>{
    void save(T entity);
    T findById(K id);
    T[] findAll();

}
