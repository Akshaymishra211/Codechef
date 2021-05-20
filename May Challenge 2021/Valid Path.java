import java.io.*;
import java.util.*;

class E {
	//lexographically best moves...
	public static int dx[] = { 1, 0, 0, -1 };
	public static int dy[] = { 0, -1, 1, 0 };
	public static ArrayList<Integer> adj[];
	public static long cnt[],pref_sum[];
	public static long mod=1000000007L,extra;
	public static int n;
	public static void dfs(int node,int parent_node) {
		for(int adj_node:adj[node]) {
			if(adj_node!=parent_node) {
				dfs(adj_node,node);
			}
		}
		int size=0,idx=0;
		long ans=0L,extra_cnt=0L;
		for(int adj_node:adj[node]) {
			if(adj_node!=parent_node) {
				ans+=(2L*cnt[adj_node]);
				//ans%=mod;
				size++;
			}
		}
		ans+=1;
		cnt[node]=ans%mod;
		pref_sum=new long[size];
		for(int adj_node:adj[node]) {
			if(adj_node!=parent_node) {
				pref_sum[idx]=cnt[adj_node];
				idx++;
			}
		}
		for(int i=1;i<size;i++) {
			pref_sum[i]+=pref_sum[i-1];
			//pref_sum[i]%=mod;
		}
		idx=0;
		for(int adj_node:adj[node]) {
			if(adj_node!=parent_node) {
				extra_cnt+=(cnt[adj_node]*(pref_sum[size-1]-pref_sum[idx]));
				//extra_cnt%=mod;
				idx++;
			}
		}
		
		extra+=(2L*extra_cnt)%mod;
		extra%=mod;
	}
	public static void main(String[] args) throws FileNotFoundException {
		FastScanner fs = new FastScanner();
		FastOutput fo = new FastOutput(System.out);
		long initial_time = System.currentTimeMillis();
		int testcases = fs.nextInt();
		for (int tt = 0; tt < testcases; tt++) {
			//main code
			n=fs.nextInt();
			extra=0L;
			adj=new ArrayList[n+1];
			cnt=new long[n+1];
			for(int i=0;i<n+1;i++) {
				adj[i]=new ArrayList<>();
			}
			int u,v;
			for(int i=0;i<n-1;i++) {
				u=fs.nextInt();
				v=fs.nextInt();
				adj[u].add(v);
				adj[v].add(u);
			}
			//assuming root node to be 1...
			dfs(1,0);
			fo.println((cnt[1]%mod+extra%mod)%mod);
		}
		//fo.time(initial_time);
		fo.close();
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner() throws FileNotFoundException {
			//if (System.getProperty("ONLINE_JUDGE") == null) {
				//Read from the File...
			//	File file = new File("src\\input");
			//	br = new BufferedReader(new FileReader(file));
			//} else {
				//Read from the System...
				br = new BufferedReader(new InputStreamReader(System.in));
			//}
			st = new StringTokenizer("");
		}

		String next() {
			while (!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}

	static class FastOutput extends PrintWriter {

		public FastOutput(PrintStream out) {
			super(out);
		}

		void time(long init) {
			if (System.getProperty("ONLINE_JUDGE") == null) {
				this.println(System.currentTimeMillis() - init + "ms");
			}
		}
	}
}
