package loop;

public class Prime100 {
    public static void main(String[] args) {
        int dem=0;
        System.out.println("Các số nguyên tố bé hơn 100 là:");
        for (int i = 2; i <100 ; i++) {
            int d=0;
            for (int j = 2; j <=Math.sqrt(i) ; j++) {
                if (i%j==0){
                    d++;
                }
            }
            if (d==0){
                System.out.print(i+" ");
            }
        }
    }
}
