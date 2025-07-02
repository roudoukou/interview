package icu.xiamu.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author roudoukou
 * @date 2025/6/21
 */
@PropertySource("classpath:/dbconfig.properties")
@Configuration
public class MyConfigOfProfile implements EmbeddedValueResolverAware {

    @Value("${db.user}")
    private String user;
    private String driverClass;

    @Profile("test")
    @Bean
    public DataSource testDataSource(@Value("${db.p}") String password) throws PropertyVetoException {
        ComboPooledDataSource mysql = new ComboPooledDataSource();
        mysql.setUser(user);
        mysql.setPassword(password);
        mysql.setDriverClass(driverClass);
        mysql.setJdbcUrl("jdbc:mysql://localhost:3306/peiqi");
        return mysql;
    }

    @Profile("dev")
    @Bean
    public DataSource devDataSource(@Value("${db.p}") String password) throws PropertyVetoException {
        ComboPooledDataSource mysql = new ComboPooledDataSource();
        mysql.setUser(user);
        mysql.setPassword(password);
        mysql.setDriverClass(driverClass);
        mysql.setJdbcUrl("jdbc:mysql://localhost:3306/peiqi");
        return mysql;
    }

    @Profile("prod")
    @Bean
    public DataSource prodDataSource(@Value("${db.p}") String password) throws PropertyVetoException {
        ComboPooledDataSource mysql = new ComboPooledDataSource();
        mysql.setUser(user);
        mysql.setPassword(password);
        mysql.setDriverClass(driverClass);
        mysql.setJdbcUrl("jdbc:mysql://localhost:3306/peiqi");
        return mysql;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.driverClass = resolver.resolveStringValue("${db.driverClass}");
    }
}
