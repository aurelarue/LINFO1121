import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Merge {

    private static boolean less(Comparable v, Comparable w) {
        if (v == w) return false;
        return v.compareTo(w) < 0;
    }
    private static Comparable[] aux;

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length-1);
    }
    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo +(hi-lo)/2;
        sort(a, lo, mid); //sort left half.
        sort(a, mid+1, hi); //sort right half.
        if (less(a[mid+1], a[mid])){ //optimize for best case
            merge(a, lo, mid, hi);
        }

    }

    public static void merge(Comparable[] a, int lo, int mid, int hi){
        int i = lo, j = mid+1;
        for(int k =lo; k <= hi; k++)
            aux[k] = a[k];
        for(int k=lo; k <= hi; k++){
            if (i>mid)                      a[k] = aux[j++];
            else if (j>hi)                  a[k] = aux[i++];
            else if (less(aux[j], aux[i]))  a[k] = aux[j++];
            else                            a[k] = aux[i++];
        }
    }
}
