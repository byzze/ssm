package org.mybatis.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/*用于给log4j2将日志写入数据库的数据源 方法二*/
public class DBConnectionFactory {
    private DruidDataSource dataSource;

    private  static DBConnectionFactory DBConnectionFactory;

    private Connection getConnection() throws SQLException {


        try {
            Properties pro = new Properties();
            //读取数据库属性
            FileInputStream fis = new FileInputStream(this.getClass().getResource("/config/mysqldb.properties").getPath());
            pro.load(fis);

            String user = pro.getProperty("jdbc.username");
            String password = pro.getProperty("jdbc.password");
            String url = pro.getProperty("jdbc.url");
            String driverClassName = pro.getProperty("jdbc.driver");

            //druid连接池key名字是固定的。更改会报错
            Properties properties = new Properties();
            properties.put("driverClassName",driverClassName);
            properties.put("url",url);
            properties.put("username",user);
            properties.put("password",password);

            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            try {
                close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            e.printStackTrace();
        }
        return  dataSource.getConnection();
    }

    public static Connection getDatabaseConnection() throws SQLException {
        if(DBConnectionFactory == null){
            DBConnectionFactory = new DBConnectionFactory();
        }
        return DBConnectionFactory.getConnection();

    }

    public void close(){
        try {
            if (dataSource != null){
                dataSource.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}