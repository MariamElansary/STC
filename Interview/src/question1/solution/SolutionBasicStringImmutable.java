package question1.solution;

import java.io.*;

/***
 * 
		• Given a string, we need to reverse substrings between each pair of parentheses, then
		printing the original with reversed substrings.
		o Test cases:
		Input: abd(jnb)asdf
		Output: abd(bnj)asdf
		Input: abdjnbasdf
		Output: abdjnbasdf
		Input: dd(df)a(ghhh)
		Output: dd(fd)a(hhhg)
		
		o Constraints:
		1. 1 <= s.length <= 2000
		2. String only contains lower case English characters and parentheses.
		3. It is guaranteed that all parentheses are balanced.
 *
 */

public class SolutionBasicStringImmutable {


    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String s = bufferedReader.readLine();
            
            String result = Result.reverseSubstrings(s);
            
            System.out.println("result:"+result);

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }


        bufferedReader.close();
    }
}

class Result {

    public static String reverseSubstrings(String s) {
        String result = "";
        String substring = "";
        boolean inside = false;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                inside = true;
                substring = ""; 
            } else if (c == ')') {
                result += '(' + reverseString(substring) + ')';
                inside = false;
                substring = "";
            } else {
                if (inside) {
                	substring += c;
                } else {
                    result += c;
                }
            }
        }

        return result;
    }

    public static String reverseString(String input) {
        char[] chars = input.toCharArray();
        int first = 0;
        int last = input.length() - 1;
        while (first < last) {
            char temp = chars[first];
            chars[first] = chars[last];
            chars[last] = temp;
            first++;
            last--;
        }
        return new String(chars);
    }
}