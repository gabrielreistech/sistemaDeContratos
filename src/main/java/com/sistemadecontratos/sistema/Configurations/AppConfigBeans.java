package com.sistemadecontratos.sistema.Configurations;

import com.sistemadecontratos.sistema.Beans.MethodsBeans;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigBeans {

      @Bean
      public MethodsBeans methodsBeans(){
          return new MethodsBeans();
      }
}
