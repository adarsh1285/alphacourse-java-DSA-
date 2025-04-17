public class Basics {
    public static int printIth(int n , int i){
        int bitMask = n >> i;
        int result = (bitMask & 1);
        if(result == 0){
            return 0;
        }else{
            return 1;
        }
    }
    public static void main (String args[]){
        System.out.println((5 & 6));
        System.out.println((5 | 6));
        System.out.println((5 ^ 6));
        System.out.println((~5));
        int result = 0b11111111111111111111111111111010;
        int a = 4;
        int b = 5;
        int c = a + b;
        System.out.println(c);
        System.out.println(result);
        System.out.println((5 << 2));
        System.out.println((5 >> 2));

        // int result = printIth(2345, 8);
        // System.out.println(result);
    }
}