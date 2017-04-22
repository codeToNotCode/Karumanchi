/*
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3 ) :
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * For example, given n = 3, k = 4, ans = "231"
 * 
 * Best explanation : 
 * https://www.quora.com/How-can-we-find-the-lexicographically-Kth-permutation-of-the-sequence-1-N-efficiently
 */


package backtracking;

import java.util.ArrayList;
import java.util.List;

public class KthPermutation
{
		public String getPermutation(int n, int k) {
		    List<String> input = new ArrayList<String>();
		    for(int i = 1; i<=n; i++)
		        input.add(String.valueOf(i));
		        
		    if(k <= 1){
		        return  String.join("",input);
		    }
		    k = k-1;
		    List<Integer> fBase = new ArrayList<>();
		    for(int i = 1; k!=0; i++){
		        fBase.add(0, k%i);
		        k = k/i;
		    }
		    while(fBase.size()!=input.size())   fBase.add(0,0);
		    String output = "";
		    for(int i = 0 ; i<fBase.size(); i++){
		    	int index = fBase.get(i);
		        output = output + input.remove(index);
		    }
		    
		    return output;
		}
	
		public static void main(String[] args)
		{
			KthPermutation kp = new KthPermutation();
			System.out.println(kp.getPermutation(2, 2));
		}

}
