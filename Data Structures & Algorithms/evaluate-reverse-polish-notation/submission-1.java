class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> operations = Set.of("+", "-", "/", "*");
        Deque<Integer> numbers = new ArrayDeque<>();

        for(String token : tokens){
            if(operations.contains(token)){
                int number2 = numbers.pop();
                int number1 = numbers.pop();
                numbers.push(executeOperation(number1, number2, token));
            }else{
                numbers.push(Integer.parseInt(token));
            }
        }
        return numbers.pop();
    }

    private int executeOperation(int number1, int number2, String operation){
        switch(operation){
            case "+":
            return number1 + number2;
            case "-":
            return number1 - number2;
            case "*":
            return number1*number2;
            case "/":
            return number1 /number2;
            default:
            return 0;
        }
    }
}
