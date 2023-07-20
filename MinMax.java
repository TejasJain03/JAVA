public class MinMax{
    
    public static void main(String[] args){
        int[] arr={1,2,3,4,5};
        int size=arr.length;
        minmax(0,size-1,arr[0],arr[size-1],arr);
    }
    static void minmax(int i,int j,int min,int max,int arr[]){
        if(i==j){
            min=max=arr[i];
        }
        else if(i==j-1){
            
        }
    }   
}