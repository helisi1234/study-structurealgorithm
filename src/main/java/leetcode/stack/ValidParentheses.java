package leetcode.stack;
import java.util.Stack;
/*
*  20.有效的括号
* */
public class ValidParentheses {
//    栈顶的元素是最近的需要匹配的元素
    public boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') {
                characterStack.push(c);
            } else {
                char topChar = characterStack.pop();
                if (c == '(' && topChar != ')') {
                    return false;
                }
                if (c == '[' && topChar != ']') {
                    return false;
                }
                if (c == '{' && topChar != '}') {
                    return false;
                }
            }
        }
//        匹配完，必须栈空了才表示全部匹配完
        return characterStack.isEmpty();
    }
}
