class Solution {
    public String removeDuplicateLetters(String s) {
     // Step 1: Create a map to store the last occurrence of each character
      Map<Character, Integer> lastOccurrence = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence.put(s.charAt(i), i);
        }

        // Step 2: Use a stack to build the result
        Stack<Character> stack = new Stack<>();
        // Boolean array to keep track of the characters already in the stack
        boolean[] seen = new boolean[256];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // If the character is already in the stack, skip it
            if (seen[c]) continue;

            // Ensure characters in the stack are in lexicographical order
            while (!stack.isEmpty() && stack.peek() > c && lastOccurrence.get(stack.peek()) > i) {
                // Pop from the stack and mark the character as not seen
                seen[stack.pop()] = false;
            }

            // Push the current character onto the stack and mark it as seen
            stack.push(c);
            seen[c] = true;
        }

        // Build the final result from the characters in the stack
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }

        return sb.toString();

    }
    
}