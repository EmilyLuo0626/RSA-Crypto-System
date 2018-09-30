import java.util.Scanner;
public class RSA {
    private static final int p=79, q=61, e=19;
    public static int N;

    public static void main(String[] args) {
        N = p*q;
        int d = 739;

        Scanner s = new Scanner(System.in);
        System.out.println("Input M:");
        int M = s.nextInt();
        while (M<0 || M>=N) {
            System.out.println("Invalid input. Please re-enter:");
            M = s.nextInt();
        }


        System.out.println("Your message is:");
        int encodedM = sign(M,d);
        System.out.println(encodedM);

        System.out.println("Verify:");
        System.out.println(verify(N,e,encodedM,M));

    }



    public static int sign(int M, int d){
        int encodedM = modexp(M,d,N);

        return encodedM;
    }

    public static boolean verify(int N, int e, int eM, int M){
        int decode = modexp(eM,e,N);
        return M == decode;
    }

    public static int modexp(int x, int y, int N){
        if(y == 0) return 1;
        int z = modexp(x,y/2,N);
        if(y%2==0)
            return ((z%N)*z)%N;
        else
            return (((x*z)%N)*z)%N;
    }



}

