package com.ezen.spring.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@EnableTransactionManagement
@MapperScan(basePackages = {"com.ezen.spring.dao"})
@Configuration
public class RootConfig {
	
	@Autowired
	ApplicationContext applicationContext;
	
	@Bean
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		
		// com.mysql.jdbc.Driver 대신 log4jdbc 드라이버 사용
		// log4jdbc 드라이버 => DB의 흐름으로 로그로 찍어주는 드라이버.
		// springdb / springUser / mysql
		hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		hikariConfig.setJdbcUrl("jdbc:log4jdbc:mysql://localhost:3306/springdb3");
		hikariConfig.setUsername("springUser");
		hikariConfig.setPassword("mysql");
		
		hikariConfig.setMaximumPoolSize(5);
		hikariConfig.setMinimumIdle(5);
		
		hikariConfig.setConnectionTestQuery("SELECT now()");	// 첫 연결 시 test sql
		hikariConfig.setPoolName("springHikariCP");
		
		// cachePrepStmts : cache 사용여부 설정
		hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", "true");
		
		// mysql 드라이버가 연결 당 cache 사이즈 설정 : 250 ~ 500 사이의 권장
		hikariConfig.addDataSourceProperty("dataSource.prepStmtsCacheSize", "250");
		
		// connection당 캐싱할 prearedStatement 개수 지정 옵션 : default 250
		hikariConfig.addDataSourceProperty("dataSource.prepStmtsCacheSqlLimit", "true");	// true : 기본값 설정
		
		// mysql 서버에서 최신 이슈가 있을 경우 지원을 받을 것인지 설정
		hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");
		
		HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
		return hikariDataSource;	
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlFactoryBean = new SqlSessionFactoryBean();
		
		sqlFactoryBean.setDataSource(dataSource());	// 빼먹으면 세팅데이터 없어서 bean 오류발생
		
		sqlFactoryBean.setMapperLocations(
				applicationContext.getResources("classpath:/mappers/*.xml"));
		
		sqlFactoryBean.setConfigLocation(
				applicationContext.getResource("classpath:/mybatisConfig.xml"));
		
		return sqlFactoryBean.getObject();
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
}
