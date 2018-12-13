# project
## 자취생의 모든 것
### 개요
  **자취생의 모든 것**은 혼자 살면서 생활 패턴의 관리가 힘든 사람들을 위해 제작한 프로그램입니다. 사용자의 집안일과 식사 내역을 기록하고, 자취방에서 간단하게 먹을 수 있는 요리들의 레시피를 제공합니다.
### 사용법
 소스 코드를 다운받고 이클립스에서 패키지명을 project2로 생성하여 소스 코드를 해당 패키지에 넣어주시면 됩니다. 프로그램을 실행시키면 메뉴 1. 집안일 관리, 2. 식사 관리 3. 간단 요리 가 나타납니다. 숫자를 입력해서 각 메뉴로 들어갈 수 있습니다.  

1. **집안일 관리** :  
 관리할 수 있는 집안일은 청소, 설거지, 빨래로 세 가지입니다. 마지막으로 각각의 집안일을 한 지 며칠이 지났는지가 출력됩니다. 단, 아무 데이터가 저장되지 않은 첫 실행 때에는 출력되지 않습니다. 청소와 설거지의 경우 3일간 하지 않으면, 빨래의 경우 8일간 하지 않으면 잔소리가 출력 됩니다.  
 그 후, 오늘의 집안일 중 어느 집안일을 했는지 질문합니다. 세 선택지 중 하나를 입력하면, 오늘의 날짜 데이터가 각각 data_clean, data_dishwashing, data_laundry 파일에 저장됩니다. 첫 입력 시에는 파일이 새로 생성되며, 다음 입력부터는 기존의 파일에 덮어쓰기 됩니다.  

1. **식사 관리** :  
 아침, 점심, 저녁의 데이터를 관리할 수 있습니다. 오늘 아침, 점심, 저녁 중 무엇을 먹었는지를 출력합니다. 만약 먹긴 먹었는데 인스턴트식품으로 때웠을 때, 잔소리가 출력됩니다. 굶었을 경우에도 건강을 우려하는 잔소리가 출력됩니다. 집안일과 마찬가지로, 아무 데이터가 저장되지 않았을 땐 출력되지 않습니다.
 현재 컴퓨터의 시각을 반영하여, 아침(오전 6시부터 오전 11시), 점심(오후 12시부터 오후 3시), 저녁(오후 5시부터 8시)을 먹을 시간이라고 알려줍니다. 이 메시지는 그 시간대의 식사 데이터가 “아직 먹지 않았음”일 경우에만 출력됩니다. 그 후 아침, 점심, 저녁 중 어느 데이터를 관리할 것인지에 대한 선택지가 나타납니다. 아침의 경우, 먼저 아침을 고른 후 1. 먹었다, 2. 인스턴트로 때웠다, 3. 굶었다, 4. 아직 먹지 않았다, 이렇게 네 선택지 중 하나를 입력하면 data_meal파일에 그 데이터가 저장됩니다. 점심과 저녁의 경우도 마찬가지로 data_meal 파일에 저장됩니다.  
 
1. **간단 요리** :  
 현직 자취생이 엄선한 재료가 비싸지 않고 간편하게 해먹을만한 요리 레시피의 목록이 쭉 출력됩니다. 레시피 이름을 정확하게 입력하면 그 요리법을 적은 블로그 링크가 자동으로 인터넷 브라우저에서 열립니다.  

### 클래스 설명  
 자취생의 모든 것 프로그램에는 Data.java, LivingAlone.java, Housework.java, Meal.java, SimpleCooking.java, Main.java, 이렇게 6개의 클래스가 존재합니다.   
