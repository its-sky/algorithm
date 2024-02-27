import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        br.close();
        Stack<Character> stack = new Stack<>();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if ('A' <= arr[i] && arr[i] <= 'Z') {
                sb.append(arr[i]);
            } else {
                if (arr[i] == '+' || arr[i] == '-') {
                    if (stack.size() == 0) {
                        stack.push(arr[i]);
                    } else {
                        while (stack.size() > 0) {
                            if (stack.peek() == '(') {
                                break;
                            }
                            sb.append(stack.pop());
                        }
                        stack.push(arr[i]);
                    }
                } else if (arr[i] == '*' || arr[i] == '/') {
                    if (stack.size() == 0) {
                        stack.push(arr[i]);
                    } else {
                        while (stack.size() > 0) {
                            char tmp = stack.peek();
                            if (tmp == '(') {
                                break;
                            }
                            if (tmp == '*' || tmp == '/') {
                                sb.append(tmp);
                                stack.pop();
                            } else {
                                break;
                            }
                        }
                        stack.push(arr[i]);
                    }
                } else if (arr[i] == '(') {
                    stack.push(arr[i]);
                } else if (arr[i] == ')') {
                    while (stack.size() > 0) {
                        if (stack.peek() == '(') {
                            stack.pop();
                            break;
                        }
                        sb.append(stack.pop());
                    }
                }
            }
        }
        while (stack.size() > 0) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}