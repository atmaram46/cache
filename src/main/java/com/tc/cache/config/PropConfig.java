package com.tc.cache.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.FileReader;
import java.util.Properties;

@Getter
@Configuration
@PropertySource("application.properties")
public class PropConfig {

    @Value("${tc.cache.size}")
    private String cacheSize;

    public String getCacheSize1() {
        FileReader reader= null;
        Properties p=new Properties();
        try {
            reader = new FileReader("src/main/resources/application.properties");
            p.load(reader);
            reader.close();
        } catch (Exception e) {
            System.out.println("Error while Reading Properties file!!!");
            e.printStackTrace();
            return "4";
        }
        return p.getProperty("tc.cache.size");
    }
}
