N=int(input())
for _ in range(N) :
    s=input()

    stack = []
    for ch in s :
        if not stack :
            stack.append(ch)
        elif ch == ")" and stack[-1] == "(" :
            stack.pop()
            continue
        else :
            stack.append(ch)
    
    if not stack:
        print("YES")
    else :
        print("NO")
