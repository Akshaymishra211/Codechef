from collections import defaultdict,Counter
def calefficiency(arr,s,e,K):
    #print(s,e)
    total=Counter(arr[s:e+1])
    #print(total)
    x=list(total.keys())
    cnt=K
    for i in x:
        if total[i]>1:
            cnt+=total[i]
    return cnt
def check(arr,s,e,value,K):
    index=-1
    mini=value
    for i in range(s,e):
        ans1=calefficiency(arr,s,i,K)
        ans2=calefficiency(arr,i+1,e,K)
        #print(ans1+ans2)
        if (ans1+ans2)<=mini:
            index=i
            mini=ans1+ans2
    return index,mini


for _ in range(int(input())):
    N,K=map(int,input().split())
    l=[int(i) for i in input().split()][:N]
    if K==1:
        cnt=1
        d=defaultdict(bool)
        for i in range(N):
            if not d[l[i]]:
                d[l[i]]=True
            else:
                cnt+=1
                d=defaultdict(bool)
                d[l[i]]=True
        print(cnt)
    else:
        stack=[[0,N-1]]
        #print(cnt)
        #ifnotfinal=calefficiency(l,0,N-1,K)
        final=[]
        fix=[]
        while len(stack)>0:
            temp=stack.pop()
            ineffi=calefficiency(l,temp[0],temp[1],K)
            final.append([temp[0],temp[1],ineffi])
            newindex,newmini=check(l,temp[0],temp[1],ineffi,K)
            #print(newindex,newmini)
            if newindex!=-1:
                final.pop()
                stack.append([newindex+1,temp[1]])
                stack.append([temp[0],newindex])
            else:
                fix.append(final.pop())
            #print(stack)
        #print(final)
        #print(fix)
        ans=0
        while len(final)>0:
            temp=final.pop()
            ans+=temp[2]
        while len(fix)>0:
            temp=fix.pop()
            ans+=temp[2]
        print(ans)
        '''print(finalans,ifnotfinal)
        if finalans!=0:
            print(finalans)
        else:
            print(ifnotfinal)'''
