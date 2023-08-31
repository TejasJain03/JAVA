import java.util.Scanner;

public class Floyd{
    int min(int i,int j){
        if(i<j){
            return i;
        }
        else{
            return j;
        }
    }
    void result(int[][] w, int n){
        int i,j,k;
        for(k=0;k<n;k++){
            for(i=0;i<n;i++){
                for(j=0;j<n;j++){
                    w[i][j]=min(w[i][j],w[i][k]+w[k][j]);
                }
            }
        }
        System.out.println("Result:");
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                System.out.print(w[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int[][] w=new int[10][10];
        int n,i,j;
        System.out.println("Enter the number of vertices:");
        n=sc.nextInt();
        System.out.println("Enter the weighted graph:");
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                w[i][j]=sc.nextInt();
            }
        }
        Floyd f=new Floyd();
        f.result(w, n);
    }
}