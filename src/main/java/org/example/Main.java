package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.DAO.*;
import org.example.Entity.*;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int idRivenditore = 0;
        int idMezzo = 0;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ATACPU");
        EntityManager em = entityManagerFactory.createEntityManager();
        Scanner scanner = new Scanner(System.in);
        UtenteDAO utenteDAO = new UtenteDAO(em);

        while (true) {
            try {
                System.out.println("Premi: ");
                System.out.println("1- se sei un utente");
                System.out.println("2- se sei un amministratore");
                System.out.println("0- per uscire");
                int Genereutente = scanner.nextInt();
                scanner.nextLine();
                if (Genereutente != 1 && Genereutente != 2) {
                    System.out.println("inserisci 1 o 2");
                }
                if (Genereutente == 0) {
                    System.out.println("uscita");
                    break;
                }

                switch (Genereutente) {
                    case 1:
                        System.out.println("Premi: ");
                        System.out.println("1- Se vuoi comprare un biglietto");
                        System.out.println("2- Comprare un abbonamento");
                        System.out.println("3- Fare una tessera");
                        int azione = scanner.nextInt();
                        scanner.nextLine();
                        switch (azione) {
                            //comprare un biglietto
                            case 1:
                                System.out.println("inserisci il tuo id utente");
                                int idUtente = scanner.nextInt();
                                scanner.nextLine();
                                Utente utenteVerifica = utenteDAO.findById(idUtente);
                                if (utenteVerifica == null) {
                                    System.out.println("per comprare un biglietto devi registrarti");
                                    registeUser(scanner, utenteDAO);
                                } else {
                                    System.out.println("Benvenuto! " + utenteVerifica.getNome() + "!");
                                    System.out.println("Procedi con l'acquisto del biglietto.");
                                    sceltaRivenditore(scanner, em, idRivenditore);
                                    sceltaMezzo(scanner, em, idMezzo);

                                }
                                break;
                            case 2:
                                //da completare con abbonamento
                                System.out.println("Siamo felici tu voglia spendere soldi, tu... che ne hai");
                                idRivenditore = sceltaRivenditore(scanner, em, idRivenditore);
                                System.out.println("Benvenuto, mi dica il suo nome per favore..");
                                String nome = scanner.nextLine();
                                System.out.println("mi serve anche il cognome..");
                                String cognome = scanner.nextLine();
                                TesseraDAO tesseraDAO = new TesseraDAO(em);
                                Tessera tessera = tesseraDAO.getTesseraPerNomeECognome(nome, cognome);
                                if (tessera == null) {
                                    System.out.println("Non possiede una tessera, necessaria per acquistare un abbonamento, vuole farla? digitare :\n 1: SI\n 2: NO");
                                    int decisione = scanner.nextInt();
                                    scanner.nextLine();
                                    if (decisione == 1) {
                                        creoTessera(utenteDAO, em, nome, cognome);
                                    } else if (decisione == 2) {
                                        System.out.println("Arrivederci");
                                        break;
                                    } else {
                                        System.out.println("Scelta non valida");
                                    }
                                }
                                System.out.println("Perfetto, che tipo di abbonamento vuole acquistare?\n1: trimestrale\n2: Semestrale");
                                int tipo = scanner.nextInt();
                                Utente utente = utenteDAO.getUtentePerNomeECognome(nome, cognome);
                                Tessera tesseraUt = tesseraDAO.getTesseraPerNomeECognome(nome, cognome);
                                PuntoEmissione puntoEmissione = em.find(PuntoEmissione.class, idRivenditore);
                                if (tipo == 1) {
                                    Abbonamento abbonamento = new Abbonamento(LocalDate.now().plusMonths(3), "Trimestrale", utente, tesseraUt, puntoEmissione);
                                    em.getTransaction().begin();
                                    em.persist(abbonamento);
                                    em.getTransaction().commit();
                                    System.out.println("Ecco il suo Abbonamento: \n" + abbonamento);


                                } else if (tipo == 2) {
                                    Abbonamento abbonamento = new Abbonamento(LocalDate.now().plusMonths(6), "Semestrale", utente, tessera, puntoEmissione);
                                    em.getTransaction().begin();
                                    em.persist(abbonamento);
                                    em.getTransaction().commit();
                                    System.out.println("Ecco il suo Abbonamento: \n" + abbonamento);
                                }

                                break;
                            case 3:
                                //creo tessera
                                System.out.println("inserisci il tuo nome");
                                String name = scanner.nextLine();
                                System.out.println("inserisci il tuo cognome");
                                String surname = scanner.nextLine();
                                creoTessera(utenteDAO, em, name, surname);
                                break;


                        }
                        break;


                    case 2:
                        TrattoDAO trattoDAO = new TrattoDAO(em);
                        int c = 1;
                        System.out.println("Premi: ");
                        System.out.println("1 per calcolare il tempo medio di una tratta");
                        int scelta = scanner.nextInt();
                        scanner.nextLine();
                        switch (scelta) {
                            case 1:
                                try {
                                    List<Tratta> tratte = trattoDAO.getAllTratta();
                                    for (Tratta t : tratte) {
                                        System.out.println(c++ + ": " + t.stampaNome());
                                    }
                                    System.out.println("Scegli una tratta: ");
                                    int idTratta = scanner.nextInt();
                                    scanner.nextLine();
                                    Tratta trattaScelta = trattoDAO.findById(idTratta);
                                    System.out.println(trattaScelta.trattaMedia());
                                } finally {
//                     em.close();
//                     entityManagerFactory.close();
                                }
                                break;
                        }
                }
            } catch (InputMismatchException e) {
                System.out.println("va inserito  solo 1 o 2");
            } catch (Exception e) {
                System.out.println("cè stato un errore" + e);
            }
        }
    }

    public static int sceltaRivenditore(Scanner scanner, EntityManager em, int idRivenditore) {
        RivenditoreDAO rivenditoreDAO = new RivenditoreDAO(em);
        DistributoreAutomaticoDAO distributoreAutomaticoDAO = new DistributoreAutomaticoDAO(em);
        int counter = 1;
        System.out.println("Scegli un rivenditore: ");
        System.out.println("1- Rivenditore Fisico");
        System.out.println("2- Distributore Automatico");

        int scelta = scanner.nextInt();
        scanner.nextLine();
        switch (scelta) {
            case 1:
                System.out.println("Scegli da quale rivenditore comprare il biglietto: ");
                try {
                    List<Rivenditore> rivenditori = rivenditoreDAO.getAllRivenditori();
                    for (Rivenditore r : rivenditori) {
                        System.out.println(counter++ + ": " + r.stampaNome());
                    }
                    idRivenditore = scanner.nextInt();
                    scanner.nextLine();

                } finally {
//                     em.close();
//                     entityManagerFactory.close();
                }
                break;
            case 2:
                System.out.println("Scegli da quale distributore comprare il biglietto: ");
                try {

                    List<DistributoreAutomatico> distributoreAutomatico = distributoreAutomaticoDAO.getAllDistributori();
                    for (DistributoreAutomatico d : distributoreAutomatico) {
                        System.out.println(counter++ + ": " + d.stampaNome());
                    }
                    idRivenditore = scanner.nextInt();
                    scanner.nextLine();

                } finally {
//                     em.close();
//                     entityManagerFactory.close();
                }
                break;
        }
        return idRivenditore;
    }

    public static void sceltaMezzo(Scanner scanner, EntityManager em, int idMezzo) {
        MezziDAO mezziDAO = new MezziDAO(em);
        int counter = 1;
        System.out.println("Scegli il mezzo di trasporto :");
        try {

            List<Mezzi> mezzi = mezziDAO.getAllMezzi();
            for (Mezzi m : mezzi) {
                System.out.println(counter++ + ": " + m.stampaMezzo());
            }
            idMezzo = scanner.nextInt();
            scanner.nextLine();
        } finally {
//                     em.close();
//                     entityManagerFactory.close();
        }
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
//        utenteDAO.save(utente);
        System.out.println("Utente registrato con successo: " + utente);

    }

    public static void creoTessera(UtenteDAO utenteDAO, EntityManager em, String nome, String cognome) {
        // tessera
        em.getTransaction().begin();
        Utente utenteEsistente = utenteDAO.getUtentePerNomeECognome(nome, cognome);
        if (utenteEsistente != null) {
            utenteEsistente.setBoolTessera(true);
            em.merge(utenteEsistente);
            Tessera tesseraUtente = new Tessera(utenteEsistente);
            TesseraDAO tesseraDAO = new TesseraDAO(em);
            tesseraDAO.save(tesseraUtente);
            System.out.println("Tessera creata: " + tesseraUtente);
        } else {
            Utente utenteCreato = new Utente(nome, cognome, true);
            utenteDAO.save(utenteCreato);
            Tessera tesseraUtente = new Tessera(utenteCreato);
            TesseraDAO tesseraDAO = new TesseraDAO(em);
            tesseraDAO.save(tesseraUtente);
            System.out.println("Tessera creata: " + tesseraUtente);
        }
        em.getTransaction().commit();
    }
}


