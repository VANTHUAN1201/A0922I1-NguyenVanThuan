import java.sql.Array;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int f = test_n(5);
        System.out.println("f_n= "+f);
    }

    public static int test_n(int n) {
        int a[]=new int[1000000];
        a[0]=4;
        a[1]=7;
        a[2]=5;
        for(int i =3; i<=n; i++){
            a[i] = a[i-1] + a[i-2] +a[i-3];
        }
        return a[n];
    }
}
