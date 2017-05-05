/*
 * To return a list of index of all strings that are anagrams in the input
 * ["cat", "dog", "god", "tca"] should return [[1,4],[2,3]]
 */
package ch14Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnagramsList {
	public ArrayList<ArrayList<Integer>> listAnagrams(ArrayList<String> input){
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		//Sort all words of the input string
		ArrayList<String> sortedInput = sortWords(input);
		HashMap<String, ArrayList<Integer>> map = new HashMap<>();
		int index = 1;
		for(String s : sortedInput){
			if(!map.containsKey(s)){
				ArrayList<Integer> indexList = new ArrayList<>();
				indexList.add(index);
				map.put(s, indexList);
			}else{
				ArrayList<Integer> indexList = map.get(s);
				indexList.add(index);
				map.put(s, indexList);
			}
			index++;
		}
		for(Map.Entry<String, ArrayList<Integer>> e : map.entrySet())
			result.add(e.getValue());
		return result;
	}
	private ArrayList<String> sortWords(ArrayList<String> input){
		ArrayList<String> sortedWords = new ArrayList<>();
		for(String word : input){
			char[] ch = word.toCharArray();
			Arrays.sort(ch);
			sortedWords.add(new String(ch));
		}
		return sortedWords;
	}
	public static void main(String[] args) {
		AnagramsList al = new AnagramsList();
		ArrayList<String> input = new ArrayList<>();
		input.add("cat");input.add("god");input.add("dog");input.add("tca");input.add("cta");
		ArrayList<ArrayList<Integer>> result = al.listAnagrams(input);
		for(ArrayList<Integer> indexList : result)
			System.out.println(indexList);
	}
}
