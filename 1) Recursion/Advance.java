
public class Advance {
    static String digits[] = {"Zero", "One", "Tow", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    public static void printAllOccurences(int arr[], int key, int i){
        if(i == arr.length){
            return;
        }
        if(arr[i] == key){
            System.out.print(i + " ");
        }
        printAllOccurences(arr, key, i+1);
    }

    public static void printDigits(int number){
        if(number == 0){
            return;
        }
        int lastDigit = number%10;
        printDigits(number/10);
        System.out.print(digits[lastDigit]+" ");
    }
    public static void main(String arg[]){
    //    int arr[] = {3,2,4,5,6,2,7,2,2};
    //    int key = 2;
    //    printAllOccurences(arr,key, 0);
    int num = 3435;
    printDigits(num);
    }
}
