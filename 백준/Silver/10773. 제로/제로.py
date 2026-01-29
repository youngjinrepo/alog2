N = int(input())

stack = []
for _ in range(N):
    e=int(input())
    if e == 0 :
        stack.pop()
    else :
        stack.append(e)

print(sum(stack))