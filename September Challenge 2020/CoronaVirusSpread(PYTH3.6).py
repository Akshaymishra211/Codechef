# cook your dish here
for _ in range(int(input())):
    N=int(input())
    l=[int(i) for i in input().split()][:N]
    #for i in range(N):
    #    l[i].append(i)
    mini,maxi=N,1
    #arr=[False for i in range(N)]
    for i in range(N):
        curr=l[i]
        agebade=[]
        pichebadeinf=[]
        agechoteinf=[]
        pichechote=[]
        cnt=1
        for j in range(i+1,N):
            if l[j]>=curr:
                agebade.append(l[j])
            else:
                agechoteinf.append(l[j])
                cnt+=1
        for j in range(i):
            if l[j]>curr:
                cnt+=1
                pichebadeinf.append(l[j])
            else:
                pichechote.append(l[j])
        arr=[False]*len(agebade)
        for x in range(len(pichebadeinf)):
            for y in range(len(agebade)):
                if pichebadeinf[x]>agebade[y] and not arr[y]:
                    cnt+=1
                    #agebade.pop(y)
                    arr[y]=True
        arr1=[False]*len(pichechote)
        for x in range(len(agechoteinf)):
            for y in range(len(pichechote)):
                if agechoteinf[x]<pichechote[y] and not arr1[y]:
                    cnt+=1
                    arr1[y]=True
        #print(agebade,curr)
        #print(pichebadeinf,curr)
        #print(agechoteinf,curr)
        #print(pichechote,curr)
        mini=min(mini,cnt)
        maxi=max(maxi,cnt)
    print(mini,maxi)
