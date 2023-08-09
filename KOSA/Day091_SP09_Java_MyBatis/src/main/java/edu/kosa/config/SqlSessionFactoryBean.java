package edu.kosa.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

@Log4j2
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SqlSessionFactoryBean {

    private static class SqlSessionFactoryHolder {  // Lazy Holder
        private static final SqlSessionFactory INSTANCE = buildSqlSessionFactory();
    }

    private static SqlSessionFactory buildSqlSessionFactory() {
        try (Reader reader = Resources.getResourceAsReader("mybatis/mybatis-config.xml")) {
            return new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            log.error("SqlSessionFactory 초기화 실패", e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return SqlSessionFactoryHolder.INSTANCE;
    }

    public static SqlSession getSession() {
        log.info("getSession()");
        return getSqlSessionFactory().openSession(true);
    }
}
