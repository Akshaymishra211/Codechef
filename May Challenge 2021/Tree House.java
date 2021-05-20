import java.io.*;
import java.util.*;

class C {
	//lexographically best moves...
	public static int dx[] = { 1, 0, 0, -1 };
	public static int dy[] = { 0, -1, 1, 0 };
	public static int n;
	public static long x;
	public static long sum[],mod=1000000007;
	public static Map<Integer, ArrayList<Integer>> adj;
	//public static PriorityQueue<Long> q;
	public static ArrayList<Long> q;
	public static FastOutput fo;
	public static void dfs(int node,int parent_node) {
		for(int adj_node:adj.get(node)) {
			if(adj_node!=parent_node) {
				dfs(adj_node,node);
			}
		}
		for(int adj_node:adj.get(node)) {
			if(adj_node!=parent_node) {
				q.add(sum[adj_node]);
			}
		}
		Collections.sort(q,Collections.reverseOrder());
		long cnt=0L,val=1,temp;
		for (int i=0;i<q.size();i++) {
			temp=Math.abs(q.get(i));
			temp=(temp+1)*val;
			val++;
			cnt+=temp;
		}
		q.clear();
		sum[node]=cnt;
	}
	public static void main(String[] args) throws FileNotFoundException {
		FastScanner fs = new FastScanner();
		fo = new FastOutput(System.out);
		long initial_time = System.currentTimeMillis();
		int testcases = fs.nextInt();
		for (int tt = 0; tt < testcases; tt++) {
			//main code
			n=fs.nextInt();
			x=fs.nextLong();
			sum=new long[n+1];
			adj=new TreeMap<>();
			//q=new PriorityQueue<>();
			q=new ArrayList<>();
			for(int i=1;i<n+1;i++) {
				adj.put(i, new ArrayList<>());
			}
			int u,v;
			for(int i=0;i<n-1;i++) {
				u=fs.nextInt();
				v=fs.nextInt();
				adj.get(u).add(v);
				adj.get(v).add(u);
			}
			//now use dfs to traverse the tree and assign correct values to all the nodes using priority queue...........
			dfs(1,0);
			sum[1]++;
			long ans=sum[1]%mod*x%mod;
			fo.println(ans);
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
