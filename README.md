# 🃏  바카라 게임 by 김주환, 한수아

### [룰 ver.1]
0. A = 1, 10 = J = Q = K  = 0 으로 계산한다. 나머지 카드는 그대로 계산한다.
1. 플레이 할 사용자 수를 입력한다.
2. 사용자의 이름을 입력을 입력한다.
3. 각 사용자에게 카드를 두 장씩 분배한다.
4. 받은 카드들은 모두에게 공개된다.
5. 사용자들은 두 카드 값의 합을 구하고, 그 합의 일의 자리 수에 따라 다음과 같이 행동한다.
    1. 8이나 9인 경우(Natural): 세 번째 카드를 뽑지 않는다.
    2. 7 이하인 경우(Stand): 세 번째 카드를 추가로 뽑는다.
6. 사용자들은 다시 모든 카드 값의 합을 구하고, 그 일의 자리 수가 9에 가장 가까운 사람이 승리한다.

### [룰 ver.2]
0. A = 1, 10 = J = Q = K  = 0 으로 계산한다. 나머지 카드는 그대로 계산한다.
1. 플레이 할 사용자 수를 입력한다.
2. 사용자의 이름을 입력을 입력한다.
3. 각 사용자에게 카드를 두 장씩 분배한다.
4. 두 카드 중 하나만 모두에게 공개된다. 나머지 카드는 사용자 본인 또한 확인할 수 없다.
5. 사용자는 자신의 카드를 확인하고, 추가로 카드를 뽑을지 말지 선택한다.
   1. Yes: 카드를 한 장 더 뽑는다.
   2. No: 카드를 뽑지 않는다.
7. 사용자들은 다시 모든 카드 값의 합을 구하고, 그 일의 자리 수가 9에 가장 가까운 사람이 승리한다.
