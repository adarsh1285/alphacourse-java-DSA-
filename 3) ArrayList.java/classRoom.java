
import java.util.ArrayList;

public class classRoom {
    public static void swap(ArrayList<Integer> list, int idx1 , int idx2){
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }
    public static void main(String[] args) {
        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(3);
        // list.add(2);
        // list.add(4);
        // list.add(6);
        // list.add(1);
        // System.out.println("Only print the list : "+list);
        // Collections.sort(list);
        // System.out.println(list);
        // Collections.sort(list, Collections.reverseOrder());
        // System.out.println(list);

        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> List1 = new ArrayList<>();
        List1.add(1);
        List1.add(2);
        List1.add(3);
        List1.add(4);
        List1.add(5);
        mainList.add(List1);

        ArrayList<Integer> List2 = new ArrayList<>();
        List2.add(2);
        List2.add(4);
        List2.add(6);
        List2.add(8);
        List2.add(10);
        mainList.add(List2);

        ArrayList<Integer> List3 = new ArrayList<>();
        List3.add(3);
        List3.add(6);
        List3.add(9);
        List3.add(12);
        List3.add(15);
        mainList.add(List3);

        System.out.println(mainList);

        ArrayList<Integer> curr = new ArrayList<>();
        for(int i = 0; i<mainList.size(); i++){
             curr = mainList.get(i);
            for(int j = 0; j<curr.size(); j++){
                System.out.print(curr.get(j));
            }
            System.out.println();
        }

        
    }
}
