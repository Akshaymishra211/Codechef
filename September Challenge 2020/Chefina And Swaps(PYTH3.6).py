# cook your dish here
import math
for _ in range(int(input())):
    N=int(input())
    if N==1 or N==2:
        print(0)
    elif N==3:
        print(2)
    else:
        totalsum=(N*(N+1))//2
        if totalsum%2==0:
            need=totalsum//2
            fulfill=int(math.sqrt(4*totalsum+1)-1)//2
            need1=(fulfill*(fulfill+1))//2
            diff=need-need1
            #print(totalsum)
            #print(need)
            #print(fulfill)
            #print(need1)
            #print("diff"+str(diff))
            #print(N-fulfill)
            #if fulfill+diff<=N:
            if diff!=0:
                print(N-fulfill)
            else:
                ans=N-fulfill
                x=(fulfill*(fulfill-1))//2
                temp=N-fulfill
                y=(temp*(temp-1))//2
                print(x+y+ans)
            #else:
            #print(diff+1)
        else:
            print(0)
