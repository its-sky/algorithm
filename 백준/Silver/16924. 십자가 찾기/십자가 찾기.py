import sys
import copy
 
a,b =map(int , sys.stdin.readline().split())
inputList = []
for i in range(a):
    inputList.append(list(sys.stdin.readline().strip()))
 
finalList =copy.deepcopy(inputList)
count =0
result =[]
for i in range(1, a):
    for j in range(1,b):
        size = 0
        if (inputList[i][j]=='*'):
            up=down =i
            left=right=j
 
            while(1):
                up= up-1
                down =down+1
                left = left-1
                right = right+1
 
                if(up>=0 and down<a and left>=0 and right<b and inputList[up][j] =='*' and inputList[down][j] =='*'and inputList[i][left] =='*' and inputList[i][right] =='*' ):
                    finalList[up][j] =finalList[down][j] =finalList[i][left] =finalList[i][right]=finalList[i][j] ='.'
                    size = size + 1
                else:
                    if(size>0):
                        result.append("{0} {1} {2}".format(i+1 ,j+1,size))
                    break
        if(size !=0):
            count =count+1
check = True 
for i in finalList:
    if '*'in i:
        print(-1)
        check=False
        break
if(check):
    print(count)
    for i in result:
        print(str(i))