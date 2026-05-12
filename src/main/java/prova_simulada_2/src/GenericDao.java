package prova_simulada_2.src;

import java.util.*;

public class GenericDao<K, T> {
    private final Map<K, T> storage = new LinkedHashMap<>();

    public void save(K id, T obj) { storage.put(id, obj); }
    public Optional<T> findById(K id) { return Optional.ofNullable(storage.get(id)); }
    public List<T> findAll() { return new ArrayList<>(storage.values()); }
    public void delete(K id) { storage.remove(id); }
    public void update(K id, T obj) { storage.replace(id, obj); }

    public T buscar(K id) throws EntidadeNaoEncontradaException {
        T resultado = storage.get(id);

        if (resultado == null) {
            // Lançamos a nossa exceção personalizada se o ID não existir
            throw new EntidadeNaoEncontradaException("Erro: A entidade com ID '" + id + "' não foi localizada.");
        }

        return resultado;
    }

}