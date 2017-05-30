package arrays;

import java.util.ArrayList;

public class Flip {
	
	//For O(n) solution
	public ArrayList<Integer> flipKadane(String A) {
		 ArrayList<Integer> result = new ArrayList<>();
	        if (A == null || A.isEmpty()) return result;
	        // If we consider each '1' as -1 and each '0 'as 1,
	        // we can apply the same solution as finding the the contiguous sub-sequence with the largest sum
	        // https://en.wikipedia.org/wiki/Maximum_subarray_problem
	        // we also need to keep the start and end indices for the sub-sequence with the largest sum
	 
	        int maxSum = Integer.MIN_VALUE, maxSoFar = 0;
	        int left = 0, right = 0;
	        int maxLeft = 0;
	 
	        for (int i = 0; i < A.length(); i++) {
	            int add = (A.charAt(i) == '0' ? 1 : -1);
	            if (0 > maxSoFar + add) {
	                left = i + 1;
	                maxSoFar = 0;
	            } else {
	                maxSoFar += add;
	            }
	 
	            if (maxSoFar > maxSum) {
	                maxSum = maxSoFar;
	                maxLeft = left;
	                right = i;
	            }
	        }
	 
	        // nothing found
	        if (maxLeft > right) return result;
	 
	        // this is because our indices in array start at 0
	        // and the solution asks indices from 1
	        result.add(maxLeft + 1);
	        result.add(right + 1);
	        return result;
	    }
	
	
	
	//brute force 
	//O(n^3) solution
    public ArrayList<Integer> flip(String A) {
        ArrayList<Integer> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder(A);
        StringBuilder maxSb = new StringBuilder();
        int numOnes = 0;
        int largestNumOnes = 0;
        boolean allOnes = true;
        for(int i = 0; i < A.length(); i++)
            if(A.charAt(i) != '1'){
                allOnes = false;
                break;
            }
        if(allOnes)
            return result;
            
        for(int i = 1; i<=A.length(); i++){
            for(int j = 1; j<=A.length(); j++){
                flip(sb, i, j);
                numOnes = countOnes(sb);
                if( numOnes > largestNumOnes){
                	largestNumOnes = numOnes;
                    result.clear();
                    result.add(i);
                    result.add(j);
                    maxSb = sb;
                }else if( numOnes == largestNumOnes){
                    if(isGreaterLexOrder(sb, maxSb)){
                        result.clear();
                        maxSb = sb;
                        result.add(i);
                        result.add(j);
                    }
                }
                sb = new StringBuilder(A);
            }
        }
        return result;
    }
    private void flip(StringBuilder str, int start, int end){
        for(int i = start-1; i<end; i++){
            if(str.charAt(i) == '0')
                str.setCharAt(i, '1');
            else
                str.setCharAt(i, '0');
        }
    }
    private int countOnes(StringBuilder str){
        int count = 0;
        for(int i = 0; i<str.length(); i++)
            if(str.charAt(i) == '1')
                count++;
        return count;
    }
    private boolean isGreaterLexOrder(StringBuilder sb, StringBuilder maxSb){
        for(int i = 0; i<sb.length(); i++){
            if(sb.charAt(i) != maxSb.charAt(i)){
                if(sb.charAt(i) == '0')
                    return false;
                if(sb.charAt(i) == '1')
                    return true;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
		Flip f = new Flip();
		System.out.println(f.flip("011"));
		System.out.println(f.flipKadane("011"));
	}
}
