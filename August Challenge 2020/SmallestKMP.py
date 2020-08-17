from collections import OrderedDict
for _ in range(int(input())):
    S=input()
    P=input()
    precedence=OrderedDict({'a': 1, 'b': 2, 'c': 3, 'd': 4, 'e': 5, 'f': 6, 'g': 7, 'h': 8, 'i': 9, 'j': 10, 'k': 11, 'l': 12, 'm': 13, 'n': 14, 'o': 15, 'p': 16, 'q': 17, 'r': 18, 's': 19, 't': 20, 'u': 21, 'v': 22, 'w': 23, 'x': 24, 'y': 25, 'z': 26})
    scount=OrderedDict({'a': 0, 'b': 0, 'c': 0, 'd': 0, 'e': 0, 'f': 0, 'g': 0, 'h': 0, 'i': 0, 'j': 0, 'k': 0, 'l': 0, 'm': 0, 'n': 0, 'o': 0, 'p': 0, 'q': 0, 'r': 0, 's': 0, 't':0, 'u':0, 'v':0, 'w':0, 'x':0, 'y':0, 'z':0})
    pcount=OrderedDict({'a': 0, 'b': 0, 'c': 0, 'd': 0, 'e': 0, 'f': 0, 'g': 0, 'h': 0, 'i': 0, 'j': 0, 'k': 0, 'l': 0, 'm': 0, 'n': 0, 'o': 0, 'p': 0, 'q': 0, 'r': 0, 's': 0, 't':0, 'u':0, 'v':0, 'w':0, 'x':0, 'y':0, 'z':0})
    for i in P:
        pcount[i]+=1
    for i in S:
        scount[i]+=1
    for i in pcount:
        scount[i]-=pcount[i]
    #print(pcount)
    #print(scount)
    target=precedence[P[0]]
    ans=''
    for i in scount:
        if precedence[i]<target or precedence[i]>target:
            ans+=(i*scount[i])
        elif precedence[i]==target:
            temp1=ans+(i*scount[i])+P
            temp2=ans+P+(i*scount[i])
            if temp1<=temp2:
                ans=temp1
            else:
                ans=temp2
            #ans+=(i*scount[i])+P
    print(ans)
