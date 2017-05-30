package maths;

public class TotalHammingDistance {
	
	public int findTotal(int nums[]){
		int n = 31;
		int len = nums.length;
		int countOnes[] = new int[n];
		for(int i =0; i<len; i++){
			for(int j = 0; j<n; j++){
				countOnes[j]+= (nums[i]>>j)&1;
			}
		}
		int sum = 0;
		for(int count : countOnes){
			int numOnes = count;
			int numZeroes = len - count;
			sum+=numOnes*numZeroes;
		}
		return sum;
	}
	public static void main(String[] args) {
		TotalHammingDistance thd = new TotalHammingDistance();
		int nums[] = {4, 14, 2};
		System.out.println(thd.findTotal(nums));
	}
}
