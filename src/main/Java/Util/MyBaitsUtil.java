package Util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyBaitsUtil {

    /**
     * 获取SqlSessionFactory
     * **/
    public static SqlSessionFactory getSqlSessionFactory(){
        String resource="mybatis/mybatis-config.xml";
        InputStream is= MyBaitsUtil.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        return factory;
    }

    /*
    * 获取SqlSession
    * */
    public static SqlSession getSqlSession(){
        return getSqlSessionFactory().openSession();
    }

    /*
    *获取SqlSession
    * @param isAutoCommit
    * true 表示创建的SqlSession对象在创建完SQL之后会自动提交事务
    * false表示创建的SqlSession对象在执行完SQL之后不会自动提交
    * **/
    public static SqlSession getSqlSession(boolean isAutoCommit){
        return getSqlSessionFactory().openSession(isAutoCommit);
    }

}