#### **Data.java**
 이 클래스는 데이터를 저장하고 불러오는 기능을 담당합니다. 선언되는 변수들은 다음과 같습니다.  
 
 ```
	String [] name = {"data_clean", "data_dishwashing", "data_laundry"};
	String [] kor_name = {"청소", "설거지", "빨래"};
	String [] meal_name = {"아침", "점심", "저녁"};
	byte [] meal_component = new byte[3];
	String [] component = new String[3];
 ```  
  component[]에는 집안일들을 마지막으로 한지 며칠이 지났는지를 청소, 설거지, 빨래 순으로 저장됩니다. 예를 들어, 만약 청소를 한지 2일, 설거지를 한지 3일이 지나고 빨래를 오늘 했다면 component 배열에 {2, 3, 0}이 String 형태로 저장됩니다. 
  meal_component[]는 아침, 점심, 저녁 순으로 식사를 했는지의 여부가 저장됩니다. 아직 먹지 않은 경우 0, 제대로 된 식사의 경우 1, 인스턴트의 경우 2, 굶었을 경우 3이 저장됩니다. 즉, 아침을 굶고 점심을 제대로 먹고 저녁을 아직 안 먹었다면 {3, 1, 0}이 저장됩니다.
  
 void reportDate(int i)와 void compareDate(int i)는 집안일 데이터 관리에 쓰이는 메소드입니다. 네이버 블로그에 올라온 [강좌](https://blog.naver.com/PostView.nhn?blogId=highkrs&logNo=220476927234&isFromSearchAddView=true)를 참고, 응용했습니다. reportDate(int i)는 현재의 날짜를 LocalData 객체를 ObjectInputStream을 이용하여 직렬화해서 name[i] 이름을 가진 파일에 저장합니다. 예를 들어 인자 i가 0이면 name[0] = "data_clean"이므로, 현재 날짜가 data_clean 파일에 저장됩니다. 이후 저장된 데이터가 어느 종류의 데이터인지를 출력합니다. void compareDate(int i)는 저장된 파일 name[i]를 ObjectOutputStream을 이용해 읽어온 후 LocalDate로 형변환합니다. 이후 현재 시간과 파일에 저장된 시간의 차이를 LocalDate.until()을 이용하여 Period 타입의 변수에 저장한 후, int로 변환하여 component[i]에 일수의 차이를 저장합니다. component[i]는 Housework 클래스에서 사용됩니다.  
 void reportMealData(int meal_number, byte j)와 boolean isn_it_today(), void readMealData()는 식사 데이터 관리에 쓰이는 메소드입니다. reportMealData(int meal_number, byte j)는 meal_component[meal_number]에 j값을 저장한 후, data_meal 파일에 meal_component를 저장합니다. 그 후 저장이 성공적으로 이루어졌다는 메시지를 출력합니다. isn_it_today()는 data_meal 파일이 마지막으로 수정된 시간이 오늘인지, 오늘 이전인지를 반환하는 메소드입니다. java.io.File.lastModified()를 이용해 Date 형태로 마지막으로 수정된 날짜를 불러옵니다. Date형태의 날짜를 LocalDate로 형변환하여 until과 getDays를 이용해 현재 날짜와의 차이를 구한 후, 그 차이가 0이 아니면 true를 반환, 0이면 false를 반환합니다. readMealDate()는 data_meal 파일에 저장된 byte 배열을 그대로 meal_component에 저장하는 메소드입니다. isnt_it_today 메소드를 사용하여, 만약 마지막 수정날짜가 오늘이 아니라면 굳이 불러올 필요가 없으므로 meal_component의 모든 원소를 0으로 초기화합니다. 오늘이라면 data_meal에 저장된 내용을 meal_component에 저장합니다.  
 
#### **LivingAlone.java**
 LivingAlone.java는 Housework.java와 Meal.java를 상속하는 추상 클래스입니다. 이 클래스 내에선 Data 객체 data가 선언되고, 메뉴를 출력하는 void choicemenu(), 잔소리를 출력하는 void jansori(), 오늘 한 일의 내용을 출력하는 void today_did()가 추상 메솓로 선언됩니다. 또한 유저의 선택지를 입력받을 때 try, catch를 사용하여 예외처리를 하는 것을 매번 넣는 것은 번거로우므로 그 기능을 구현한 int yourChoice(int i) 가 구현되어 있습니다. 여기서 i는 선택지의 개수를 의미합니다. 이 메소드는 유저가 입력한 숫자를 반환하는데, 숫자가 아닌 것을 입력하거나 범위 밖의 숫자를 입력했을 때 제대로 입력을 받을 때까지 유저에게 입력을 받습니다.  
 
#### **Housework.java**
 Housework.java는 집안일 관리의 클래스로, LivingAlone을 상속받습니다. void choicemenu()에서는 메소드 today_did()와 jansori()가 시행되고, 이후 어느 집안일을 했는 지에 대한 선택지가 나옵니다. 유저가 입력한 숫자는 int c에 저장되고, c가 1, 2, 3 중 하나일 땐 data.reportData(c)를 통해 데이터를 저장합니다. 4를 입력받으면 메인화면으로 돌아갑니다. 
 void today_did()는 data.compareDate(i)를 실행시켜서 data.component[i]에 그 일수를 저장하고, 만약 component[i]가 0일 때 해당하는 집안일을 오늘 한 집안일이라고 출력합니다. 집안일을 하나라도 했을 때 칭찬을 출력하는데, 집안일을 많이 할수록 칭찬의 강도가 높아집니다.  
 void jansori()는 data.component에 저장된 일수가 1일 이상일 때, 각각의 집안일을 마지막으로 한 지 며칠이 지났는지를 출력합니다. 청소와 설거지의 경우 3일, 빨래의 경우 8일 이상일 때 잔소리를 출력합니다.  
 
 #### **Meal.java**
  Meal.java는 식사를 관리하는 클래스로, LivingAlone을 상속받습니다. void choicemenu()의 기능은 Housework에서의 것과 같은데, 추가로 show_time()이 시행됩니다.
  void nextMenu(int i)는 입력받은 인자 i에 따라 관리할 데이터가 달라집니다. i=1:아침, i=2:점심, i=3:저녁입니다. 이후 1.제대로 먹었다, 2.인스턴트로 먹었다, 3.굶었다, 4.아직 안 먹었다 의 선택지를 주고 숫자를 int a에 입력받습니다. 이후 data.reportData(i, (byte)a)로 데이터를 저장합니다.  
  void today_did()는 data.readMealData()로 data.meal_component에 식사 데이터를 읽어오고 오늘 먹은 끼니들이 무엇인지 출력합니다.  
  void jansori()는 오늘 언제 인스턴트로 때운 것인지, 오늘 굶은 끼니가 무엇인지를 출력합니다. 인스턴트를 2회 이상 먹었을 때, 또 1회 이상 굶었을 때 잔소리를 출력합니다.
  int Meal_Time()은 현재 시각을 LocalDate 타입의 now에 저장한 후, 6시부터 11시 사이인지, 12시부터 13시 사이인지, 17시부터 20시 사이인지를 판단한 후 각각 1, 2, 3을 리턴합니다. 만약 셋 중 어디에도 속하지 않을 때는 0을 리턴합니다.
  void show_time()은 int t = Meal_Time()을 시행시킨 후 1이면 아침, 2면 점심, 3이면 저녁을 먹을 시간이라는 메시지를 출력합니다.
  
#### **SimpleCooking**
 SimpleCooking.java는 간단 요리 레시피 목록을 출력하고, 레시피 이름을 입력받으면 브라우저가 실행되어 레시피가 적힌 링크로 이동합니다. 레시피 이름과 링크를 쉽게 저장하기 위해 HashMap 컬렉션을 사용했습니다. 또, 링크 이동을 구현하기 위해 Desktop 객체를 선언했습니다.
 void choicemenu()는 레시피 목록을 출력할지, 메인 화면으로 돌아갈지의 선택지를 제공합니다.
 void BasicList()는 제작자가 엄선한 리스트를 basic_list에 put하고 전부 출력합니다. 이후 요리의 이름을 입력받는데, 리스트에 없는 이름을 입력하면 다시 입력하도록 합니다. 리스트에 존재한다면, Desktop.browse(new URI(link))를 통해 링크로 이동합니다.
 
#### **Main.java**
 프로그램을 실행시키는 main 메소드가 포함된 클래스입니다. 이곳에서 Housework, Meal, SimpleCooking 객체가 선언됩니다. main 메소드에선 main 객체가 생성되고, main.run()이 실행됩니다. void run()은 프로그램을 실행시킬 때마다 뜨는 안내 메시지를 띄우고, showMenu()와 choiceMenu()를 반복 실행시킵니다. showMenu()는 메뉴를 보여주는 기능을 수행합니다. choiceMenu()는 사용자의 선택지에 따라 housework.choiceMenu(), meal.choiceMenu(), simplecooking.choiceMenu()를 실행시키고, 4번을 입력했을 때 프로그램을 종료합니다. 
 
### 시연 영상
 [링크](https://drive.google.com/drive/u/1/folders/1g_L-A_JwSi0C3BAAPr758ta10LqFkr12)
 
### 참고 자료
 황기태, 명품 자바 에센셜  
 자바 파일 입출력(ObjectInputStream, ObjectOutputStream) :
https://blog.naver.com/PostView.nhn?blogId=highkrs&logNo=220476927234&isFromSearchAddView=true  
 java.time 패키지 : https://blog.naver.com/nbb_pinetree/221286367266  
 java URI : https://blog.naver.com/drawcoding/221196444798
 컴맹도 이해하는 깃허브 사용법 2- 저장소를 만들고 연동하기 : https://blog.naver.com/euleekwon/221320773399
