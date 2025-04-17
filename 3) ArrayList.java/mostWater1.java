
import java.util.*;

public class mostWater1 {
    public static int mostWater(ArrayList<Integer> height){
        int lp = 0 , rp = height.size()-1;
        int maxWater = 0;
        if(lp == rp){
            return 0;
        }
        while(lp < rp){
            int hg = Math.min(height.get(lp), height.get(rp));
            int width = rp-lp;
            int water = hg * width;
            maxWater = Math.max(maxWater, water);
            if(height.get(lp) < height.get(rp)){
                lp++;
            }else{
                rp--;
            }
        }
        return maxWater;
    }
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        int result = mostWater(height);
        System.out.println("Maximum water is : " + result);
    }
}
