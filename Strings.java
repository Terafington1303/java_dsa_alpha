import java.util.Arrays;

public class Strings {

    public static boolean palindrome(String str){
        int i = 0;
        int j = str.length()-1;

        while (i < j) {
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    public static String upperCase(String str){
        StringBuilder sb = new StringBuilder("");

       sb.append(Character.toUpperCase(str.charAt(0)));
       int i = 1;
       while (i < str.length()) {
        sb.append(str.charAt(i));
        if (str.charAt(i) == ' ' && i != str.length()-1) {
            sb.append(Character.toUpperCase(str.charAt(i+1)));
            i++;
        }
        i++;
       }
       return sb.toString();
    }

    public static String stringCompress(String str){
        StringBuilder sb = new StringBuilder("");
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int count = 1;
            while (i != str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
                i++;
                count++;
            }
            sb.append(ch);
            sb.append(count);
        }

        return sb.toString();
    }

    public static boolean anagram(String str1 , String str2){
        if (str1.length() != str2.length()) {
            return false;
        }
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        boolean result = Arrays.equals(ch1, ch2);
        if(result){
            return true;
        }

        return false;
        
    }

    public static void main(String args[]){

        // String str = new String("Hello World");
        // String str = "hello my name is aditya";

        // String methods
        // str.length();
        // str.charAt(i);
        // str.equals(str2);
        // str.substring(si , ei);
        // str1.compareTo(str2);
        // str1.compareToIgnoreCase(str2);
        // sb.toString();  ---- Converts Only objects to String
        // Stringbuilder --- sb.append('a');
        // str.toUpperCase();
        // str.toLowerCase();
        // Character.toUpperCase(ch);
        // str.replace('c' , 'k');
        // str.toCharArray();

        // System.out.println(palindrome(str));

        // == checks if the strings are same on object level that is same memory location.
        // The new keyword creates new string in memory instead of pointing to the old one

        // System.out.println(upperCase(str));
        // System.out.println(stringCompress("aaabbcddde"));
        // System.out.println(anagram("cace" , "race"));

        // String constant pool --- special area where only unqiue strings are present
        // Allocate strings over there using .intern() method.
        
        // String builder is faster than string buffer.
        // String buffer is considered for thread safety (synchronized) for multithreaded environments
    }

}
