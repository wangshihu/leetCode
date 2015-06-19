package Ch21_40;

import java.util.Stack;

/**
 * Created by hadoop on 2015/6/10 0010.
 */
public class Ch32 {
    public int longestValidParentheses(String s) {
        if(s==null||s.length()<2)
            return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int maxLen = 0;
        int accumulatedLen = 0;

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    accumulatedLen = 0;
                } else {
                    int matchedPos = stack.pop();
                    int matchedLen = i - matchedPos + 1;

                    if (stack.isEmpty()) {
                        accumulatedLen += matchedLen;
                        matchedLen = accumulatedLen;
                    } else {
                        matchedLen = i - stack.peek();
                    }

                    maxLen = Math.max(maxLen, matchedLen);
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new Ch32().longestValidParentheses("()()()()")+", 2");
        System.out.println(new Ch32().longestValidParentheses("(()")+", 2");
    }
}
