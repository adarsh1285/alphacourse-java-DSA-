import java.util.*;

public class greedy {
    static void maxActivity(int start[], int end[]){
        int maxAct = 1;
            int lastEnd = end[0];
    
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(0);
            
            for(int i = 1; i<end.length; i++){
                if(start[i] >= lastEnd){
                    // activity selected
                    maxAct++;
                    ans.add(i);
                    lastEnd = end[i];
                }
            }
            System.out.println("Total number of activity is : "+maxAct);
    }
    public static void main(String arg[]){
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};
        maxActivity(start, end);
    }
}
