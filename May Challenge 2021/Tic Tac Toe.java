import java.io.*;
import java.util.*;

class B {
	//lexographically best moves...
	public static int dx[] = { 1, 0, 0, -1 };
	public static int dy[] = { 0, -1, 1, 0 };
	public static char board[][];
	public static int cnt_X,cnt_O;
	public static boolean valid,X,O,D;
	public static boolean checkWon(char val) {
		char c=val;
		boolean is=false;
		//all 3 rows
		for(int i=0;i<3;i++) {
			if(board[i][0]==c && board[i][1]==c && board[i][2]==c) {
				is=true;
			}
		}
		// all 3 columns
		for(int i=0;i<3;i++) {
			if(board[0][i]==c && board[1][i]==c && board[2][i]==c) {
				is=true;
			}
		}
		//all diagonals
		if(board[0][0]==c && board[1][1]==c && board[2][2]==c) {
			is=true;
		}
		if(board[0][2]==c && board[1][1]==c && board[2][0]==c) {
			is=true;
		}
		return is;
	}
	public static boolean isDraw() {
		if(cnt_X==5 && cnt_O==4) {
			return true;
		}
		return false;
	}
	public static boolean isValidBoard() {
		if((cnt_X-cnt_O)<0 || (cnt_X-cnt_O)>1) {
			return false;
		}
		if((X && O) || (X && cnt_X<=cnt_O) || (O && cnt_X!=cnt_O)) {
			return false;
		}
		return true;
	}
	public static void main(String[] args) throws FileNotFoundException {
		FastScanner fs = new FastScanner();
		FastOutput fo = new FastOutput(System.out);
		long initial_time = System.currentTimeMillis();
		int testcases = fs.nextInt();
		for (int tt = 0; tt < testcases; tt++) {
			//main code
			board=new char[3][3];
			cnt_X=0;cnt_O=0;
			for(int i=0;i<3;i++) {
				String s=fs.next();
				for(int j=0;j<3;j++) {
					board[i][j]=s.charAt(j);
				}
			}
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					if(board[i][j]=='X') {
						cnt_X++;
					}
					if(board[i][j]=='O') {
						cnt_O++;
					}
				}
			}
			X=checkWon('X');
			O=checkWon('O');
			D=isDraw();
			valid=isValidBoard();
			if(!valid) {
				fo.println(3);
			}
			else if(D || X || O) {
				fo.println(1);
			}
			else {
				fo.println(2);
			}
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
