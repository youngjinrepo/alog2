import sys
input = sys.stdin.readline

N = int(input())
reqs = list(map(int, input().split()))
M = int(input())

start = 0
end = max(reqs)

answer = 0
while start <= end:
    mid = (start + end) // 2

    amount=0
    for req in reqs:
        if req <= mid:
            amount+=req
        else:
            amount+=mid

    if amount <= M :
        answer = mid
        start = mid+1
    else:
        end=mid-1

print(answer)