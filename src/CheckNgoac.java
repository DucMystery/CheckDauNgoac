import java.util.Stack;

public class CheckNgoac {

    public static void main(String[] args) {
        String checkBalancedExpr1= checkNgoac("s * (s – a) * (s – b) * (s – c) ");
        System.out.println("s * (s – a) * (s – b) * (s – c) : "+checkBalancedExpr1);
        String checkBalancedExpr2= checkNgoac("(s * (s – a) * (s – b * (s – c) ");
        System.out.println("(s * (s – a) * (s – b * (s – c) : "+checkBalancedExpr2);

    }

    public static String checkNgoac(String str){
        if (str.isEmpty()){
            return "Balanced";
        }
        Stack<Character> stack =new Stack<>();
        for (int i =0;i<str.length();i++){
            char current =str.charAt(i);
            if (current =='{' || current =='(' || current =='['){
                stack.push(current);
            }
            if (current=='}' || current == ')' || current == ']'){
                if (stack.isEmpty()){
                    return "Not ";
                }
                char last = stack.peek();
                if ((current=='{' && last =='}') || (current=='(' && last == ')') || (current=='[' && last ==']')){
                    stack.pop();
                }else
                    return "Not Balanced";
            }
        }
        return stack.isEmpty()?"Balanced" :"Not Balanced";
    }
}
