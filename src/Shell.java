public class Shell {

    public static void sort(Comparable[] a){
        int l = a.length;
        int h = 1;
        while (h<l/3){
            h = 3*h+1;
        }
        while (h>=1){
            for (int i =h; i<l; i++){
                for (int j=i; j>=h && less(a[i], a[j-h]); j-=h){
                    exchange(a,j,j-h);
                }
            }
            h=h/3;
        }
    }

    public static void exchange(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // is i < j ?
    public static boolean less(Comparable i, Comparable j){
        return i.compareTo(j) < 0;
    }

    /**
    public static void sort(int[] a){
        int l = a.length;
        int h = 1;
        while (h<l/3){
            h = 3*h+1;
        }
        while (h>=1){
            for (int i = h; i<l; i++){
                for (int j=i; j>=h && a[j-h]- a[j] > 0; j-=h){
                    exchange(a,j,j-h);
                }
            }
            h=h/3;
        }
    }

    public static void exchange(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String args[]){
        int[] a = new int[]{10,9,8,7,6,5,4,3,2};
        for (int i = 0; i<a.length; i++){
            System.out.println(a[i]);
        }
        sort(a);
        System.out.println("Sort");
        for (int i = 0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }
    **/

}
