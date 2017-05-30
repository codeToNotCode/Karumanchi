/*
 * to check whether array contains a majority element or not
 * If yes, return the majority element
 * A majority element is the one which occurs more than n/2 times in the array
 * 
 * https://gregable.com/2013/10/majority-vote-algorithm-find-majority.html
 * https://www.youtube.com/watch?v=zOyOwDEF1Rc
 */

package arrays;

public class MajorityElement {
	
	public Integer findMajority(int nums[]){
		Integer candidate = null;
		int count = 0;
		for(int i = 0; i<nums.length; i++){
			if(count == 0){
				candidate = nums[i];
				count = 1;
			}else{
				if( candidate == nums[i])
					count++;
				else
					count--;
			}
		}
		if (count == 0 )	return null;
		count = 0;
		for(int i =0; i<nums.length; i++){
			if(candidate == nums[i])
				count++;
		}
		if( count > nums.length/2)
			return candidate;
		else
			return null;
					
	}
	public static void main(String[] args) {
		MajorityElement me = new MajorityElement();
		int nums[] = {1,2,1,3,1,4,3,6};
		System.out.println(me.findMajority(nums));
	}
}
