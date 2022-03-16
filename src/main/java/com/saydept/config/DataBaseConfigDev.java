package com.saydept.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Profile("dev")
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.saydept.api.*")
public class DataBaseConfigDev {
	
	@Autowired
	private ApplicationContext applicationContext;

	@Bean
	public DataSource dataSource() {
		
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setDriverClassName("com.ibm.as400.access.AS400JDBCDriver");
		dataSource.setUrl("jdbc:as400://아이피");
		
		dataSource.setUsername("아이디");
		dataSource.setPassword("비밀번호");
		dataSource.setValidationQuery("SELECT 1 FROM 더미");
		dataSource.setMaxActive(5); 							//동시에 사용 할 수 있는 최대 연결 갯수
		dataSource.setMaxIdle(5); 								//풀에서 사용되지 않은 상태로 존재할 수 있는 최대 연결
		dataSource.setMinIdle(5); 								//풀에서 사용되지 않은 상태로 존재할 수 있는 최소 연결
		dataSource.setMaxWait(180000);							//풀에 연결 가능 커넥션이 없을경우 반납되는 커넥션을 대기하는 시간(3분)
		dataSource.setTestWhileIdle(true);						//풀 안에 유휴 상태의 커넥션 대상으로 테스트 이값이 true 여야 setTimeBetweenEvictionRunsMillis 설정이 동작한다
		dataSource.setTimeBetweenEvictionRunsMillis(7200000);	//유효한 커넥션인지 확인하기 위해 동작하는 Evictor 스레드 동작 주기
		
		return dataSource;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource());
		transactionManager.setGlobalRollbackOnParticipationFailure(false);
		
		return transactionManager; 
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis/mybatis-config.xml"));
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mybatis/mapper/**/*.xml"));
		
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
