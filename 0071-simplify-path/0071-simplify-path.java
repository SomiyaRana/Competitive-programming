class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String p : parts) {
            if (p.equals("") || p.equals(".")) continue;      // ignore empty/current
            if (p.equals("..")) {
                if (!stack.isEmpty()) stack.pop();           // go up if possible
            } else {
                stack.push(p);                               // normal directory
            }
        }

        return "/" + String.join("/", stack);
    }
}
