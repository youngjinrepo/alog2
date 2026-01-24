H, M = map(int, input().split())
T = int(input())

h = T//60
m = T%60

Mm = M+m
Hh = h+H
if Mm>=60 :
    tM=Mm%60
    Hh+=Mm//60
else:
    tM=Mm

if Hh >= 24 :
    tH = Hh%24
else :
    tH = Hh

print(tH , tM)