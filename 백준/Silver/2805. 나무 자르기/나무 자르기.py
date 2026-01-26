import sys
input = sys.stdin.readline

# K: 나무의 수, N: 필요한 나무의 길이
K, N = map(int, input().split())
trees = list(map(int, input().split()))

start = 0  # 높이는 0부터 시작 가능 (땅바닥부터 자를 수도 있음)
end = max(trees)
answer = 0

while start <= end:
    mid = (start + end) // 2
    
    length = 0
    for tree in trees:
        if tree > mid:       # [수정1] 나무가 절단기보다 높을 때만 자름!
            length += tree - mid
            
    if length >= N:          # [수정2] 목표량과 같거나 많으면 정답 후보!
        answer = mid
        start = mid + 1      # 더 높이 잘라볼까? (위쪽 탐색)
    else:
        end = mid - 1        # 나무가 부족해.. 높이를 낮추자 (아래쪽 탐색)

print(answer)