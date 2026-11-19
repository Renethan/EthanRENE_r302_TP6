import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String[] args){
        try {
            FileWriter fichier = new FileWriter("resultat.csv");
            fichier.write("taille;duree;\n");
            for(int i = 3; i < 20; i++) {
                ArrayList<Integer> liste = genererListe(0, i, i);
                System.out.println("Avant : " + liste.toString());
                long debut = System.nanoTime();
                Quicksort.sort(liste);
                long fin = System.nanoTime();

                float temps = (float) (fin - debut) / 1000000;

                System.out.println("Après : " + liste.toString());
                System.out.println("Durée : " + temps + "ms");

                fichier.write(i + ";"  + temps + ";\n");

            }
            fichier.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static ArrayList<Integer> genererListe(int min, int max, int taille){
        ArrayList<Integer> liste = new ArrayList<>();
        for (int i = 0; i < taille; i++){
            liste.add((int) ((Math.random() * (max - min)) + min));
        }
        return liste;
    }
}
