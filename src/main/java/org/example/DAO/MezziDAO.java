package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.example.Entity.DistributoreAutomatico;
import org.example.Entity.Mezzi;
import org.example.Entity.Utente;

import java.util.List;


public class MezziDAO {
    private EntityManager em;

    public MezziDAO (EntityManager em) {this.em = em;}

    public void save (Mezzi mezzi) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(mezzi);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Mezzi> getAllMezzi() {
        TypedQuery<Mezzi> query = em.createQuery("SELECT m FROM Mezzi m", Mezzi.class);
        return query.getResultList();
    }

    @Transactional
    public Mezzi findById(int id) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Mezzi mezzi = em.find(Mezzi.class, id);
            if (mezzi != null) {
                transaction.commit();
                return mezzi;

            } else {
                System.out.println("Mezzo con id: " + id + "non trovato");

            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
//            em.close();
        }
        return null;
    }

}
