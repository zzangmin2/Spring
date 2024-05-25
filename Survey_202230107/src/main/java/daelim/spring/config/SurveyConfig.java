package daelim.spring.config;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import daelim.spring.survey.SurveyDao;
import daelim.spring.survey.SurveyRegisterService;

@Configuration
public class SurveyConfig {

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://daelim-spring.cn2caoi4y4hm.ap-northeast-2.rds.amazonaws.com/survey?characterEncoding=utf8");
        ds.setUsername("admin");
        ds.setPassword("daelimspring");
        ds.setInitialSize(2);
        ds.setMaxActive(10);
        ds.setMaxIdle(10);
        ds.setTestWhileIdle(true); // 유휴 커넥션 검사
        ds.setTimeBetweenEvictionRunsMillis(1000 * 10); // 10초 주기로 유휴 커넥션이 유효한지 검사
        ds.setMinEvictableIdleTimeMillis(1000 * 60 * 3); // 최소 유휴시간 3분
        return ds;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource());
        return dataSourceTransactionManager;
    }

    @Bean
    public SurveyDao surveyDao(){
        return new SurveyDao(dataSource());
    }

    @Bean
    public SurveyRegisterService surveyRegisterService(){
        return new SurveyRegisterService();
    }

}
