import java.io.*;
import java.util.*;

public class Main {
	public static int binary[]= {536870912 ,268435456 ,134217728 ,67108864 ,33554432 ,16777216 ,8388608 ,4194304 ,2097152 ,1048576 ,524288 ,262144 ,131072 ,65536 ,32768 ,16384 ,8192 ,4096 ,2048 ,1024 ,512 ,256 ,128 ,64 ,32 ,16 ,8 ,4 ,2 ,1};
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() throws Exception {
			//InputStream inputStream = new FileInputStream(
			//		"C:\\Users\\Dell\\eclipse-workspace\\Java CP\\src\\input.txt");
			//br = new BufferedReader(new InputStreamReader(inputStream));
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
	public static void main(String[] args) throws Exception {
		FastReader s = new FastReader();
		BufferedWriter o = new BufferedWriter(new OutputStreamWriter(System.out));
		int testcases = s.nextInt();
		for (int run = 0; run < testcases; run++) {
			//System.out.println("Case #"+(t+1)+": "+Main.solve(sc);)
			int N=s.nextInt();
			int X=s.nextInt();
			int l[]=new int [N];
			int arr[][]=new int[N][30];
			for(int i=0;i<N;i++) {
				l[i]=s.nextInt();
				int index=29,decimal=l[i];
				while(decimal>0) {
					arr[i][index--]=decimal%2;
					decimal>>=1;
				}
			}
			if(N>2) {
				int cnt=0;
				outerloop:
				for(int i=0;i<N;i++) {
					for(int j=0;j<30;j++) {
						if(arr[i][j]==1) {
							boolean flag=false;
							arr[i][j]=0;
							for(int k=i+1;k<N;k++) {
								if(arr[k][j]==1) {
									arr[k][j]=0;
									cnt++;
									flag=true;
									break;
								}
							}
							if(!flag) {
								cnt++;
								arr[N-1][j]=1;
							}
						}
						if(cnt==X) {
							break outerloop;
						}
					}
				}
				for(int i=0;i<N;i++) {
					int ans=0;
					for(int j=0;j<30;j++) {
						ans+=arr[i][j]*Main.binary[j];
					}
					o.write((ans+" "));
				}
				o.write(("\n"));
				o.flush();			
			}
			else {
				int cnt=0;
				boolean istrue=false;
				for(int i=0;i<30;i++){
				    if(arr[0][i]==1 && arr[1][i]==1) {
				          arr[0][i]=0;
				          arr[1][i]=0;
				          cnt+=1;
				    }
				    else if(arr[0][i]==1 && arr[1][i]==0) {
				          arr[0][i]=0;
				          arr[1][i]=1;
				          cnt+=1;
				    }
				    if(cnt==X) {
				          istrue=true;
				    }
				}
				if(istrue){
					for(int i=0;i<2;i++) {
						int ans=0;
						for(int j=0;j<30;j++) {
							ans+=arr[i][j]*Main.binary[j];
						}
						//System.out.print(ans+" ");
						o.write((ans+" "));
					}
					o.write(("\n"));
					o.flush();
				}
				else {
					if((X%2==0 && cnt%2==0) || (X%2!=0 && cnt%2!=0)){
						for(int i=0;i<2;i++) {
							int ans=0;
							for(int j=0;j<30;j++) {
								ans+=arr[i][j]*Main.binary[j];
							}
							o.write((ans+" "));
						}
						o.write(("\n"));
						o.flush();
					}
					else {
						if(arr[0][29]==0 && arr[1][29]==0) {
		                    arr[0][29]=1;
		                    arr[1][29]=1;
						}
						else if(arr[0][29]==1 && arr[1][29]==0) {
		                    arr[0][29]=0;
		                    arr[1][29]=1;
						}
						else if(arr[0][29]==0 && arr[1][29]==1) {
		                    arr[0][29]=1;
		                    arr[1][29]=0;
						}
						for(int i=0;i<2;i++) {
							int ans=0;
							for(int j=0;j<30;j++) {
								ans+=arr[i][j]*Main.binary[j];
							}
							o.write((ans+" "));
						}
						o.write(("\n"));
						o.flush();
					}
				}
			}
		}
	}
}
