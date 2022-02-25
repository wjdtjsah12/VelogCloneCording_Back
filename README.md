1. 시연영상
 https://youtu.be/iGZRDvPsT9s
 ![image](https://user-images.githubusercontent.com/97423687/155509143-bfb26776-547a-4d6c-914f-9ec11f706d7c.png)
 
2. 제작기간 & 팀원소개 🏃‍🏃‍♀️ 💨

Front-end (React)

● 정현수 👨

● 이혜진 👧

Back-end (Spring)

● 정선모 🧑

● 이용만 🧑

● 박정희 🧑

3.사용 기술 🔧 ⚙️

● Language : Java 8

● Tool : Intellij

● Infrastructure : AWS RDS - MySQL, Aws EC2

● 기타 : Gradle, Spring Security, JDK 1.8

● Other Tools : Git, Github, notion

4. 구현 기능 📃

● 로그인(JWT Token 인증) & 회원가입 🔓

● 게시글 CR(UD)

● 댓글 CR(UD)

● 태그

● 좋아요 순위 게시글 정렬

● 최신글 


5. 테이블 설계
- 테이블설계

    - User : **id**, email, userId, username, password, introduce, profileNum
    
    - Board : **id**, [user_id], title, content, contentSummary, createdAt, likesList, registerdUid thumbnailImageUrl
    
    - Comment : **id**, [board_id], [user_id], createdAt, content
    
    - Likes : **id**, [board_id], [user_id]
    
    - Tags : **id**, [board_id], tagName
    
    - 연관관계 정리
        - User(1):Board(N)
        - Board(1):Comment(N)
        - User(1):Comment(N)
        - Likes(1):User(1)
        - Likes(1):Board(1)
        - Tags(N):Board(1)
![Untitled](https://user-images.githubusercontent.com/97423687/155509197-77a73dfd-c314-47bc-a51e-19993cabe7fc.png)

6. 와이어프레임

 ![프레임워크](https://user-images.githubusercontent.com/97423687/155509313-51dceff4-56d4-483e-9bfd-715b30306e1c.png)

 
7.개인 회고

🧑 이용만

● 내가 팀을 위해 가장 노력했던 점 :
JWT에 대한 부족한 지식으로 인해 로그인과 회원가입 구현이 되지 않을 것 같아 강의를 다시 듣고 로그인/회원가입 구현한 분들을 찾아가 물어보고 했고
구현하고 난 후 선모님과 정희님이 구현해내야 할 기능들이 많아 스스로 태그 기능을 구현하기로 자원했습니다. 하지만 데이터 연관관계에 대한 이해가 한참 모자랐고
걱정을 했으나 팀원분들이 도와주셔서 너무 감사했습니다. 

● 내가 우리 팀원들에게 가장 감사했던 점 :
다들 어려운 상황 가운데에서도 서로 토닥토닥 하며 끝까지 포기하지 않아서 정말 감사했습니다. 부족한 저를 이끌어주셔서 감사합니다.

● 나에게 아쉬운 점, 극복해야할 점 :
항해 체크인/체크아웃 시간은 9~21시이지만 정작 여기서 내가 집중하는 시간은 얼마나 될까?
어떤 강의를 들었고 무엇이 부족해 강의를 들었는지? 
어떤 에러를 만났고 어떻게 해결했고 내가 어렵다고 느낀 것은 무엇인지?
하루에 어떤 것을 코딩했는지?
velog에 꾸준히 하루 30분 투자를 해서 정리를 해야겠다.
부족한 부분은 무엇보다 JPA 연관관계와 어떻게 코딩을 써나가야할지..

🧑 정선모 

● 내가 팀을 위해 가장 노력했던 점 :
CRUD와 연관관계에 대해서 이해도가 부족했었습니다. 다른 조원의 코드리뷰와 부족한 부분 구글링을 통해 문제해결 가능했습니다. 

● 내가 우리 팀원들에게 가장 감사했던 점 :
같은 조원분들이 별다른 충돌이나 논쟁 없이 API 생성에 집중할 수 있어서 좋았다고 생각합니다. 다들 너무 고생 많으셨고 감사합니다.

● 나에게 아쉬운 점, 극복해야할 점 :
문제 해결을 진행하면서 MYSQL 서버 문제해결을 위해 SQL도 어느정도 공부가 필요하다는 생각이 들었습니다. 연관관계와 SQL, Security에 대해서 좀더 공부해보려고 합니다.

🧑 박정희

● 내가 팀을 위해 가장 노력했던 점:
CRUD의 이해도가 낮아서 수정 부분을 구현을 못하고 있었습니다. 그래서 선모님과 용만님의 도움을 받아서 문제의 해결이 가능했습니다.

● 내가 우리 팀원들에게 가장 감사했던 점 :
java의 이해도가 낮아 힘들어하고 있을떄 혼자서 힘들어 하고 있을떄, 팀원분들이 같이 해보자고 하시면서 문제해결을 같이 했던 점이 감사했습니다.

● 나에게 아쉬운 점, 극복해야할 점 :
spring에 대한 이해도부터 너무 낮아서 혼자서 시간을 단 30분이라도 내서 공부를 다시해야된다고 느꼈습니다.
