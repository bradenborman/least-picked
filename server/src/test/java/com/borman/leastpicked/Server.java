package com.borman.leastpicked;

import org.springframework.boot.builder.SpringApplicationBuilder;

public class Server extends LeastPickedApplication  {

    public static void main(String[] args) {
        new Server().configure(new SpringApplicationBuilder())
                .initializers()
//                .profiles("local", "devl")
                .run(args);
    }

}