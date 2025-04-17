public  class basic {
    public static void print(int n){
        if(n==1){
            System.out.print(n + " ");
            return;
        }
        System.out.print(n + " ");
        print(n-1);
    }

    public static void printIncreasing (int n) {
        if(n == 10){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printIncreasing(n+1);
    }

    public static int factorial(int n){
        if (n == 0){
            return 1;
        }
        int result = n * factorial(n - 1);
        return result;
    }

    public static void printHell(int n){
        if (n == 0){
            return;
        }
        System.out.println("hello");
        printHell(n - 1);
    }

    public static int printSum (int n) {
        if(n == 1){
            return 1;
        }
        int result = n + printSum(n - 1);
        return result;
    }

    public static int fibonachi(int n){
        if(n == 0 || n == 1){
            return n;
        }
        int result = fibonachi(n - 1) + fibonachi(n - 2);
        return  result;
    }

    public static int power(int x , int n){
        if(n == 0){
            return 1;
        }
        int result = x * power(x, n-1);
        return result;
    }

    public static int optimizedPower(int x , int n){
        if(n == 0){
            return 1;
        }
        int halfPower = optimizedPower(x, n/2);
        int halfPowerSq = halfPower * halfPower;
        if(n%2 != 0){
        halfPowerSq = x * halfPowerSq;
        }
        return halfPowerSq;
    }
    public static void main(String arg[]) {
        // print(10);
        // printIncreasing(1);
        //    printHell(10);

        // int result = factorial(5);
        // System.out.println(result);

        // int result = printSum(5);
        // System.out.println(result);

        // int result = fibonachi(5);
        // System.out.println(result);

        // int result = power(2, 5);
        // System.out.println(result);

        // System.out.println(optimizedPower(2, 5));        

    }
}