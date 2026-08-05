class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for(String op : operations){
            if(op.equals("C")) st.pop();
            else if(op.equals("D")) st.push(2 * st.peek());
            else if(op.equals("+")){
                int temp = st.pop();
                int sum = st.peek() + temp;
                st.push(temp);
                st.push(sum);
            }
            else{
            int num = Integer.parseInt(op);
            st.push(num);
            }
        }
        int sum = 0;
        while(!st.isEmpty()){
            sum += st.pop();
        }
        return sum;
    }
}