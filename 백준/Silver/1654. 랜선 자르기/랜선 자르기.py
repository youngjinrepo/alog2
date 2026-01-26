import sys
input = sys.stdin.readline

K, N = map(int, input().split())
lan_cables = [int(input()) for _ in range(K)]

start=1
end=max(lan_cables)

result = 0

while start <= end :
    mid=(start + end) // 2 

    count = 0
    for cable in lan_cables:
        count += cable // mid

    if count >= N:
        start = mid+1
    else:
        end = mid-1
    
print(end)