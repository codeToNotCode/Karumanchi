package arrays;

import java.util.ArrayList;

public class PascalSeq {
	public ArrayList<ArrayList<Integer>> generate(int a) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	    for(int i = 0; i<a; i++){
	        ArrayList<Integer> row = new ArrayList<>();
	      //  row.add(1);
	        for(int j = 0; j<i; j++){
	            if(j == 0) 
	                row.add(1);
	            else
	                row.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
	        }
	        row.add(1);
	        result.add(row);
	    }
	    return result;
	}
	public static void main(String[] args) {
		PascalSeq ps = new PascalSeq();
		ArrayList<ArrayList<Integer>> result = ps.generate(5);
		for(ArrayList<Integer> list : result)
			System.out.println(list);
	}
}
