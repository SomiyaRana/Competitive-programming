class Solution {
    public String reverseWords(String s) {
        String[] wrds = s.split(" +");
        StringBuilder sb = new StringBuilder();
        for(int i = wrds.length -1; i>=0; i--){
            sb.append(wrds[i]);
            sb.append(" ");
        }
        return sb.toString().trim();  
    }
}
