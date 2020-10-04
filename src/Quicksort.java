import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Quicksort {

    /*Deux méthodes utiles pour la lisibilité de la méthode sort
     * l'une sert à évaluer strictement inférieur
     * l'autre à échanger la position de deux éléments dans un tableau
     */
    private static boolean less(Comparable v, Comparable w) {
        if (v == w) return false;   // optimization when reference equals
        return v.compareTo(w) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        //quicksort est plus efficace en moyenne sur des tableaux mélangés !
        //(pour ce faire on transforme en List et on utilise shuffle)
        List<Comparable> liste = Arrays.asList(a);
        Collections.shuffle(liste);
        liste.toArray(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1); // Sort left part a[lo .. j-1].
        sort(a, j+1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi){
        int i = lo, j = hi+1; // left and right scan indices
        Comparable v = a[lo]; // partitioning item
        while (true) { // Scan right, scan left, check for scan complete, and exchange.
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j); // Put v = a[j] into position
        return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi].
    }
}
