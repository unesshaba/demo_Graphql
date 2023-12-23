package org.sid.videoservice;

import org.sid.videoservice.entities.Creator;
import org.sid.videoservice.entities.Vedio;
import org.sid.videoservice.repositories.CreatorRepository;
import org.sid.videoservice.repositories.VedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class VideoServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(VideoServiceApplication.class, args);
    }
@Bean
    CommandLineRunner start(VedioRepository vedioRepository,CreatorRepository creatorRepository){
        return args -> {
            List<Creator> creators= List.of(
                    Creator.builder()
                            .name("youness")
                            .email("youness@gmail.com")
                            .build(),
                    Creator.builder().name("karim").email("karim@email.com").build());
           creatorRepository.saveAll(creators);
List<Vedio> vedios=List.of(
        Vedio.builder().name("movie").description("movie drama").url("http:localhost:8081/movie").creator(creators.get(0)).datePublication(new Date()).build(),
        Vedio.builder().name("serie").description("serie drama").url("http:localhost:8081/drama").creator(creators.get(1)).datePublication(new Date()).build()

);
              vedioRepository.saveAll(vedios);
        };
    }
}
