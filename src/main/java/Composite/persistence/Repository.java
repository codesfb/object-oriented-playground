package Composite.persistence;

import java.util.Optional;

public interface Repository<K,T> {
     void save(T obj);
     void update(T obj);
     Optional<T> findById(K value);

}
