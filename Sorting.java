public class Sorting {

    public static void display(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void bubbleSort(int arr[]){
        // In bubble sort the outer loop decides how many times the number of rounds to do
        // The inner loop does the swapping
        // For each ith iteration the range of j reduces by 1 as the elements will keep getting correctly placed at the end

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

    }
    
    public static void SelectionSort(int arr[]){
        // The outer loop decides the number of rounds same as bubble sort
        // For each ith round the loop reduces by 1 from start as the correct elements keep getting correctly placed at the start.
        // Here , the swapping is only done once for each round. 
        // In this for each ith round , the smallest element is taken at put at the start

        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void InsertionSort(int arr[]){
        // This sorting divides array into sorted and unsorted part using sortedIdx.
        // In this , the outer loop decides the range of unsorted part of array
        // The inner while loop is for taking the element from unsorted part and iterating back from the sorted part (before sortedIdx) to find the right position for the element taken from the unsorted part.
        // 


        int sortedIdx = 0;
        for (int i = 1; i < arr.length; i++) {
            int itr = sortedIdx;
            int elemItr = i;
            while (itr >= 0) {
                if(arr[elemItr] < arr[itr]){
                    int temp = arr[itr];
                    arr[itr] = arr[elemItr];
                    arr[elemItr] = temp;
                    elemItr--;
                }
                else{
                    break;
                }
                itr--;
            }
            sortedIdx++;
        }
    }

    public static void CountingSort(int arr[]){
        // Create a count array consisting of that element count at each INDEX of count array.
        // Now loop through the count array and keep adding the the elements from count array's idx till the count becomes 0.

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        
        int count[] = new int[max+1];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int itr = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[itr] = i;
                itr++;
                count[i]--; 
            }
        }
    }

    public static void main(String args[]){

        int arr[] = {5 , 1 , 3 , 2 , 4};

        // bubbleSort(arr);
        // SelectionSort(arr);
        // InsertionSort(arr);
        CountingSort(arr);
        display(arr);
        

    }
}
