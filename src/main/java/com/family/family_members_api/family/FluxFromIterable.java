package com.family.family_members_api.family;
import reactor.core.publisher.Flux;
import java.util.Arrays;
import java.util.List;
import java.lang.RuntimeException;

public class FluxFromIterable {
    public static void main(List family) {
        System.out.println("-- Flux#fromIterable --");
        Flux flux = Flux.fromIterable(family)
                //.concatWith(Flux.error(new RuntimeException("Something went wrong")))
                .log()
                .take(2);
        flux.subscribe(System.out::println);
    }
}
