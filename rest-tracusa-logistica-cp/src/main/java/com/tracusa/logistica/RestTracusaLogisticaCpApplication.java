package com.tracusa.logistica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages={
"com.tracusa.logistica.dao",
"com.tracusa.logistica.bo",
"com.tracusa.logistica.interfase.bo",
"com.tracusa.logistica.interfase.dao",
"com.tracusa.logistica.controller",
"com.administracion.ibo.IParamsSistemaBO",
"com.administracion.dao",
"com.administracion.idao",
"com.administracion.bo",
"com.administracion.ibo"})
public class RestTracusaLogisticaCpApplication {

    public static void main(String[] args) {
	SpringApplication.run(RestTracusaLogisticaCpApplication.class, args);
    }

}
