package com.example.liquibasedemo;

import com.example.liquibasedemo.Util.Utils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiquibasedemoApplication {

	public static void main(String[] args) {

//	   String JDBC_URL = "jdbc:postgresql://localhost:5433/liquibasetest";
//		String USERNAME="postgres";
//		String PASSWORD="postgres";
//		String DriverClassName = "org.postgresql.Driver";


		SpringApplication.run(LiquibasedemoApplication.class, args);
		System.out.println("Hello");

//		System.out.println(Utils.getDbConfig(JDBC_URL,USERNAME,PASSWORD,DriverClassName));
	}

}
