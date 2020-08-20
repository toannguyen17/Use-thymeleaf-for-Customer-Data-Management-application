package customermanager.services;

import java.util.List;

public interface Service<E> {
    public E findByID(Long id);
    public List<E> findAll();
    public void deleteById(Long id);
    public void insert(E element);
}
