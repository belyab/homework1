package tasks.first;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class FirstTaskSolution implements FirstTask {
    @Override
    public String breadthFirst(boolean[][] adjacencyMatrix, int startIndex) {
        ArrayList<Vertex> vertexArrayList = new ArrayList<>();
        ArrayDeque<String> deque = new ArrayDeque<>();

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            vertexArrayList.add(new Vertex(i));
        }


        vertexArrayList.get(startIndex).setVisited(true);
        deque.offerLast("" + startIndex);
        String result = "";

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                if (adjacencyMatrix[startIndex][j] && !vertexArrayList.get(j).isVisited) {
                    vertexArrayList.get(j).setVisited(true);
                    deque.offerLast("" + j);
                }
            }
            result = result + deque.peekFirst() + ",";
            startIndex = Integer.parseInt(deque.pollFirst());
        }
        return result.substring(0, result.length() - 1);
    }

    @Override
    public Boolean validateBrackets(String s) {
        if(s==null){
            return false;
        }
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        for (char sybmol : charArray) {
            if (sybmol == ')' || sybmol == '}' || sybmol == ']') {
                char pairedSymbol = ' ';
                switch (sybmol) {
                    case (')'):
                        pairedSymbol = '(';
                        break;
                    case ('}'):
                        pairedSymbol = '{';
                        break;
                    case (']'):
                        pairedSymbol = '[';
                        break;
                }
                if (pairedSymbol == stack.getFirst()) {
                    stack.removeFirst();
                }
            }
            if (sybmol == '(' || sybmol == '{' || sybmol == '[') {
                stack.offerFirst(sybmol);
            }
        }
        return stack.isEmpty();
    }

    @Override
    public Long polishCalculation(String s) {
        ArrayDeque<Long> dequeNumbers = new ArrayDeque<>();
        ArrayDeque<String> dequeOperator = new ArrayDeque<>();

        String [] strings = s.split(" ");

        for(int i=0;i<strings.length/2;i++){
            switch (dequeOperator.removeLast()){
                case"+":
                    dequeNumbers.push(dequeNumbers.pop()+dequeNumbers.pop());
                    break;
                case"*":
                    dequeNumbers.push(dequeNumbers.pop()*dequeNumbers.pop());
                    break;
                case"-":
                    dequeNumbers.push(dequeNumbers.pop()-dequeNumbers.pop());
                    break;
                case"/":
                   dequeNumbers.push( dequeNumbers.pop()/dequeNumbers.pop());
                   break;
            }
        }
        return dequeNumbers.peek();

    }


}
