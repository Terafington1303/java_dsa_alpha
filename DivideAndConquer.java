public class DivideAndConquer {

    public static void printArr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void mergeSort(int arr[] , int si  ,int ei){
        if (si >= ei) {
            return;
        }

        int mid = si + (ei - si)/2;

        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);

        merge(arr, si, mid , ei);
    }

    public static void merge(int arr[] , int si , int mid , int ei){
        int a = si;
        int b = mid+1;
        int temp[] = new int[ei-si+1];
        int itr = 0;

        while (a <= mid && b <= ei) {
            if (arr[a] < arr[b]) {
                temp[itr] = arr[a];
                itr++;
                a++;
            }
            else{
                temp[itr] = arr[b];
                itr++;
                b++;
            }
        }

        while (a <= mid) {
            temp[itr] = arr[a];
            a++;
            itr++;
        }
        while (b <= ei) {
            temp[itr] = arr[b];
            b++;
            itr++;
        }

        for (int i = 0; i < temp.length; i++) {
            arr[si] = temp[i];
            si++;
        }

    }
    
    public static void quickSort(int arr[] , int si , int ei){
        if (ei <= si) {
            return; 
        }

        int pidx = partition(arr , si , ei);

        quickSort(arr, si, pidx-1);
        quickSort(arr, pidx+1, ei);

    }

    public static int partition(int arr[] , int si , int ei){
         int itr = si-1;
         int pivot = arr[ei];

         for (int i = si; i <= ei; i++) {
            if (arr[i] < pivot) {
                itr++;
                int temp = arr[i];
                arr[i] = arr[itr];
                arr[itr] = temp;
            }
         }
         itr++;
         int temp = arr[ei];
         arr[ei] = arr[itr];
         arr[itr] = temp;

         return itr;
        }

        public static int rotatedSearch(int arr[] , int key){

            int si = 0; 
            int ei = arr.length-1;
            while (ei >= si) {
                int mid = (si+ei)/2;
                if (arr[mid] == key) {
                    return mid;
                }

                if (arr[mid] > arr[si]) {
                    if (key <= arr[mid] && key >= arr[si]) {
                         ei = mid;
                    }
                    else{
                        si = mid+1;
                    }
                }
                else{
                    if (key >= arr[mid+1] && key <= arr[ei]) {
                        si = mid+1;
                    } else {
                        ei = mid;
                    }
                }

            }


            return -1;
        }
    
        
        public static void main(String args[]){

            // int arr[] = {6 , 3 , 9 , 5 , 2 , 8};
            int arr[] = {4 , 5 , 6 , 7 , 0 , 1 , 2};
    
            // mergeSort(arr , 0 , arr.length-1);
            // quickSort(arr , 0 , arr.length-1);
            // printArr(arr);
            System.out.println(rotatedSearch(arr , 2));

    
    
    
        }

}

// Approach -- Divide big problem into small problem , find small solution and then convert to big solution.

// Merge Sort Logic
// Divide arrays into smaller array till n == 1.
// Then while iterating back , compare two arrays using merge function. Array divided based on the middle.
// The merge function simply creates a temp array , combines two arrays into it in sorted manner , then again it is copied down to the original array using for loop. 

// Quick Sort Logic
// Find Pivot Index (Last Elem)
// Then based on that value arrange elements lesser than pivot to its left and others at right. Done using parititon function. 
// Then divide array into two (left) and (right) of pivot and again call the partition function on them.

