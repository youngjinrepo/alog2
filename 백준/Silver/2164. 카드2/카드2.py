from collections import deque
N = int(input())
q=deque()
for e in range(1, N+1):
    q.append(e)
flag = True
while len(q)>1 :
    e=q.popleft()
    if flag == False :
        q.append(e)
    flag = not flag
print(q.pop())