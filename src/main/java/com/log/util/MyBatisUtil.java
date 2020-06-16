package com.log.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyBatisUtil {

    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        String resource = "mybatis-config.xml";
        InputStream is = null;
        // 加载配置文件
        try {
            is = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //获取SqlSession对象（mybatis的连接对象，可以理解为JDBC的connection对象）
    public static SqlSession getSession() {
        return sqlSessionFactory.openSession();
    }

    public static void main(String[] args) {
        SqlSession session = getSession();
        System.out.println(session);
    }
}