package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.example.Entity.Biglietto;
import org.example.Entity.Tessera;
import org.example.Entity.Utente;

import java.util.List;

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
//            em.close();
        }
        return null;
    }

    public Utente getUtentePerNomeECognome (String nome, String cognome) {
        TypedQuery<Utente> query = em.createQuery(
           "SELECT u FROM Utente u WHERE u.nome = :nome AND u.cognome = :cognome",
           Utente.class);
        query.setParameter("nome", nome);
        query.setParameter("cognome", cognome);
        return query.getSingleResult();
    }

}
