import java.util.*;
public class Main {
	public static void transpose(int arr[][],int n) {
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				int temp=arr[i][j];
				arr[i][j]=arr[j][i];
				arr[j][i]=temp;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int testcase=sc.nextInt();
		for(int x=0;x<testcase;x++) {
			int N=sc.nextInt();
			int ori_mat[][]=new int[N][N];
			int curr_mat[][]=new int[N][N];
			int cnt=1;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					ori_mat[i][j]=cnt;
					cnt++;
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					curr_mat[i][j]=sc.nextInt();
				}
			}
			int ans=0;
			for(int k=N;k>1;k--) {
				if(curr_mat[0][k-1]!=k) {
					ans++;
					Main.transpose(curr_mat,k);
				}
			}
			System.out.println(ans);
		}
	}

}
