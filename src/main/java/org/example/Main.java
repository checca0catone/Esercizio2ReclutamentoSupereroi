package org.example;

import net.datafaker.Faker;
import java.util.Random;

// eccezione custom (checked)
class EroeNonIdoneoException extends Exception {
    private String nomeEroe;
    private int livelloPotere;

    public EroeNonIdoneoException(String nomeEroe, int livelloPotere) {
        super("L'eroe " + nomeEroe + " fa troppo schifo (potere: " + livelloPotere + ")");
        this.nomeEroe = nomeEroe;
        this.livelloPotere = livelloPotere;
    }

    public String getNomeEroe() {
        return nomeEroe;
    }

    public int getLivelloPotere() {
        return livelloPotere;
    }
}

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Random rand = new Random();

        int difficoltaMissione = 75;

        System.out.println("=== INIZIO SELEZIONE EROI (Difficoltà minima: " + difficoltaMissione + ") ===\n");

        for (int i = 1; i <= 5; i++) {
            System.out.println("Tentativo numero " + i);

            String nomeEroe = faker.superhero().name();
            int livelloPotere = rand.nextInt(100) + 1;

            System.out.println("Reclutamento: " + nomeEroe + " (Potere: " + livelloPotere + ")");

            try {
                if (livelloPotere < difficoltaMissione) {
                    throw new EroeNonIdoneoException(nomeEroe, livelloPotere);
                }

                System.out.println("Aura " + nomeEroe + " è abbastanza forte per la missione");

            } catch (EroeNonIdoneoException e) {
                System.out.println("[No Aura] " + e.getMessage());
            }

            System.out.println("--------------------------------------------------");
        }
    }
}