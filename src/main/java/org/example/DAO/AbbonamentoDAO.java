package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.Entity.Abbonamento;

import java.util.List;

public class AbbonamentoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Abbonamento abbonamento) {
        entityManager.persist(abbonamento);
    }

    public Abbonamento findById(Long id) {
        return entityManager.find(Abbonamento.class, id);
    }

    public List<Abbonamento> findAll() {
        return entityManager.createQuery("SELECT a FROM Abbonamento a", Abbonamento.class).getResultList();
    }

    @Transactional
    public void update(Abbonamento abbonamento) {
        entityManager.merge(abbonamento);
    }

    @Transactional
    public void delete(Long id) {
        Abbonamento abbonamento = findById(id);
        if (abbonamento != null) {
            entityManager.remove(abbonamento);
        }
    }
}
