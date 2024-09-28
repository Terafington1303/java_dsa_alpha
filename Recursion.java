public class Recursion{

    public static void findOccurences(int arr[] , int key , int i){

        if (i == arr.length) {
            return;
        }

        if (arr[i] == key) {
            System.out.print(i + " ");
        }

        findOccurences(arr, key, i+1);

    }
    
    public static int length(String str , int i){

        if (str.length()  == 0) {
            return i;
        }

        return length(str.substring(1), i+1);
    }

    public static void numToString(int val , String num[]){

        if (val == 0) {
            return;
        }

        numToString(val/10, num);
        int digit = val%10;
        System.out.print(num[digit] + " ");



    }

    public static void main(String args[]){
        // int arr[] = {3 , 2 ,  4 , 5 , 6 , 2 , 7 , 2 , 2};
        // String num[] = {"zero" , "one" , "two" , "three" , "four" , "five" , "six" , "seven" , "eight" , "nine"};

        // findOccurences(arr , 2 , 0);
        // System.out.println(length("aditya", 0));
        // numToString(1357 , num);

    }
}