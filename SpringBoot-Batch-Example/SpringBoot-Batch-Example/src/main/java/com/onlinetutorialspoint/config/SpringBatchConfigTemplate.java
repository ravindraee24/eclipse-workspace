package com.onlinetutorialspoint.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.onlinetutorialspoint.listener.JobListener;
import com.onlinetutorialspoint.model.Template;
import com.onlinetutorialspoint.model.TemplateDTO;
import com.onlinetutorialspoint.processor.EmployeeProcessor;
import com.onlinetutorialspoint.processor.TemplateProcessor;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfigTemplate {
	@Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public DataSource dataSource;

    @Bean
    public FlatFileItemReader<Template> reader() {
        FlatFileItemReader<Template> reader = new FlatFileItemReader<Template>();
        reader.setResource(new ClassPathResource("template.csv"));

        reader.setLineMapper(new DefaultLineMapper<Template>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[] { "template_id", "template_label","dlt_ct_id","template_text","template_type","user_code","status","sender_code","approver_code","camp_type" });
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper() {{
                setTargetType(Template.class);
            }});
        }});
        return reader;
    }


    @Bean
    public TemplateProcessor processor() {
        return new TemplateProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<TemplateDTO> writer() {
        JdbcBatchItemWriter<TemplateDTO> writer = new JdbcBatchItemWriter<TemplateDTO>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        writer.setSql("insert  into `progate_message_template`(`template_id`,`template_label`,`dlt_ct_id`,`template_text`,`template_type`,`user_code`,`status`,`sender_code`,`approver_code`,`camp_type`) " +
                "VALUES (:template_id, :template_label, :dlt_ct_id, :template_text, :template_type, :user_code, :status, :sender_code, :approver_code, :camp_type)");
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    public Job importUserJob(JobListener listener) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Template, TemplateDTO> chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

}
