public class Insertion {
    
    public static void sort(Comparable [] a){
        Comparable current;
        for(int i=1;i<a.length;i++){
            current = a[i];
            for(int j=0;j<i;j++){
                if(!less(a[j],a[i])){ // on trouve la place du current
                    a = decalage(j,i,a);
                    a[j]= current;
                }
            }
        }
    }

    public static Comparable[] decalage(int lo, int hi,Comparable [] a){
            for(int i=hi;i>=lo && i>=1;i--){
                a[i] = a[i-1];
            }
        return a;
    }

    public static boolean less(Comparable i, Comparable j){
        return i.compareTo(j) < 0;
    }
}
