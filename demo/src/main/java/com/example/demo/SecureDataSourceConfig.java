// package com.example.demo;

// import org.springframework.boot.jdbc.DataSourceBuilder;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Primary;

// import java.io.Console;
// import java.util.Arrays;
// import java.util.Scanner;

// import javax.sql.DataSource;
// import com.zaxxer.hikari.HikariDataSource;

// @Configuration
// public class SecureDataSourceConfig {

//     @Bean
//     @Primary
//     public DataSource dataSource(){
//         String password = promptForPassword();

//         return DataSourceBuilder.create()
//                                 .type(com.zaxxer.hikari.HikariDataSource.class)
//                                 .driverClassName("org.postgresql.Driver")
//                                 .url("jdbc:postgresql://localhost:5432/demoapp")
//                                 .username("postgres")
//                                 .password(password)
//                                 .build();
//     }

//     private String promptForPassword(){
//         Console console = System.console();
        
//         if(console != null){
//             char[] passChars = console.readPassword("Enter PostgreSQL password: ");
//             String password = new String(passChars);
//             Arrays.fill(passChars, '\0');
//             return password; 
//         }
//         else {
//             // Running from IDE - use Scanner as fallback
//             System.out.print("Enter PostgreSQL password: ");
//             try (Scanner scanner = new Scanner(System.in)){
//                 return scanner.nextLine();
//             }
//         }
//     }
// }
