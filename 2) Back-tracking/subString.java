public class subString {
    public static void findSubSets(String str, String ans, int i){
        // base case 
        if(i == str.length()){
            if(ans.length() == 0){
                System.out.println("null");
            }else{

                System.out.println(ans);
            }
            return;
        }
        // recursion 
        //yes case
        findSubSets(str, ans+str.charAt(i), i+1);
        // no case
        findSubSets(str, ans, i+1);
    }

    public static void findPermutation(String str, String ans){
        // base case
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        //recursion
        for(int i = 0; i < str.length(); i++){
            char curr = str.charAt(i);
            String newStr = str.substring(0,i) + str.substring(i+1);
            findPermutation(newStr, ans+curr);
        }
    }
    public static void main(String[] args) {
        String str = "abc";
        // findSubSets(str, "", 0);
        findPermutation(str, "");
    }
}
