
import java.util.PriorityQueue;


public class classroom {
    public static void main(String[] args) {
        // priority Queue ka emplimentation with example : _
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(3);
        pq.add(2);
        pq.add(0);
        pq.add(1);
        pq.add(4);

        while(!pq.isEmpty()){
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}
