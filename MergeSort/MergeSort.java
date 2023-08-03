import java.util.Random;
import java.util.Scanner;

public class MergeSort {
    public static void main(String args[]){
        int size;
        Random r=new Random();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Size of Array:");
        size=sc.nextInt();
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=r.nextInt(100);
        }
        // System.out.println("Before sorting");
        // for(int i=0;i<size;i++){
        //     System.out.print(arr[i]+"\t");
        // }
        long start=System.currentTimeMillis();
        mergeSort(arr);
        long stop=System.currentTimeMillis();
        // System.out.println("After Sorting");
        // for(int i=0;i<arr.length;i++){
        //     System.out.print(arr[i]+"\t");
        // }
        System.out.println();
        System.out.println("Time Taken:"+(stop-start)+"ms");
    }

    private static void mergeSort(int[] arr){
        int length=arr.length;
        if(length<=1) return;

        int middle=length/2;
        int[] leftArray=new int[middle];
        int[] rightArray=new int[length-middle];

        int i=0,j=0;
        for(;i<length;i++)
        {
            if(i<middle){
                leftArray[i]=arr[i];
            }
            else{
                rightArray[j]=arr[i];
                j++;
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray,rightArray,arr);
    }

    private static void merge(int[] leftArray, int[] rightArray,int[] arr){

        int leftSize=arr.length/2;
        int rightSize=arr.length-leftSize;
        int i=0,l=0,r=0;
        while(l<leftSize && r<rightSize ){
            if(leftArray[l]<rightArray[r]){
                arr[i]=leftArray[l];
                i++;
                l++;
            }
            else{
                arr[i]=rightArray[r];
                i++;
                r++;
            }
        }

        while(l<leftSize){
            arr[i]=leftArray[l];
            i++;
            l++;
        }
        while(r<rightSize){
            arr[i]=rightArray[r];
            i++;
            r++;
        }

    }
}
