package Team.modell.persistence;

import Team.modell.PlayerDTO;

import java.util.Optional;

public interface repoDAO<T>{
    void save(T dto);
    Optional<T> findOne(String name);
    void update(T dto);
    void delete(String sku);
}
