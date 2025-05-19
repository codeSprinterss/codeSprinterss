conversion = {
    "A+": 4.5, "A0": 4.0,
    "B+": 3.5, "B0": 3.0,
    "C+": 2.5, "C0": 2.0,
    "D+": 1.5, "D0": 1.0,
    "F": 0.0
}

total_score = 0.0 # 학점 × 평점 합
total_credit = 0.0 # 총 학점

for _ in range(20):
    subject, credit, grade = input().split()
    credit = float(credit)

    if grade == "P":
        continue # 패스는 계산 제외

    total_score += credit * conversion[grade]
    total_credit += credit

if total_credit == 0:
    print("0.000000")
else:
    print(f"{total_score / total_credit:.6f}")