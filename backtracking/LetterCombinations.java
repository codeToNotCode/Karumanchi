/*
 * Given a digit string, return all possible letter combinations that the number could represent.
 *	A mapping of digit to letters (just like on the telephone buttons) is given below.
 *	The digit 0 maps to 0 itself.
 *  The digit 1 maps to 1 itself.
 *	Input: Digit string "23"
 *	Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *	Make sure the returned strings are lexicographically sorted.
 *
 *
 *	https://www.interviewbit.com/problems/letter-phone/
 */

package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations
{
	public List<String> letterCombs(String input){
		//Define the numPad
		String[] numPad = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		List<String> result = new ArrayList<>();
		generate(input, numPad, result, new StringBuilder(), 0);
		return result;
	}
	private void generate(String input, String[] numPad, List<String> result, StringBuilder tempString, int index) {
		if(index == input.length())
			result.add(tempString.toString());
		else {
			int digit = input.charAt(index) - '0';
			for(int i = 0; i<numPad[digit].length(); i++) {
				tempString.append(numPad[digit].charAt(i));
				generate(input, numPad, result, tempString, index+1);
				tempString.deleteCharAt(tempString.length()-1);
			}
		}
	}
	public static void main(String[] args)
	{
		LetterCombinations lc = new LetterCombinations();
		String input = "24";
		System.out.println("All possible combinations are :\n"+lc.letterCombs(input));
	}
}
