package question1.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SolutionWithStackDataStructure {
	


	    public static void main(String[] args) throws IOException{
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	        try {
	            String s = bufferedReader.readLine();
	            
	            String result = ResultWithStack.reverseSubstrings(s);
	            
	            System.out.println("result:"+result);

	        } catch (IOException ex) {
	            throw new RuntimeException(ex);
	        }


	        bufferedReader.close();
	    }


}


class ResultWithStack{

    public static String reverseSubstrings(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> charStack = new Stack<Character>();
        boolean inside = false;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                inside = true;
                charStack.clear();
            } else if (c == ')') {
            	
                result.append('(');
                
                while (!charStack.isEmpty()) {
                    result.append(charStack.pop());
                }
                
                result.append(')');
                inside = false;             
                
                charStack.clear();
            } else {
                if (inside) {
                	charStack.push(c);
                } else {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }

}
