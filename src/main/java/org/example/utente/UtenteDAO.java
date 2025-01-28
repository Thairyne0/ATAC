package org.example.utente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import javax.swing.text.html.parser.Entity;

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

}
