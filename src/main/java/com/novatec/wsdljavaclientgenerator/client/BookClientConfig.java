package com.novatec.wsdljavaclientgenerator.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class BookClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
            Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
            marshaller.setContextPath("com.novatec.wsdljavaclientgenerator.client.gen");
            return marshaller;
    }

    @Bean
    public BookClient bookClient(Jaxb2Marshaller marshaller) {
            BookClient client = new BookClient();
            client.setDefaultUri("http://localhost:8080/ws");
            client.setMarshaller(marshaller);
            client.setUnmarshaller(marshaller);
            return client;
    }
}