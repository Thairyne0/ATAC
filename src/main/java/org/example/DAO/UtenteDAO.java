package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.Entity.Biglietto;
import org.example.Entity.Utente;

public class UtenteDAO {

    private EntityManager em;

    public UtenteDAO(EntityManager em){
        this.em = em;
    }

    public void save(Utente utente){
        EntityTransaction transaction = em.getTransaction();
        try{
            transaction.begin();
            em.persist(utente);
            transaction.commit();
        }catch (Exception e){
            if (transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Utente findById(int id) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Utente utente = em.find(Utente.class, id);
            if (utente != null) {
                transaction.commit();
                return utente;

            } else {
                System.out.println("Utente con id: " + id + "non trovato");

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
