package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.Entity.Biglietto;

public class BigliettoDAO {

    private EntityManager em;

    public BigliettoDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Biglietto biglietto) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(biglietto);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void DeleteByID(int id) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Biglietto biglietto = em.find(Biglietto.class, id);
            if (biglietto != null) {
                em.remove(biglietto);
                transaction.commit();
                System.out.println("Biglietto eliminato con successo");
            } else {
                System.out.println("Biglieto con id: " + id + "non trovato");

            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }

    }

    public Biglietto foundById(int id) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Biglietto biglietto = em.find(Biglietto.class, id);
            if (biglietto != null) {
                System.out.println("Biglietto Trovato: " + biglietto);
                transaction.commit();
                return biglietto;

            } else {
                System.out.println("Biglieto con id: " + id + "non trovato");

            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }

    

}
