package com.codergray.lintcode.misc;

/**
 * Given an input string, reverse the string word by word.
 * 
 * For example, Given s = "the sky is blue", return "blue is sky the".
 * 
 * Clarification: What constitutes a word? A sequence of non-space characters
 * constitutes a word. Could the input string contain leading or trailing
 * spaces? Yes. However, your reversed string should not contain leading or
 * trailing spaces. How about multiple spaces between two words? Reduce them to
 * a single space in the reversed string.
 * 
 * @param s
 * @return
 * @author cwang
 * 
 */
public class ReverseWordsinaString {

	public static void main(String[] args) {
		System.out.println(reverseWords("    the    sky    is blue   "));
	}

	public static String reverseWords(String s) {
		String[] segs = s.split(" ");
		int length = segs.length;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<length; i++){
			if(segs[length-i-1].trim().length()==0)
				continue;
			sb.append(segs[length-i-1]).append(" ");
		}
		
		if(sb.toString().endsWith(" "))
			sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
}
