import java.util.Arrays;
import java.util.Random;

public class SortCompare {

    public static double time(String alg, Double[] a) {
        long start = System.currentTimeMillis();
        //  if      (alg.equals("Insertion"))       Insertion.sort(a);
        if (alg.equals("Shell")) Shell.sort(a);
        if (alg.equals("Java.util.Arrays")) Arrays.sort(a);
        long finish = System.currentTimeMillis();
        return finish - start;
    }

    // Use alg to sort trials random arrays of length n.
    public static double timeRandomInput(String alg, int n, int trials)  {
        double total = 0.0;
        Double[] a = new Double[n];
        // Perform one experiment (generate and sort an array).
        for (int t = 0; t < trials; t++) {
            for (int i = 0; i < n; i++)
                a[i] = Math.random();
            total += time(alg, a);
        }
        return total;
    }

    // Use alg to sort trials sorted arrays of length n.
    public static double timeSortedInput(String alg, int n, int trials) {
        double total = 0.0;
        Double[] a = new Double[n];
        // Perform one experiment (generate and sort an array).
        for (int t = 0; t < trials; t++) {
            for (int i = 0; i < n; i++)
                a[i] = 1.0 * i;
            total += time(alg, a);
        }
        return total;
    }

    // Use alg to sort trials arrays triés à l'envers of length n.
    public static double timeReversedInput(String alg, int n, int trials) {
        double total = 0.0;
        Double[] a = new Double[n];
        // Perform one experiment (generate and sort an array).
        for (int t = 0; t < trials; t++) {
            for (int i = 0; i < n; i++)
                a[i] = 1.0 * (n-1-i);
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int n = Integer.parseInt(args[2]);
        int trials = Integer.parseInt(args[3]);
        double time1, time2;
        if (args.length == 5 && args[4].equals("Sorted")) {
            time1 = timeSortedInput(alg1, n, trials);   // Total for alg1.
            time2 = timeSortedInput(alg2, n, trials);   // Total for alg2.
            System.out.printf("For %d Doubles triés\n    %s is", n, alg1);
        } else if (args.length == 5 && args[4].equals("Reversed")){
            time1 = timeReversedInput(alg1, n, trials);   // Total for alg1.
            time2 = timeReversedInput(alg2, n, trials);   // Total for alg2.
            System.out.printf("For %d Doubles triés à l'envers\n    %s is", n, alg1);
        } else {
            time1 = timeRandomInput(alg1, n, trials);   // Total for alg1.
            time2 = timeRandomInput(alg2, n, trials);   // Total for alg2.
            System.out.printf("For %d random Doubles\n    %s is", n, alg1);
        }
        System.out.printf(" %.1f times faster than %s\n", time2/time1, alg2);
    }
}
