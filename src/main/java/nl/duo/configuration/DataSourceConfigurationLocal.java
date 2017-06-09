package nl.duo.configuration;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("default")
public class DataSourceConfigurationLocal {

  @Bean
  @Primary
  public DataSourceProperties dataSourceProperties() {
      DataSourceProperties properties = new DataSourceProperties();
          properties.setInitialize(true);
      return properties;
  }
}