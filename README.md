# project
## 자취생의 모든 것
### 개요
  **자취생의 모든 것**은 혼자 살면서 생활 패턴의 관리가 힘든 사람들을 위해 제작한 프로그램입니다. 사용자의 집안일과 식사 내역을 기록하고, 자취방에서 간단하게 먹을 수 있는 요리들의 레시피를 제공합니다.
### 사용법
프로그램을 실행시키면 메뉴 1. 집안일 관리, 2. 식사 관리 3. 간단 요리 가 나타납니다. 숫자를 입력해서 각 메뉴로 들어갈 수 있습니다.  

1. **집안일 관리** :  
 관리할 수 있는 집안일은 청소, 설거지, 빨래로 세 가지입니다. 마지막으로 각각의 집안일을 한 지 며칠이 지났는지가 출력됩니다. 단, 아무 데이터가 저장되지 않은 첫 실행 때에는 출력되지 않습니다. 청소와 설거지의 경우 3일간 하지 않으면, 빨래의 경우 8일간 하지 않으면 잔소리가 출력 됩니다.  
 그 후, 오늘의 집안일 중 어느 집안일을 했는지 질문합니다. 세 선택지 중 하나를 입력하면, 오늘의 날짜 데이터가 각각 data_clean, data_dishwashing, data_laundry 파일에 저장됩니다. 첫 입력 시에는 파일이 새로 생성되며, 다음 입력부터는 기존의 파일에 덮어쓰기 됩니다.  

1. **식사 관리** :  
 아침, 점심, 저녁의 데이터를 관리할 수 있습니다. 오늘 아침, 점심, 저녁 중 무엇을 먹었는지를 출력합니다. 만약 먹긴 먹었는데 인스턴트식품으로 때웠을 때, 잔소리가 출력됩니다. 굶었을 경우에도 건강을 우려하는 잔소리가 출력됩니다. 집안일과 마찬가지로, 아무 데이터가 저장되지 않았을 땐 출력되지 않습니다.
 현재 컴퓨터의 시각을 반영하여, 아침(오전 6시부터 오전 11시), 점심(오후 12시부터 오후 3시), 저녁(오후 5시부터 8시)을 먹을 시간이라고 알려줍니다. 이 메시지는 그 시간대의 식사 데이터가 “아직 먹지 않았음”일 경우에만 출력됩니다. 그 후 아침, 점심, 저녁 중 어느 데이터를 관리할 것인지에 대한 선택지가 나타납니다. 아침의 경우, 먼저 아침을 고른 후 1. 먹었다, 2. 인스턴트로 때웠다, 3. 굶었다, 4. 아직 먹지 않았다, 이렇게 네 선택지 중 하나를 입력하면 data_meal파일에 그 데이터가 저장됩니다. 점심과 저녁의 경우도 마찬가지로 data_meal 파일에 저장됩니다.  
 
1. **간단 요리** :  
 현직 자취생이 엄선한 재료가 비싸지 않고 간편하게 해먹을만한 요리 레시피의 목록이 쭉 출력됩니다. 레시피 이름을 정확하게 입력하면 그 요리법을 적은 블로그 링크가 자동으로 인터넷 브라우저에서 열립니다.  
