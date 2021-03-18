package com.example.springboot;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SuperCounterServiceImpl implements CounterService {
    private int counter = 1;

    @Override
    public void add() {
        this.counter *= 2;
    }

    @Override
    public int GetCounter() {
        return counter;
    }
}
