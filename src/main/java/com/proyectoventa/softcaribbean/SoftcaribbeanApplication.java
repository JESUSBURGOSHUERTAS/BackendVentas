package com.proyectoventa.softcaribbean;

import com.proyectoventa.softcaribbean.controller.ProductoController;
import com.proyectoventa.softcaribbean.cors.FiltrosCors;
import com.proyectoventa.softcaribbean.dto.Productos;
import com.proyectoventa.softcaribbean.exception.ControllerException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;

import java.util.List;

@SpringBootApplication
public class SoftcaribbeanApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoftcaribbeanApplication.class, args);

	}

	@Bean
	public FilterRegistrationBean<FiltrosCors> corsFilterRegistration() {
		FilterRegistrationBean<FiltrosCors> registrationBean = new FilterRegistrationBean<>(new FiltrosCors());
		registrationBean.setName("filtros CORS");
		registrationBean.addUrlPatterns("/*");
		registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return registrationBean;
	}

}
