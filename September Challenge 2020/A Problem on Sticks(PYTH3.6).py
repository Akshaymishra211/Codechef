# cook your dish here
for _ in range(int(input())):
    N=int(input())
    l=[int(i) for i in input().split()][:N]
    ans=len(set(l))
    if l.count(0)>0:
        print(ans-1)
    else:
        print(ans)
