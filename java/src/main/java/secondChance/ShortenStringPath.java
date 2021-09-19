package secondChance;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ShortenStringPath {

//    String str = "/foo/../test/../test/../foo//bar/./baz";

    public static void main(String[] args) {
//        String str = "/foo/../test/../test/../foo//bar/./baz";
        String str = "/foo/../test/../test/../foo//bar/./././baz";

        System.out.println(shortenPath(str));

    }

    public static String shortenPath(String path) {
        String forwardSlash = !path.isEmpty() && path.charAt(0) == '/' ? "/" : "";
        String [] temp = path.split("/");
        System.out.println(Arrays.toString(temp));

        List<String> list = Arrays.stream(temp).filter(v -> v.length() > 0 && !v.equals(".")).collect(Collectors.toList());
        System.out.println(list);


        Stack<String> stack = new Stack<>();
        if(!forwardSlash.isEmpty()) {
            stack.push("");
        }
        for(String current: list) {
            if(current.equals("..") && !stack.isEmpty()) {
                if(stack.peek().equals("")) {
                    continue;
                } else if(stack.peek().equals("..")) {
                    stack.push("..");
                    continue;
                }
                stack.pop();
            } else if(current.equals("..") && stack.isEmpty()) {
                stack.push("..");
            } else {
                stack.push(current);
            }
            System.out.println(stack);
        }

        StringBuffer buffer = new StringBuffer();

        for(String current: stack) {
            buffer.append(current);
            buffer.append("/");
        }
        buffer.deleteCharAt(buffer.length()-1);
        System.out.println(buffer.toString());
        if(buffer.toString().isEmpty()) {
            return buffer.append("/").toString();
        }
        return buffer.toString();
    }
}
