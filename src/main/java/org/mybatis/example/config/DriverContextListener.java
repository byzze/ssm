
package org.mybatis.example.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.example.controller.TsetController;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
/*项目启动或关闭的时候会自动启用*/
@WebListener
public class DriverContextListener implements ServletContextListener {
    //使用其他日志，不适用log4j2，因为使用log4j2时，这里是注销情况，但是我们使用log4j的时候
    //会重新使用数据源，将日志插入数据库。所以有冲突，故这里用其他日志代替
    private static final Log LOG = LogFactory.getLog(DriverContextListener.class);

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        LOG.info("Deregistering SQL-Drivers ...");
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                LOG.info("Deregistered:"+driver.getClass().getName());
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                LOG.error("Error deregistering driver " +
                        driver.getClass().getName());
            }
         }

    }

     @Override
     public void contextInitialized(ServletContextEvent arg0) {
     }
}
