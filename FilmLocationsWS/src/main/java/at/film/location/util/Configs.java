package at.film.location.util;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")

public class Configs {

    @Value("${dataset.src}")
    public String dataSetSrc;

    public String getDataSetSrc() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL url = classLoader.getResource(dataSetSrc);
        return url.getPath();
    }

    public InputStream getDataSetAsInputStream() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream in = classLoader.getResourceAsStream(dataSetSrc);
        return in;
    }

    public void setDataSetSrc(String dataSetSrc) {
        this.dataSetSrc = dataSetSrc;
    }

}
