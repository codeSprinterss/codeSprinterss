S = input()
new = ""
suffixes = []

# 한 글자씩 new에 추가하면서 전체 문자열을 만듦
for ch in S:
    new += ch  # 문자열로 계속 누적

# 시작점을 하나씩 뒤로 미룸
for i in range(len(new)):
    suffixes.append(new[i:])

# 사전순 정렬
suffixes.sort()

# 출력
for s in suffixes:
    print(s)