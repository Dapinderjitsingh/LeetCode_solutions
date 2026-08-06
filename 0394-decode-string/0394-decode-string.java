class Solution {
    public String decodeString(String s) {
        Deque<String> stringstack = new ArrayDeque<>();
        Deque<Integer> numstack = new ArrayDeque<>();
        int num = 0;
        String current = "";
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num * 10 + ch - '0'; // ch will return the ascii value
            }
            else if(ch == '['){
                numstack.push(num);
                stringstack.push(current);
                current = "";
                num = 0;
            }
            else if(Character.isLetter(ch)){
                current += ch;
            }
            else if(ch == ']'){
                int repeat = numstack.pop();
                String prev = stringstack.pop();
                StringBuilder temp = new StringBuilder();
                for(int j = 0; j < repeat; j++){
                    temp.append(current);
                }
                current = prev + temp.toString();
            }
        }
        return current;
    }
}