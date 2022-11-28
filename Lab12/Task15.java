import java.util.Scanner;
import java.util.Stack;

public class Task15 {

    public static void main(String[] args){
        Stack<Character> brackets = new Stack<Character>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Input the string with different types of brackets: ");
        String smt = sc.nextLine();

        boolean correctBrackets = true;

        for(int i=0; i<smt.length(); i++){
            char current = smt.charAt(i);
            if(current=='(' || current=='[' || current=='{'){
                brackets.push(current);
            } else if(current==')'){
                char top = brackets.pop();
                if (top!='('){
                    correctBrackets = false;
                    break;
                }
            }else if(current==']'){
                char top = brackets.pop();
                if (top!='['){
                    correctBrackets = false;
                    break;
                }
            }else if(current=='}'){
                char top = brackets.pop();
                if (top!='{'){
                    correctBrackets = false;
                    break;
                }
            }
        }

        if(correctBrackets){
            System.out.println("All brackets are balanced");
        } else{
            System.out.println("Brackets are not balanced!");
        }


    }
}
