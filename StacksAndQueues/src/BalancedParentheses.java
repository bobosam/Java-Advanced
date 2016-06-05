import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Bobo on 5/22/2016.
 */
public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        char[] parentheses = data.toCharArray();

        Stack<Character> parStack = new Stack<>();
        boolean check = true;

        for (char currPar : parentheses){
            if(currPar == '{' || currPar == '(' || currPar == '['){
                parStack.push(currPar);
                continue;
            }

            if(parStack.isEmpty() && (currPar == ']' || currPar =='}' || currPar == ')')){
                check = false;
                break;
            }

            if(!parStack.isEmpty()){
                if((currPar == '}' && parStack.peek() == '{') ||
                        (currPar == ']' && parStack.peek() == '[') ||
                        (currPar == ')' && parStack.peek() == '(')){
                    parStack.pop();
                }else {
                    check = false;
                    break;
                }
            }
        }

        if(check == true){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
