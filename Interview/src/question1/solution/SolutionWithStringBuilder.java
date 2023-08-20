package question1.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SolutionWithStringBuilder {
	


	    public static void main(String[] args) throws IOException{
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	        try {
	            String s = bufferedReader.readLine();
	            
	            String result = ResultWithStringBuilder.reverseSubstrings(s);
	            
	            System.out.println("result:"+result);

	        } catch (IOException ex) {
	            throw new RuntimeException(ex);
	        }


	        bufferedReader.close();
	    }


}


class ResultWithStringBuilder{

    public static String reverseSubstrings(String s) {
        StringBuilder result = new StringBuilder();
        StringBuilder substring = new StringBuilder();
        boolean inside = false;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                inside = true;
                substring.setLength(0);
            } else if (c == ')') {
                result.append('(').append(substring.reverse()).append(')');
                inside = false;             
                
                substring.setLength(0);
            } else {
                if (inside) {
                    substring.append(c);
                } else {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }

}
