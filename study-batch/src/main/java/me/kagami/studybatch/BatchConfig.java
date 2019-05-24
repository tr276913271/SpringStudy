package me.kagami.studybatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;    //用于构建JOB
    @Autowired
    private JobCompletionListener jobCompletionListener;
    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public ItemReader<String> reader() {
        return new Reader();
    }

    @Bean
    public ItemProcessor<String, String> processor() {
        return new Processor();
    }

    @Bean
    public ItemWriter<String> writer(DataSource dataSource) {
        return new Writer();
    }

    @Bean
    public JobRepository jobRepository(DataSource dataSource, PlatformTransactionManager transactionManager)
            throws Exception {
        //jobRepository的定义需要dataSource和transactioManager，Spring Boot已为我们自动配置了这两个类，Spring可通过方法注入已有的Bean。
        JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
        jobRepositoryFactoryBean.setDataSource(dataSource);
        jobRepositoryFactoryBean.setTransactionManager(transactionManager);
        jobRepositoryFactoryBean.setDatabaseType("mysql");
        return jobRepositoryFactoryBean.getObject();
    }

    /**
     * 一个简单基础的Job通常由一个或者多个Step组成
     */
    @Bean
    public Job dataHandleJob() {
        return jobBuilderFactory.get("dataHandleJob").
                incrementer(new RunIdIncrementer()).
                start(orderStep1()).    //start是JOB执行的第一个step
//                next(xxxStep()).
//                next(xxxStep()).
//                ...
        listener(jobCompletionListener).      //设置了一个简单JobListener
                build();
    }

    @Bean
    public Step orderStep1() {
        return stepBuilderFactory.get("orderStep1").<String, String>chunk(2)
                .reader(new Reader()).processor(new Processor())
                .writer(new Writer()).build();
    }
}
