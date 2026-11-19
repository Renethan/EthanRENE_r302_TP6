import java.util.List;

public class Quicksort {
    public static void sort(List<Integer> liste) {
        if (liste.size() < 2) {
            return;
        }

        int pivot = partitionner(liste);

        sort(liste.subList(0, pivot));
        sort(liste.subList(pivot + 1, liste.size()));
    }

    private static int partitionner(List<Integer> liste) {
        int dernier = liste.size() - 1;
        Integer pivot = liste.get(dernier);
        int i = 0;

        for (int j = 0; j < dernier; j++) {
            if (liste.get(j) < pivot) {
                swap(liste, i, j);
                i++;
            }
        }
        swap(liste, i, dernier);
        return i;
    }

    private static void swap(List<Integer> liste, int a, int b) {
        Integer tmp = liste.get(a);
        liste.set(a, liste.get(b));
        liste.set(b, tmp);
    }
}