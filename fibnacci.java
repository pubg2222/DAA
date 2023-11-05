import java.util.Scanner;

class fibonacci{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = sc.nextInt();
        System.out.println("Enter your choice :\n1. For Iterative\n2. For recursive");
        int ch = sc.nextInt();
        sc.close();
        if(ch == 1) System.out.println("Output "+fibIter(n));
        else if(ch == 2) System.out.println("Output "+fibRec(n));
        else System.out.println("Wrong choice");
    }

    private static int fibRec(int n) {
        if(n==0 || n==1) return n;
        return fibRec(n-1)+fibRec(n-2);
    }

    private static int fibIter(int n) {
        if(n==0 || n==1) return n;
        int first = 0, second = 1, temp = 0;
        for(int i=2; i<=n; i++){
            temp = first + second;
            first = second;
            second = temp;
        }
        return temp;
    }
}