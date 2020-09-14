/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws java.lang.Exception
	{
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int testcase=sc.nextInt();
		for(int i=0;i<testcase;i++) {
			int N=sc.nextInt();
			Set<Integer> ans=new HashSet<Integer>();
			for(int j=0;j<N;j++) {
				int temp=sc.nextInt();			
				if(temp!=0) {
					ans.add(temp);
				}
			}
			int finalans=ans.size();
			System.out.println(finalans);
		}
	}

}
