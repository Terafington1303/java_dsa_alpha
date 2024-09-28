public class Arrays{

    public static void display(int arr[]){

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int linearSearch(int arr[] , int key){

        for(int i=0; i<arr.length; i++){
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int largest(int arr[]){
        int largest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > largest){
                largest = arr[i];
            }
        }
        return largest;
    }

    public static int binarySearch(int arr[] , int key){

        int i = 0;
        int j = arr.length-1;
        while (j >= i) { 
            int mid = (i+j)/2;
            if (arr[mid] == key) {
                return mid;
            }
            else if(key > arr[mid]){
                i = mid+1;
            }
            else{
                j = mid-1;
            }
        }
        return -1;
    }

    public static void reverseArr(int arr[]){
        int i = 0; 
        int j = arr.length-1;

        while (i < j) { 
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void pairs(int arr[]){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                System.out.print("(" + arr[i] + " , " + arr[j] + ")");
            }
            System.out.println();
        }
    }

    public static int subArrSumBrute(int arr[]){

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int sum = 0;
                for (int j2 = i; j2 <= j; j2++) {
                    sum += arr[j2];
                }
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public static int subArrayPrefix(int arr[]){
        int max = Integer.MIN_VALUE;
        int prefix[] = new int[arr.length];

        prefix[0] = arr[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = arr[i] + prefix[i-1];
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int sum = (i==0) ? prefix[j] : prefix[j] - prefix[i-1];

                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public static int kadanes(int arr[]){

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum < 0) {
                sum = 0;
            }
            sum += arr[i];

            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public static int trappingWater(int arr[]){
        int leftMax[] = new int[arr.length];
        int rightMax[] = new int[arr.length];

        leftMax[0] = arr[0];
        for (int i = 1; i < leftMax.length; i++) {
            leftMax[i] = Math.max(arr[i], leftMax[i-1]);
        }

        rightMax[arr.length-1] = arr[arr.length-1];
        for (int i = arr.length-2; i >= 0; i--) {
            rightMax[i] = Math.max(arr[i], rightMax[i+1]);
        }

        int waterTrapped = 0;
        for (int i = 0; i < arr.length; i++) {
            waterTrapped += Math.min(leftMax[i], rightMax[i]) - arr[i];
        }

        return waterTrapped;
    }

    public static int stocks(int arr[]){
        int max = Integer.MIN_VALUE;
        int buyPrice = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < buyPrice){
                buyPrice = arr[i];
                continue;
            }
            int profit = arr[i] - buyPrice;

            if (profit > max) {
                max = profit;
            }
        }
        return max;
    }

    public static int secondLargest(int arr[]){

        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > largest){
                largest = arr[i];
            }
        }

        int secondLargest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < largest & arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }

    public static void main(String args[]){

        // List of elements of same type stored in contigous memory location
        // Array Creation two ways
        // int arr[] = new int[5];
        int arr2[] = {7  ,1 , 5 , 3 , 6 , 4};
        // int arr3[] = {4 , 2 , 0 , 6 , 3 , 2 , 5};

        // System.out.println(linearSearch(arr2 , 5));
        // System.out.println(largest(arr2));
        // System.err.println(binarySearch(arr2 , 9));
        // reverseArr(arr2);
        // pairs(arr2);
        // System.out.println(subArrSumBrute(arr2));
        // System.out.println(subArrayPrefix(arr2));
        // System.out.println(kadanes(arr2));
        // System.out.println(trappingWater(arr3));
        // System.out.println(stocks(arr2));
        System.out.println(secondLargest(arr2));




    }
}