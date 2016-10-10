package problemsolving;

import java.util.Stack;

import org.testng.annotations.Test;

/*21+32*2
232*+

1+2+3*4 =>  12+34*+
*/

public class PostFix {
    Stack <String> stack = new Stack();
    String outPut = "";
    

	@Test
	public void test1() {
		System.out.println("");
		convertToPostFix("21+32*24");
	}
	
	@Test
	public void test2() {
		System.out.println("");
		convertToPostFix("18+29-30*42");
	}

	void convertToPostFix(String input) {
		String inputMain = input; 
		outPut = "";
	    while(!input.isEmpty()) {
	        char c  = input.charAt(0);
	        input = input.substring(1);
	        operate(c);
	    }
	    emptyStack();  
	    
	    System.out.println(inputMain+"="+outPut);
	}

	private void operate(char c) {
        if(isOperator(c)) {
            checkAndPush(c);
        }
        else {
            outPut = outPut+c;
                    
        }
    }
    

    
    private void checkAndPush(char c) {
        char topOfStack;
        
        if(stack.isEmpty()) {
            stack.push(Character.toString(c));
        }
        else {
        	topOfStack = stack.peek().charAt(0);
            if(priority(c) > priority(topOfStack)) {
                stack.push(Character.toString(c));
            }
            else {
                emptyStack();
                stack.push(Character.toString(c));
            }
        }
    }
    
    private void emptyStack() {
    	while(!stack.isEmpty()) {
    		outPut = outPut+stack.pop();
    	}
    }
    
	int priority ( char c) {
        switch (c) {
            case '*': 
                return 2;
            case '+':
                return 1;
            case '-':
                return 1;
        }
		return 0;
    }
	
    private Boolean isOperator(char c) {
        if((c =='*') || (c=='+')|| (c=='-')) {
            return true;
        }
        else {
        	return false;
        }
    }
}
