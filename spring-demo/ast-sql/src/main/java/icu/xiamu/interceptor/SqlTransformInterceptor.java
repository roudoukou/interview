package icu.xiamu.interceptor;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.util.deparser.StatementDeParser;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.Properties;

/**
 * MyBatis SQL 转换拦截器。
 * 作用：
 * 1. 将 SQL 语句全部转换为大写。
 * 2. 使用 TableQuotingVisitor 为 SQL 语句中的表名添加双引号。
 */
@Component
@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})
})
public class SqlTransformInterceptor implements Interceptor {

    private static final Logger log = LoggerFactory.getLogger(SqlTransformInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        BoundSql boundSql = statementHandler.getBoundSql();
        String originalSql = boundSql.getSql();

        log.debug("Original SQL: {}", originalSql);

        try {
            // 1. 将整个SQL语句转换为大写
            String upperCaseSql = originalSql.toUpperCase();

            // 2. 使用 JSQLParser 解析 SQL
            Statement statement = CCJSqlParserUtil.parse(upperCaseSql);

            // 3. 创建并使用 TableQuotingVisitor 来遍历并修改表名
            TableQuotingVisitor visitor = new TableQuotingVisitor();
            statement.accept(visitor); // 调用 Visitor 对 AST 进行访问和修改

            // 4. 重建 SQL 语句
            StringBuilder newSqlBuilder = new StringBuilder();
            statement.accept(new StatementDeParser(newSqlBuilder));
            String transformedSql = newSqlBuilder.toString();

            // 5. 通过反射修改 BoundSql 中的 SQL 语句
            java.lang.reflect.Field sqlField = BoundSql.class.getDeclaredField("sql");
            sqlField.setAccessible(true);
            sqlField.set(boundSql, transformedSql);

            log.debug("Transformed SQL: {}", transformedSql);

        } catch (JSQLParserException e) {
            log.warn("SQL 解析失败，无法转换。将使用原始 SQL。错误: {}", originalSql, e.getMessage());
        } catch (Exception e) {
            log.error("SQL 转换过程中发生意外错误。原始 SQL: {}。错误: {}", originalSql, e.getMessage(), e);
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler) {
            return Plugin.wrap(target, this);
        }
        return target;
    }

    @Override
    public void setProperties(Properties properties) {
        // 暂时无需设置属性
    }
}