package com.family.family_members_api.family;
import reactor.core.publisher.Flux;
import java.util.Arrays;
import java.util.List;

public class FluxFromIterable {
    public static void main(List family) {
        System.out.println("-- Flux#fromIterable --");
        Flux.fromIterable(family)
                .subscribe(System.out::println);
    }
}
