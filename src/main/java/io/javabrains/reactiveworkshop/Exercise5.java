package io.javabrains.reactiveworkshop;

import reactor.core.Disposable;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        ReactiveSources.intNumbersFlux().subscribe(System.out::println,
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Complete"));

        // Subscribe to a flux using an implementation of BaseSubscriber
        Disposable baseSubscriber = ReactiveSources.intNumbersFlux().subscribe(System.out::println,
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Complete"));
        System.out.println("Press a key to end");
        System.in.read();
    }

}