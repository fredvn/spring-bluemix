package nl.duo.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.config.java.ServiceScan;
import org.springframework.cloud.service.ServiceInfo;
import org.springframework.cloud.service.common.RelationalServiceInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("cloud")
@ServiceScan
public class DataSourceConfiguration {

  @Bean
  public Cloud cloud() {
    return new CloudFactory().getCloud();
  }

  @Autowired(required=false)
  Cloud cloud;

  @Bean
  @Primary
  public DataSourceProperties dataSourceProperties() {
      DataSourceProperties properties = new DataSourceProperties();
      if (cloud != null) {
          properties.setInitialize(false);
        List<ServiceInfo> infos = cloud.getServiceInfos(RelationalServiceInfo.class);
        if (infos.size()==1) {
          RelationalServiceInfo info = (RelationalServiceInfo) infos.get(0);
          properties.setUrl(info.getJdbcUrl());
          properties.setUsername(info.getUserName());
          properties.setPassword(info.getPassword());
        }
      }
      return properties;
  }
}