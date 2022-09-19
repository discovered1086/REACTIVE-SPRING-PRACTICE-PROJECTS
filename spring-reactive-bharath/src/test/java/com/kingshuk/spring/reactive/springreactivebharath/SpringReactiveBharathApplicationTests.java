package com.kingshuk.spring.reactive.springreactivebharath;

import com.kingshuk.spring.reactive.springreactivebharath.model.BatchSubscriber;
import com.kingshuk.spring.reactive.springreactivebharath.model.FirstSubscriber;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.stream.Stream;

@SpringBootTest
class SpringReactiveBharathApplicationTests {

    @Test
    void testMono() {
        Mono<String> stringMono = Mono.just("Macbook Pro");
        stringMono.log().map(String::toUpperCase)
                .subscribe(System.out::println);
    }

    @Test
    void testFlux() {
        Flux<String> stringMono = Flux.just("Macbook Pro", "Lenovo PS1", "Dell XPS 17");
        stringMono.log().map(String::toUpperCase)
                .subscribe(System.out::println);
    }


    @Test
    void testFluxWithDelay() throws InterruptedException {
        Flux.just("Macbook Pro", "Lenovo PS1", "Dell XPS 17")
                .delayElements(Duration.ofSeconds(7))
                .log()
                .map(String::toUpperCase)
                .subscribe(System.out::println);

        Thread.sleep(22000);
    }


    @Test
    void testFluxFromCollection() {
        Flux.fromStream(Stream.of("Macbook Pro", "Lenovo PS1", "Dell XPS 17"))
                .log()
                .map(String::toUpperCase)
                .subscribe(System.out::println);
    }

    @Test
    void testFluxFromCollectionWithSubscriber() {
        Flux.fromStream(Stream.of("Macbook Pro", "Lenovo PS1", "Dell XPS 17"))
                .log()
                .map(String::toUpperCase)
                .subscribe(new FirstSubscriber());
    }


    @Test
    void testFluxFromCollectionWithBatching() {
        Flux.fromStream(Stream.of("Macbook Pro - Intel", "Lenovo PS1", "Dell XPS 17", "Dell XPS 13", "Macbook Pro-M1"))
                .log()
                .map(String::toUpperCase)
                .subscribe(new BatchSubscriber());
    }

}
