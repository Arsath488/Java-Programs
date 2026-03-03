import java.io.*;
import java.util.*;

// 1. Interface must be outside the Solution class
interface PerformOperation {
    boolean check(int a);
}

// 2. MyMath class contains the lambda logic
class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public PerformOperation isOdd() {
        return (int n) -> n % 2 != 0;
    }

    public PerformOperation isPrime() {
        return (int n) -> {
            if (n < 2) return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        };
    }

    public PerformOperation isPalindrome() {
        return (int n) -> {
            String s = Integer.toString(n);
            String r = new StringBuilder(s).reverse().toString();
            return s.equals(r);
        };
    }
}

// 3. The main Solution class (only one of these!)
public class Lambda_Based_Number_Validator {

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            
            if (ch == 1) {
                boolean res = ob.checker(ob.isOdd(), num);
                System.out.println(res ? "ODD" : "EVEN");
            } else if (ch == 2) {
                boolean res = ob.checker(ob.isPrime(), num);
                System.out.println(res ? "PRIME" : "COMPOSITE");
            } else if (ch == 3) {
                boolean res = ob.checker(ob.isPalindrome(), num);
                System.out.println(res ? "PALINDROME" : "NOT PALINDROME");
            }
        }
    }
}
