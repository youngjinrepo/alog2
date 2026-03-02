T=int(input())
P=int(input())
graph=[[] for _ in range(T+1)]

for i in range(P):
    a, b = map(int, input().split(" "))
    graph[a].append(b)
    graph[b].append(a)

visited=[False] * (T + 1)

def dfs(node) :
    visited[node] = True

    for next_node in graph[node] :
        if (visited[next_node]==False) :
            dfs(next_node)

dfs(1)
cnt = 0
for i in range(2,len(visited)) :
    if ( visited[i]==True ) :
        cnt=cnt+1
print(cnt)