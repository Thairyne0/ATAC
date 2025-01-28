package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.DAO.RivenditoreDAO;
import org.example.DAO.UtenteDAO;
import org.example.Entity.Rivenditore;
import org.example.Entity.Utente;

import java.time.LocalTime;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ATACPU");

        EntityManager em = emf.createEntityManager();

        RivenditoreDAO rivenditoreDAO = new RivenditoreDAO(em);

        try {
            List<Rivenditore> rivenditori = rivenditoreDAO.getAllRivenditori();
            for (Rivenditore r : rivenditori) {
                System.out.println(r.descrizione());
            }

            Rivenditore rivenditore = rivenditoreDAO.getRivenditoreById(1L);
            if (rivenditore != null) {
                System.out.println("Singolo rivenditore: " + rivenditore.descrizione());
            }
        } finally {
            em.close();
            emf.close();
        }

    }
}