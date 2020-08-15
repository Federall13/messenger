package com.example.messenger.messenger.quaters;

import lombok.Setter;

import javax.annotation.PostConstruct;

@Profiling
public class TerminatorQuater implements Quater {
    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    @Setter
    private String message;

    @PostConstruct
    public void init(){
        System.out.println("Phase 2");
        System.out.println(repeat);

    }

    public TerminatorQuater() {
        System.out.println("Phase 1");

    }

    @Override
    @PostProxy
    public void sayQuate() {
        System.out.println("3 Phase");
        for (int i = 0; i < repeat; i++) {
            System.out.println("message = " + message);
        }

    }
}
