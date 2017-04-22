package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * [
 *  "((()))",
 *  "(()())",
 *  "(())()",
 *  "()(())",
 *  "()()()"
 * ]
 * 
 */


public class generateParathesis
{
	public List<String> generateParan(int n){
		List<String> result = new ArrayList<>();
		generate(result, n, 0, 0, new StringBuilder());
		return result;
	}
	private void generate(List<String> result, int n, int open, int close, StringBuilder temp) {
		if(temp.length() == 2*n) {
			result.add(temp.toString());
			return;
		}
		if(open<n) {
			temp.append("(");
			generate(result, n, open+1, close, temp);
			temp.setLength(temp.length()-1);
		}
		if(close<open) {
			temp.append(")");
			generate(result, n, open, close+1, temp);
			temp.setLength(temp.length()-1);
		}
	}
	public static void main(String[] args)
	{
		generateParathesis gp = new generateParathesis();
		System.out.println(gp.generateParan(3));
	}
}
