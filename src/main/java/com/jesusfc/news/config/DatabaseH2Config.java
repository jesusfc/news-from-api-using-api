package com.jesusfc.news.config;

        import com.zaxxer.hikari.HikariDataSource;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;

        /**
         * Author Jesús Fdez. Caraballo
         * jesus.fdez.caraballo@gmail.com
         * Created on feb - 2025
         */
        @Configuration
        public class DatabaseH2Config {

            @Bean
            public HikariDataSource dataSource() {
                HikariDataSource dataSource = new HikariDataSource();
                dataSource.setJdbcUrl("jdbc:h2:file:./data/myNewsDB;DB_CLOSE_ON_EXIT=FALSE;AUTO_RECONNECT=TRUE");
                dataSource.setUsername("sa");
                dataSource.setPassword("password");
                dataSource.setDriverClassName("org.h2.Driver");
                dataSource.setMaximumPoolSize(20);
                dataSource.setMinimumIdle(5);
                dataSource.setConnectionTimeout(30000);
                dataSource.setIdleTimeout(300000);
                dataSource.setMaxLifetime(1800000);
                return dataSource;
            }

        }