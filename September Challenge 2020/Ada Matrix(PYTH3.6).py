# cook your dish here
def check(arr1,arr2,N):
    for i in range(N):
        for j in range(N):
            if arr1[i][j]!=arr2[i][j]:
                return False
    return True
def transpose(arr,n):
    for i in range(n):
        for j in range(i,n):
            arr[i][j],arr[j][i]=arr[j][i],arr[i][j]

for _ in range(int(input())):
    N=int(input())
    ori_mat=[]
    cnt=1
    for i in range(N):
        ori_mat.append([])
        for j in range(N):
            ori_mat[i].append(cnt)
            cnt+=1
    curr_matrix=[]
    for i in range(N):
        temp=[int(j) for j in input().split()][:N]
        curr_matrix.append(temp)
    ans=0
    for x in range(N,1,-1):
        if curr_matrix[0][x-1]!=x:
            ans+=1
            transpose(curr_matrix,x)
    print(ans)
