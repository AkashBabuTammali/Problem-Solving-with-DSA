/*
 * 20.Valid Parentheses
 * Problem Link: https://leetcode.com/problems/valid-parentheses/description/
*/
class Solution {
    //Creating a Map to store brackets
    private static Map<Character, Character> map = new HashMap<>();

    //Storing closing bracket as key and opening bracket as value in map
    static {
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
    }

    //This method will check
    public boolean isValid(String s) {
        //Deque is efficient than Stack
        Deque<Character> stack = new ArrayDeque<>();

        //Looping through input String to get each character
        for(char c : s.toCharArray()) {

            //Checking if bracket is closing bracket
            if(map.containsKey(c)) {
                //if stack is empty topEl is assigned with '#', else top Element of stack
                char topEl = stack.isEmpty() ? '#' : stack.pop();

                //If top element(bracket) matches with closing bracket, move to next iteration else return false
                if(topEl != map.get(c)) {
                    return false;
                }
            } else {
                //Bracket is opening bracket, so pushing to stack
                stack.push(c);
            }
        }
        //if stack is empty return true else false as still some bracket are left 
        return stack.isEmpty();
    }
}