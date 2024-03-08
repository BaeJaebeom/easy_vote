package com.recrime.easy_vote.configuration

import jakarta.persistence.EntityManagerFactory
import lombok.AllArgsConstructor
import lombok.RequiredArgsConstructor
import org.apache.commons.lang3.StringUtils
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.core.env.Environment
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import java.util.*
import javax.sql.DataSource

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = ["com.recrime.easy_vote.repository"])
class DataSourceConfig (
    private val env: Environment
){

    @Primary
    @Bean(name = ["dataSource"])
    @ConfigurationProperties(prefix = "asdf.datasource")
    fun dataSource(): DataSource {
        return DataSourceBuilder.create().build()
    }

    @Primary
    @Bean(name = ["jpaProperties"])
    @ConfigurationProperties(prefix = "spring.jpa")
    fun jpaProperties(): JpaProperties {
        return JpaProperties()
    }

    @Primary
    @Bean(name = ["entityManagerFactory"])
    fun entityManagerFactory(
        builder: EntityManagerFactoryBuilder,
        @Qualifier("dataSource") dataSource: DataSource,
        @Qualifier("jpaProperties") jpaProperties: JpaProperties
    ): LocalContainerEntityManagerFactoryBean {
        val props = HashMap<String, Any?>()
        props["hibernate.hbm2ddl.auto"] =
            StringUtils.defaultIfBlank(env.getProperty("hibernate.hbm2ddl.auto"), "none")
        return builder.dataSource(dataSource)
            .packages("com.recrime.easy_vote.domain")
            .persistenceUnit("default")
            .properties(props)
            .build()
    }

    @Primary
    @Bean(name = ["transactionManager"])
    fun transactionManager(
        @Qualifier("entityManagerFactory") entityManagerFactory: EntityManagerFactory
    ): PlatformTransactionManager {
        return JpaTransactionManager(entityManagerFactory)
    }

}