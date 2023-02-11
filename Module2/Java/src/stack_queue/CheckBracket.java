package stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class CheckBracket {
    public static void main(String[] args) {
        char leftBracket = '(', rightBracket = ')';
        Stack<Character> wStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter something with bracket ( or ): ");
        String str = scanner.nextLine();
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == leftBracket){
                wStack.push(leftBracket);
            }else if ((str.charAt(i) == rightBracket) && (wStack.isEmpty())){
                wStack.push(rightBracket);
            }else if ((str.charAt(i) == rightBracket) && (!wStack.isEmpty())){
                wStack.pop();
            }
        }
        if (wStack.isEmpty()){
            System.out.println("True");
        }else if (!wStack.isEmpty()){
            System.out.println("False");
        }
    }
}
