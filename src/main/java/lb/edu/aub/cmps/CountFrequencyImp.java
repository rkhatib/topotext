package lb.edu.aub.cmps;

import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class CountFrequencyImp implements CountFrequency {
	// OVERVIEW: This class provides a nb of procedures to generate a cloud of
	// words and
	// methods to return the most and least frequent word in the paragraph
	// provided

	private LinkedList<String> list;
	String[] result;
	private int[] nb = new int[100000];

	/**
	 * requires a linked list of strings 
	 * modifies assigns the linked list
	 * provided to list effects assigns the number of occurrences of each word
	 * to it
	 */
	public CountFrequencyImp(LinkedList<String> words)
			throws NullPointerException {
		// TODO Auto-generated method stub
		this.list = words;
		Collections.sort(list, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return Collator.getInstance().compare(o1, o2);
			}
		});

		String temp = list.getFirst();
		int k = 0;

		for (String s : list) {
			if (s.equals(temp)) {
				nb[k]++;
			} else {
				temp = s;
				k++;
				nb[k]++;
			}
		}

		Set<String> set = new HashSet<String>(list);
		result = new String[set.size()];
		set.toArray(result);
		Arrays.sort(result, String.CASE_INSENSITIVE_ORDER);
	}

	/**
	 * returns a string representing the most frequent word
	 */
	public String MFW() {

		int max = 0;
		int index = 0;
		for (int i = 0; i < nb.length; i++) {
			if (max < nb[i]) {
				max = nb[i];
				index = i;
			}
		}
		return result[index];

	}

	/**
	 * returns a string representing the least frequent word
	 */
	public String LFW() {
		// TODO Auto-generated method stub
		int min = 100;
		int index = 0;

		for (int i = 0; i < nb.length; i++) {
			if (min > nb[i] && nb[i] > 0) {
				min = nb[i];
				index = i;
			}
		}
		return result[index];
	}

	public static void main(String[] args){
		LinkedList<String> words = new LinkedList<String>();
		words.add("me");
		words.add("me");
		words.add("me");
		words.add("me");
		words.add("me");
		words.add("me");
		words.add("me");
		words.add("it");
		words.add("mow");
		words.add("mdflkhje");
		CountFrequencyImp n= new CountFrequencyImp(words);
		System.out.println(n.LFW());
		
	}
}
