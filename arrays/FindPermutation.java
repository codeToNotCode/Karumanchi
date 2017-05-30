package arrays;

import java.util.ArrayList;
import java.util.Collections;

public class FindPermutation {
	 public ArrayList<Integer> findPerm(final String A, int B) {
	        int n = A.length();
	        ArrayList<Integer> result = new ArrayList<>();
	        for (int i = 1; i <= B; i++) 
	            result.add(i);// sorted
	            
	        for (int h = 0; h < n; h++) {
	            if (A.charAt(h) == 'D') {
	                int l = h;
	                while (h < n && A.charAt(h) == 'D') h++;
	                reverse(result, l, h); 
	            }   
	        }   
	        return result;
	    }   
	 
	    void reverse(ArrayList<Integer> result, int l, int h) {
	        while (l < h) {
	            int temp = result.get(l);
	            result.set(l, result.get(h));
	            result.set(h, temp);
	            l++; h--;
	        }   
	    }  
	    
	    
	    public ArrayList<Integer> findPermLog(final String A, int B) {
	        int n = A.length();
	        ArrayList<Integer> temp = new ArrayList<>();
	        ArrayList<Integer> result = new ArrayList<>();
	        
	        for (int k = 1; k <= B; k++) 
	            temp.add(k);// sorted
	        
	        int i = 0;
	        for(; i<A.length(); i++)
	            if(A.charAt(i) == 'I')  continue;
	            else break;
	        if(i == A.length()) return temp;
	        
	        i = 0;
	        for(; i<A.length(); i++)
	            if(A.charAt(i) == 'D')  continue;
	            else break;
	        if(i == A.length()){
	             Collections.reverse(temp);
	             return temp;
	        } 
	        
	        for (int j = 0;  j < A.length(); j++) {
	            if (A.charAt(j) == 'I') {
	               result.add(temp.remove(0));
	            }else
	              result.add(temp.remove(temp.size()-1));
	        }   
	        result.add(temp.remove(0));
	        return result;
	    }   
	    
	    
	    
	    public static void main(String[] args) {
			FindPermutation fp = new FindPermutation();
			ArrayList<Integer> result = fp.findPermLog("ID", 3);
			System.out.println(result);
		}
}
