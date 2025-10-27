package com.java.SpringBatchProcessing.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.JobStepBuilder;
import org.springframework.batch.core.step.builder.SimpleStepBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.java.SpringBatchProcessing.dao.ICourse;
import com.java.SpringBatchProcessing.model.Courses;

import jakarta.transaction.TransactionManager;

@Configuration
@EnableBatchProcessing
public class BatchConfig
{
	@Autowired
	private ICourse repo;

	@Autowired
	private JobRepository jobRepo;
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	//Item Reader
	@Bean
	public FlatFileItemReader<Courses> itemReader() {
	    FlatFileItemReader<Courses> reader = new FlatFileItemReader<>();
	    reader.setResource(new ClassPathResource("Course.csv"));
	    reader.setLinesToSkip(1); // Skip header
	    reader.setLineMapper(new DefaultLineMapper<>() {{
	        setLineTokenizer(new DelimitedLineTokenizer() {{
	            setNames("courseId", "courseName", "instructor", "duration", "fee");
	        }});
	        setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
	            setTargetType(Courses.class);
	        }});
	    }});
	    return reader;
	}
	
	/*
	 * @Bean public FlatFileItemReader<Courses> itemReader() {
	 * FlatFileItemReader<Courses> ffir = new FlatFileItemReader<>();
	 * ffir.setResource(new FileSystemResource("src/main/resources/Course.csv"));
	 * ffir.setLinesToSkip(1); ffir.setLineMapper(lineMapper());
	 * 
	 * return ffir;
	 * 
	 * }
	 */
	private LineMapper<Courses> lineMapper() 
	{
		 DefaultLineMapper<Courses> linemapper= new DefaultLineMapper<>();
		 DelimitedLineTokenizer token = new DelimitedLineTokenizer();
		 token.setDelimiter(",");
		 token.setStrict(false);
		 token.setNames("courseName","instructor","duration","fee");
		 BeanWrapperFieldSetMapper<Courses> beanmap = new BeanWrapperFieldSetMapper<>(); 
		 beanmap.setTargetType(Courses.class);
		 linemapper.setLineTokenizer(token);
		 linemapper.setFieldSetMapper(beanmap);
		 
		return linemapper;
	}
	//ItemProcessor
	
	@Bean
	public CoursesProcessor processCxdata()
	{
		
		return new CoursesProcessor();
		
	}
	
	//Item Writer
	@Bean
	public RepositoryItemWriter<Courses> itemWriter()
	{
		RepositoryItemWriter<Courses> writer = new RepositoryItemWriter<>();
		writer.setRepository(repo);
		writer.setMethodName("save");
		return writer;
	}
	
	//Step
	@Bean
	public Step step()
	{
		return new StepBuilder("step-1",jobRepo)
				.<Courses, Courses>chunk(100, transactionManager)
				.reader(itemReader())
				.processor(processCxdata())
				.writer(itemWriter()).build();
				}
	//Jobs
	@Bean
	public Job job()
	{
		
		return (Job)new JobBuilder("courses-import",jobRepo)
				.start(step()).
				build();
	}
	
}
