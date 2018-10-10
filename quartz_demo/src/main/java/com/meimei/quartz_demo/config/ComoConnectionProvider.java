package com.meimei.quartz_demo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.quartz.SchedulerException;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-10-09
 */
public class ComoConnectionProvider {

    /**
     * Default maximum number of database connections in the pool.
     */
    public static final int DEFAULT_DB_MAX_CONNECTIONS = 10;

    /**
     * Default maximum number of database connections in the pool.
     */
    public static final int DEFAULT_DB_MAX_CACHED_STATEMENTS_PER_CONNECTION = 120;

    private String driver;
    private String url;
    private String user;
    private String password;
    private int maxConnections;
    private int maxCachedStatementsPerConnection;
    private int maxIdleSeconds;
    private String validationQuery;
    private int idleConnectionValidationSeconds;
    private boolean validateOnCheckout;
    private String discardIdleConnectionsSeconds;

    private ComboPooledDataSource datasource;

    /**
     * 无参构造，必须要有[没有其他构造的话也可以不写]
     */
    public ComoConnectionProvider() {

    }

    public Connection getConnection() throws SQLException {
        return datasource.getConnection();
    }

    public void shutdown() throws SQLException {
        datasource.close();

    }

    /**
     * 初始化方法，应该在调用其setter后调用
     */
    public void initialize() throws SQLException {
        if (this.url == null) {
            throw new SQLException("DBPool could not be created: DB URL cannot be null");
        }

        if (this.driver == null) {
            throw new SQLException("DBPool driver could not be created: DB driver class name cannot be null!");
        }

        if (this.maxConnections < 0) {
            throw new SQLException(
                            "DBPool maxConnectins could not be created: Max connections must be greater than zero!");
        }

        datasource = new ComboPooledDataSource();
        try {
            datasource.setDriverClass(this.driver);
        } catch (PropertyVetoException e) {
            try {
                throw new SchedulerException("Problem setting driver class name on datasource: " + e.getMessage(), e);
            } catch (SchedulerException e1) {
            }
        }
        datasource.setJdbcUrl(this.url);
        datasource.setUser(this.user);
        datasource.setPassword(this.password);
        datasource.setMaxPoolSize(this.maxConnections);
        datasource.setMinPoolSize(1);
        datasource.setMaxIdleTime(maxIdleSeconds);
        datasource.setMaxStatementsPerConnection(this.maxCachedStatementsPerConnection);

        if (this.validationQuery != null) {
            datasource.setPreferredTestQuery(this.validationQuery);
            if (!validateOnCheckout) {
                datasource.setTestConnectionOnCheckin(true);
            } else {
                datasource.setTestConnectionOnCheckout(true);
            }
            datasource.setIdleConnectionTestPeriod(this.idleConnectionValidationSeconds);
        }
    }

    /*-------------------------------------------------
     *
     * setters 如果有必要，你可以添加一些getter
     * ------------------------------------------------
     */
    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public void setMaxCachedStatementsPerConnection(int maxCachedStatementsPerConnection) {
        this.maxCachedStatementsPerConnection = maxCachedStatementsPerConnection;
    }

    public void setMaxIdleSeconds(int maxIdleSeconds) {
        this.maxIdleSeconds = maxIdleSeconds;
    }

    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
    }

    public void setIdleConnectionValidationSeconds(int idleConnectionValidationSeconds) {
        this.idleConnectionValidationSeconds = idleConnectionValidationSeconds;
    }

    public void setValidateOnCheckout(boolean validateOnCheckout) {
        this.validateOnCheckout = validateOnCheckout;
    }

    public void setDiscardIdleConnectionsSeconds(String discardIdleConnectionsSeconds) {
        this.discardIdleConnectionsSeconds = discardIdleConnectionsSeconds;
    }

    public void setDatasource(ComboPooledDataSource datasource) {
        this.datasource = datasource;
    }

    protected ComboPooledDataSource getDataSource() {
        return datasource;
    }
}
