N = int(input())
sentence = [] # 문장을 저장할 리스트

for _ in range(N):
    sentence.append(input())  # 입력받은 '문장'을 리스트에 추가

for i in range(N):
    print(f"{i+1}. {sentence[i]}")  # 출력 형식: '번호. 문장' 형태