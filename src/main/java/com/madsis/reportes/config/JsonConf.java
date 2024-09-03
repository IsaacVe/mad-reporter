package com.madsis.reportes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.madsis.reportes.Deserializar.OrdenDeserializer;
import com.madsis.reportes.bean.BeanReporte;

@Configuration
public class JsonConf {

	@Bean
    public MappingJackson2HttpMessageConverter customJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module.addDeserializer(BeanReporte.class, new OrdenDeserializer());
        objectMapper.registerModule(module);

        jsonConverter.setObjectMapper(objectMapper);
        return jsonConverter;
    }
}
