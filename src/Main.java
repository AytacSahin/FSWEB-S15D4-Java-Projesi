import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("****************************************************************************");
        System.out.println("[A] checkForPalindrome");
        System.out.print("\t[1] " + checkForPalindrome("BONNOB"));
        System.out.print("\t[2] " + checkForPalindrome("Is it a palindrom word?"));
        System.out.print("\t[3] " + checkForPalindrome("on no , on no"));
        System.out.print("\t[4] " + checkForPalindrome("Aytac"));
        System.out.println("\n[B] checkForPalindromeFIFO");
        System.out.print("[1] " + checkForPalindromeFIFO("BONNOB"));
        System.out.print("[2] " + checkForPalindromeFIFO("Is it a palindrom word?"));
        System.out.print("[3] " + checkForPalindromeFIFO("on no , on no"));
        System.out.print("[4] " + checkForPalindromeFIFO("Aytac"));
        System.out.println("\n****************************************************************************************");
        System.out.println("[C] convertDecimalToBinary");
        System.out.println("\t[1] 13 için -> " + convertDecimalToBinary(13));
        System.out.println("\t[2] 5 için -> " + convertDecimalToBinary(5));
        System.out.println("\t[3] 6 için -> " + convertDecimalToBinary(6));
        System.out.println("\t[4] 75 için -> " + convertDecimalToBinary(75));
        System.out.println("****************************************************************************");
    }

    public static boolean checkForPalindrome(String text) {
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder noPunctionString = new StringBuilder();
        String lowerCase = text.toLowerCase(Locale.ENGLISH);

        for (int i = 0; i < lowerCase.length(); i++) {
            char c = lowerCase.charAt(i);
            if (c >= 'a' && c <= 'z') {
                noPunctionString.append(c);
                stack.push(c);
            }
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return noPunctionString.toString().equals(reversed.toString());
    }

    public static boolean checkForPalindromeFIFO(String text) {
        LinkedList<Character> stack = new LinkedList<>();
        LinkedList<Character> queue = new LinkedList<>();
        String lowerCase = text.toLowerCase(Locale.ENGLISH);


        for(int i = 0; i < lowerCase.length(); i++){
            char c = lowerCase.charAt(i);
            if(c >= 'a' && c <= 'z'){
                queue.addLast(c);
                stack.push(c);
            }
        }
        if(stack.equals(queue)){
            System.out.print("\tEQUAL -> ");
        } else{
            System.out.print("\tNOT EQUAL  -> ");
        }

        while(!stack.isEmpty()){
            if(!stack.pop().equals(queue.removeFirst())){
                return false;
            }
        }
        return true;
    }

    public static String convertDecimalToBinary(int num){

        final int base = 2;
        Stack digits = new Stack();

        while(num > 0){
            //[1, 1, 0, 1]
            digits.push(num % base);
            num = num / base;
        }

        String bits = "";
        while (!digits.isEmpty()){
            bits += digits.pop();
        }
        digits.toString();
        return bits;
    }
}