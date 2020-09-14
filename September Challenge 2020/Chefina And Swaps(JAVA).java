/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner sc=new Scanner(System.in);
		FastReader sc=new FastReader();
		int testcase=sc.nextInt();
		for(int t=0;t<testcase;t++) {
			long N=sc.nextLong();
			if(N==1 || N==2) {
				System.out.println(0);
			}
			else {
				long totalsum=(N*(N+1))/2;
				if(totalsum%2==0){
					long need=totalsum/2;
					long fulfill=(long)(Math.sqrt(4*totalsum+1)-1)/2;
					long need1=(fulfill*(fulfill+1))/2;
					long diff=need-need1;
					if(diff!=0) {
						System.out.println(N-fulfill);
					}
					else {
						long ans=N-fulfill;
						long x=(fulfill*(fulfill-1))/2;
						long temp=N-fulfill;
						long y=(temp*(temp-1))/2;
						System.out.println(x+y+ans);
					}
				}
				else {
					System.out.println(0);
				}
			}
		}
	}

}
