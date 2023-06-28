CREATE TABLE MEMO
(
    ID      VARCHAR2(20) PRIMARY KEY,
    EMAIL   VARCHAR2(50) NOT NULL,
    CONTENT VARCHAR2(2000) NOT NULL
);

/*
    Model
    View
    Controller

    - 패키지 구조 정의
        kr.or.kosa.dto
        kr.or.kosa.dao
        kr.or.kosa.controller
        kr.or.kosa.service
        kr.or.kosa.util

    1. DB >> Table 설계 >> memo

    1. DTO, VO, TO
    2. DB(연결)
    3. DAO <-- Controller 사용
    4. 디자인 파일(JSP)... UI (memo.html, memoList.jsp, ...)

    글쓰기 -> MemoController
    목록 보기 -> ListServlet 등
*/

/*
    DBCP & JNDI 구성하기
    <Resource name="jdbc/MemberDB"
              auth="Container"
              type="javax.sql.DataSource"
              username="compiler"
              password="compiler"
              driverClassName="oracle.jdbc.OracleDriver"
              url="jdbc:oracle:thin:@192.168.0.29:9998:XE"

              maxActive ="20"
              maxIdle ="10"
              maxWait ="-1"
              testOnBorrow ="true"
              testOnReturn ="true"
              removeAbandoned ="true"
              removeAbandonedTimeout ="300"
              logAbandoned ="true"
              useEquals ="true"
              useLock ="true"
              defaultTransactionIsolation ="2"
              defaultCatalog =""
              defaultAutoCommit ="true"
              connectionInitSql =""
              timeBetweenEvictionRunsMillis ="30000"
              numTestsPerEvictionRun ="10"
              minEvictableIdleTimeMillis ="60000"
              validationQueryTimeout ="10"
              testWhileIdle ="true"
              timeBetweenConnectRetries ="1000"
              maxRetries ="10"
              accessToUnderlyingConnectionAllowed ="false"
              connectionProperties =""
              connectionFactory =""
              jndiEnvironment =""
    />
*/