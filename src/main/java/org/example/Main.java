package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.DAO.UtenteDAO;
import org.example.Entity.Biglietto;
import org.example.Entity.Utente;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("   gestioneEventiPU");
        EntityManager em = entityManagerFactory.createEntityManager();
        Scanner scanner = new Scanner(System.in);
        UtenteDAO utenteDAO = new UtenteDAO(em);

        while (true) {
            try {
                System.out.println("Premi: ");
                System.out.println("1 se sei un utente");
                System.out.println(" 2 se sei un amministratore");
                System.out.println("0 per uscire");
                int Genereutente = scanner.nextInt();
                scanner.nextLine();
                if (Genereutente < 1 || Genereutente > 2) {
                    System.out.println("inserisci 1 o 2");
                }
                if (Genereutente == 0) {
                    System.out.println("uscita");
                    break;
                }

                switch (Genereutente) {
                    case 1:
                        System.out.println("Premi: ");
                        System.out.println("1 Se vuoi comprare un biglietto");
                        System.out.println("2 Comprare un abbonamento");
                        System.out.println("3 Fare una tessera");
                        int azione = scanner.nextInt();
                        if (azione == 1) {
                            System.out.println("inserisci il tuo id utente");
                            int idUtente = scanner.nextInt();
                            scanner.nextLine();
                            Utente utenteVerifica = utenteDAO.findById(idUtente);
                            if (utenteVerifica == null) {
                                System.out.println("per comprare un biglietto devi registrarti");
                                registeUser(scanner, utenteDAO);
                            }else{
                                System.out.println("Benvenuto! " + utenteVerifica.getNome() + "!");
                                System.out.println("Procedi con l'acquisto del biglietto.");
                                Biglietto biglietto = buyTicket(scanner);

                            }
                        }



                    case 2:
                        System.out.println("Premi: ");
                        System.out.println("1 Per ");
                }


            } catch (InputMismatchException e) {
                System.out.println("va inserito  solo 1 o 2");
            } catch (Exception e) {
                System.out.println("cè stato un errore");
            }
        }


    }

     public static Biglietto buyTicket(Scanner scanner){
         System.out.println("Scegli il mezzo di trasporto : Bus, Tram");
         String mezzoScelto=scanner.nextLine();
     }

    public static void registeUser(Scanner Scanner, UtenteDAO utenteDAO) {
        System.out.println("Inserisci ul tuo nome");
        String nome = Scanner.nextLine();
        System.out.println();
        System.out.println("Inserisci il tuo cognome:");
        String cognome = Scanner.nextLine();
        System.out.println("hai la tessera si o no?");
        String tesseraInput = Scanner.nextLine();
        boolean tessera = false;
        if (tesseraInput.equalsIgnoreCase("si")) {
            tessera = true;
        } else if (tesseraInput.equalsIgnoreCase("no")) {
            tessera = false;
        } else {
            System.out.println("Risposta non valida. Per favore inserisci 'si' o 'no'.");

        }
        Utente utente = new Utente(nome, cognome, tessera);
        utenteDAO.save(utente);
        System.out.println("Utente registrato con successo: " + utente);

    }
}


