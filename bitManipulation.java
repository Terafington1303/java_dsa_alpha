public class bitManipulation {

    public static void isEvenOdd(int num){

        int bitmask = 1;

        int ans = num & bitmask;

        if (ans == 0) {
            System.out.println("Number is Even");
        } else {
            System.out.println("Number is Odd");
        }

    }
    
    public static int getIthBit(int num , int i){
        int bitmask = 1<<i;

        if ((num & bitmask) != 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int setIthBit(int num , int i){

        int bitmask = 1<<i;

        return num | bitmask;
    }

    public static int clearIthBit(int num , int i){

        int bitmask = ~(1<<i);

        return num & bitmask;
    }

    public static int updateIthBit(int num , int i , int newBit){

       num = clearIthBit(num, i);
       int bitmask = newBit<<i;
       return num | bitmask;

    }

    public static int clearLastRange(int num , int i){
        int bitmask = ~0<<i;

        return num & bitmask;
    }

    public static int clearRange(int num , int i , int j){
        
        int mask1 = ((~0)<<(j+1));
        // int mask2 = (int) Math.pow(2, i) - 1;
        int mask2 = (1<<i)-1;
        int bitmask = mask1 | mask2;

        return num & bitmask;

    }

    public static boolean isPowerofTwo(int num){

        return (num & (num-1)) == 0;
    }

    public static int countSetBits(int num){

        int count = 0;
        while (num > 0) {
            if((num & 1) != 0){
                count++;
            }
           num = num>>1;
        }

        return count;

    }

    public static int fastExpo(int num , int i){


        int ans = 1;
        int val = num;
        while(i != 0){
            if ((i & 1) != 0) {
                ans *= val;
            }
            i = i>>1;
            val = val*val;
        }

        return ans;
    }
    
    public static void swap(int x , int y){

        System.out.println(x);
        System.out.println(y);
        y = x ^ y;
        x = x ^ y;
        y = x ^ y;
        System.out.println(x);
        System.out.println(y);

    }
    
    public static int addOne(int num){

        return -~num;
    }

    public static void upperToLower(){

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print((char) (ch | ' ') + " ");
        }
    }

    public static void main(String args[]){

        // int num = 14;

        // isEvenOdd(num);
        // System.out.println(getIthBit(num , 2));
        // System.out.println(setIthBit(num , 2));
        // System.out.println(clearIthBit(num, 2));
        // System.out.println(updateIthBit(num, 2, 1));
        // System.out.println(clearLastRange(num , 2));
        // System.out.println(clearRange(num , 2 , 4));
        // System.out.println(isPowerofTwo(8));
        // System.out.println(countSetBits(num));
        // System.out.println(fastExpo(2 , 3));
        // swap(3 , 5);
        // System.out.println(addOne(5));
        // upperToLower();

    }
}

/* Notes

 1. For compliment of any number , we get negative value. But to find the actual value , we need to find 2s compliment.
 2. ~0 === -1
 3. a<<b === a * 2^b
 4. a>>b === a / 2^b
 5. To get Last Bit === num & 1
 6. To get ith Bit === num & (1<<i)
 7. To set ith Bit === num | (1<<i)
 8. To clear ith Bit === num & ~(1<<i)
 9. 2^b === (1<<i)
 10. num ^ num === 0
 11. -~num = num+1
 12. num & (num-1) === 0 if num is power of 2


 */

