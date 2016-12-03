package org.hoboventures.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.PersistenceUnit;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Asha on 12/2/2016.
 */
@Configuration
public class ExampleApplicationConfig {

    private static final Logger logger = LoggerFactory.getLogger(ExampleApplicationConfig.class);

    /*@Bean(name={"dataSource"})
    @Required
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name={"entityManagerFactory"})
    @Required
    @PersistenceUnit
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
        Map<String, String> jpaProperties = new HashMap<>();
        jpaProperties.put("hibernate.jdbc.batch_size", "50");
        jpaProperties.put("hibernate.order_inserts", "true");
        jpaProperties.put("hibernate.order_updates", "true");
        jpaProperties.put("hibernate.cache.use_query_cache", "true");
        jpaProperties.put("hibernate.default_batch_fetch_size", "10");

        jpaProperties.put("hibernate.connection.includeSynonyms", "true");
        jpaProperties.put("javax.persistence.sharedCache.mode", "ENABLE_SELECTIVE");
        jpaProperties.put("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
        jpaProperties.put("hibernate.cache.provider_class", "org.hibernate.cache.EhCacheProvider");

        LocalContainerEntityManagerFactoryBean factoryBean = builder.dataSource(dataSource())
                .packages(new String[] { "com.assurant.inc.example.domain" })
                .properties(jpaProperties)
                .build();
        return factoryBean;
    }

    @Bean(name={"jdbcTemplate"})
    public JdbcTemplate jdbcTemplate()  {
        return new JdbcTemplate(dataSource());
    }
*/

}
