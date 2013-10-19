import java.io.*;
import java.util.*;

/*
Little chief has his own restaurant in the city. There are N workers there. Each worker has his own salary. The salary of the i-th worker equals to Wi (i = 1, 2, ..., N). Once, chief decided to equalize all workers, that is, he wants to make salaries of all workers to be equal. But for this goal he can use only one operation: choose some worker and increase by 1 salary of each worker, except the salary of the chosen worker. In other words, the chosen worker is the loser, who will be the only worker, whose salary will be not increased during this particular operation. But loser-worker can be different for different operations, of course. Chief can use this operation as many times as he wants. But he is a busy man. That's why he wants to minimize the total number of operations needed to equalize all workers. Your task is to find this number.
Input

The first line of the input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the number of workers. The second line contains N space-separated integers W1, W2, ..., WN denoting the salaries of the workers.
Output

For each test case, output a single line containing the minimum number of operations needed to equalize all workers.
Constraints

1 = T = 100
1 = N = 100
0 = Wi = 10000 (104)
Example

Input:
2
3
1 2 3
2
42 42

Output:
3
0
Explanation

Example Case 1. Chief can equalize all salaries in 3 turns:
Turn ID	IDs of involved workers	Salaries after the move
1	 1 2	 2 3 3
2	 1 2	 3 4 3
3	 1 3	 4 4 4
Example Case 2. All salaries are already equal. He doesn't need to do anything.
*/

class test {

    public static void main(String args[]){
    	Scanner in = new Scanner(System.in);
    	
    	int t = in.nextInt();
    	for(int i=0;i<t;i++){
    		int n = in.nextInt();
    		int arr[] = new int[n];
    		for(int j=0;j<n;j++){
    			arr[j] = in.nextInt();
    		}
    		
    		mergeSort(arr, 0, n-1);
    		
    		int count = 0;
    		int k = n-1;
    		while(k>0 && (arr[k]-arr[0])>0){
    			count+=arr[k]-arr[0];
    			k--;
    		}
    		System.out.println(count);
    	}
    }
    
    public static void mergeSort(int array[], int low, int high){
    	if(low >=high)
    		return;
    	int mid = (low+high)/2;
    	mergeSort(array,low,mid);
    	mergeSort(array,mid+1,high);
    	int end_low = mid;
    	int start_high = mid+1;
    	
    	while((low <= end_low) && (start_high <= high)){
    		if (array[low] < array[start_high]) {
  				low++;
  			} else {
  				int Temp = array[start_high];
  				
  				for (int k = start_high- 1; k >= low; k--) 
  					array[k+1] = array[k];
  				
  				
  				array[low] = Temp;
  				low++;
  				end_low++;
  				start_high++;
    		}
   		}
    }
    
}