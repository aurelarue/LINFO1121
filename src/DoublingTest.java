import java.util.ArrayList;

public class DoublingTest {

    // retourne le temps nécessaire pr trier une liste de taille n avec shell sort
    public static double timeTrial(int n) {
        Comparable[] a = new Comparable[n];
        for (int i = 0; i < n; i++) {
            a[i] = Math.random();
        }
        long start = System.currentTimeMillis();
        Shell.sort(a); // on peut changer l'algorithme de tri ici
        long finish = System.currentTimeMillis();
        return finish-start;
    }

    // retourne une liste [X, Y] ou X et Y sont des listes, y = timeTrial(x)
    // y est le temps et x est la taille de la liste
    public static double[][] values() {
        ArrayList<Double> X = new ArrayList<Double>();
        ArrayList<Double> Y = new ArrayList<Double>();
        for (int n = 250; X.size()<17; n = 2*n) {
            double time = timeTrial(n);
            X.add((double) n);
            Y.add(time);
            System.out.printf("%7d %7.1f\n", n, time);
        }
        double x[] = new double[X.size()];
        int i = 0;
        for (Double n : X){
            x[i] = n;
            i++;
        }
        double y[] = new double[Y.size()];
        i = 0;
        for (Double n : Y){
            y[i] = n;
            i++;
        }
        return new double[][]{x,y};
    }

    // affiche le graphe
    public static void graph(double[] X, double[] Y){
        // on peut le modifier avec des couleurs et tout
        StdDraw.setXscale(X[0], X[X.length-1]);
        StdDraw.setYscale(Y[0], Y[Y.length-1]);
        for (int i = 0; i < X.length-1; i++){
            StdDraw.line(X[i], Y[i], X[i+1], Y[i+1]);
        }
    }

    public static void main(String[] args) {
        double[][] values = values();
        double[] X = values[0];
        double[] Y = values[1];
        graph(X, Y);
    }

}
