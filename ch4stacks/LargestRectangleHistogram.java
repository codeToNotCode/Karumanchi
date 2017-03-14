/*
 * TO find the largest rectangle in a given histogram
 * hist[] = {6,2,5,4,5,2,6}
 * output - 12
 */

package ch4stacks;

import java.util.Stack;

public class LargestRectangleHistogram
{
	public int greatestArea(int[] hist){
		Stack<Integer> s = new Stack<>();
		int maxArea = 0;
		int top;
		int areaWithTop;
		int i =0;
		while(i<hist.length){
			if(s.isEmpty()||hist[s.peek()]<=hist[i])
				s.push(i++);
			else{
				top = s.pop();
				areaWithTop = hist[top] * (s.isEmpty()?i:(i-s.peek()-1));
				if(maxArea < areaWithTop)
					maxArea = areaWithTop;
			}
		}
		while(!s.isEmpty()){
			top = s.pop();
			areaWithTop = hist[top] * (s.isEmpty()?i:(i-s.peek()-1));
			if(maxArea < areaWithTop)
				maxArea = areaWithTop;
		}
		return maxArea;
	}
	public static void main(String[] args)
	{
		LargestRectangleHistogram lrh = new LargestRectangleHistogram();
		int hist[] = {6,2,5,4,5,1,6};
		System.out.println(lrh.greatestArea(hist));
	}
}
