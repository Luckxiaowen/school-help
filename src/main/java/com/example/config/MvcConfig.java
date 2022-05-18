//package com.example.config;
//
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//import java.text.SimpleDateFormat;
//import java.util.List;
//
//@Configuration
//public class MvcConfig extends WebMvcConfigurationSupport {
//
//	@Override
//	protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//		MappingJackson2HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter();
//		ObjectMapper objectMapper = jacksonConverter.getObjectMapper();
//		// 忽略未知属性
//		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//		// 设置时间格式(时间格式可以通过配置文件获取,增加灵活度)
//		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
//		jacksonConverter.setObjectMapper(objectMapper);
//		converters.add(jacksonConverter);
//	}
//}
