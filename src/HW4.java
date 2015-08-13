import java.util.HashMap;
import java.util.Map;


public class HW4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// my test code
		String str1 = "abcdefghijklmnop";
		//String str1 = "jim saw me in a barbershop";
		String str2 = "qrstuvwxyz";
		String str3 = "nop";
		//String str3 = "barber";
		int[] int_arr = {1, 10, 8, 4, 5, 9, 7, 3, 6, 2};
		int max_diff = 0;
		
		boolean_int horspool = Horspool(str1, str3);
		boolean_int bruteForce = bruteforceforStringMatching(str1, str3);
		
		System.out.println(horspool.bool_tag + " " + horspool.count);
		System.out.println(bruteForce.bool_tag + " " + bruteForce.count);
		System.out.println();
		
		horspool = Horspool(str2, str3);
		bruteForce = bruteforceforStringMatching(str2, str3);
		
		System.out.println(horspool.bool_tag + " " + horspool.count);
		System.out.println(bruteForce.bool_tag + " " + bruteForce.count);
		System.out.println();
		
		max_diff = getMaxDiff(int_arr, int_arr);
		
		System.out.println("Max difference: " + max_diff);
	}
	
	public static boolean_int Horspool(String text, String pattern)
	{
		//add your code here using Horspool algorithm for String Matching
		boolean_int boo_int = new boolean_int();
		//boo_int.bool_tag = false;
		//boo_int.count = 0;
		Map<Character, Integer> table = new HashMap<Character, Integer>();
		int pattern_start = 0;
		
		// shift table implementation
		for (int i = 0; i < pattern.length(); i++)
		{
			table.put(pattern.charAt(i), pattern.length());
		}
		for (int k = 0; k < text.length(); k++)
		{
			table.put(text.charAt(k), pattern.length());
		}
		for (int j = 0; j < pattern.length() - 1; j++)
		{
			table.put(pattern.charAt(j), pattern.length() - 1 - j);
		}
		
		//System.out.println(table);
		//System.out.println(table.keySet());
		//System.out.println(table.values());
		
		// horspool algorithm implementation
		pattern_start = pattern.length() - 1;
		while(pattern_start <= text.length() - 1)
		{
			int pattern_matched = 0;
			while (pattern_matched <= pattern.length() - 1 && pattern.charAt(pattern.length() - 1 - pattern_matched) == text.charAt(pattern_start - pattern_matched))
			{
				pattern_matched = pattern_matched + 1;
				boo_int.count += 1;
			}
			if (pattern_matched == pattern.length())
			{
				boo_int.bool_tag = true;
				pattern_start = text.length();
			}
			else
			{
				pattern_start = pattern_start + table.get(text.charAt(pattern_start));
				boo_int.count += 1;
			}
		}
		
		return boo_int;
	}
	public static boolean_int bruteforceforStringMatching(String text, String pattern)
	{
		boolean_int boo_int = new boolean_int();
		int pattern_start = pattern.length() - 1;
		//add your code here using bruteforce algorithm for String Matching
		while(pattern_start <= text.length() - 1)
		{
			int pattern_matched = 0;
			while (pattern_matched <= pattern.length() - 1 && pattern.charAt(pattern.length() - 1 - pattern_matched) == text.charAt(pattern_start - pattern_matched))
			{
				pattern_matched = pattern_matched + 1;
				boo_int.count += 1;
			}
			if (pattern_matched == pattern.length())
			{
				boo_int.bool_tag = true;
				pattern_start = text.length();
			}
			else
			{
				pattern_start += 1;
				boo_int.count += 1;
			}
		}
		return boo_int;
	}
	
	public static int getMaxDiff(int [] A, int [] B)
	{
			//add your code here
		int max_difference = 0;
		int current = 0;
		
		for (int i = 0; i <= A.length - 1; i++)
		{
			for (int j = 0; j <= B.length - 1; j++)
			{
				current = Math.abs(A[i] - B[j]);
				if (current > max_difference)
				{
					max_difference = current;
				}
			}
		}
		
		return max_difference;
	}

}
