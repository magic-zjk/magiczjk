package top.magiczjk.bean;

import java.text.SimpleDateFormat;

import javax.servlet.MultipartConfigElement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class BeanConfig {
	
    /*@Bean
    public CommonsMultipartResolver multipartResolver() {
    	CommonsMultipartResolver resolver = new CommonsMultipartResolver();
    	resolver.setMaxUploadSize(10485760);
    	resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }*/
	
	@Bean  
    public MultipartConfigElement multipartConfigElement(  
            @Value("${multipart.maxFileSize}") String maxFileSize,  
            @Value("${multipart.maxRequestSize}") String maxRequestSize) {  
        MultipartConfigFactory factory = new MultipartConfigFactory();  
        // 单个文件最大  
        factory.setMaxFileSize(maxFileSize);  
        // 设置总上传数据总大小  
        factory.setMaxRequestSize(maxRequestSize);  
        return factory.createMultipartConfig();  
    }  
	
    @Bean
    public ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(Include.NON_NULL); // 不序列化null的属性
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")); // 默认的时间序列化格式
        return mapper;
    }
}