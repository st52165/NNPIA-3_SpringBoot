package com.example.springboot;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CounterServiceImpl implements CounterService {
    private int counter = 0;

    @Override
    public void add() {
        this.counter++;
    }

    @Override
    public int GetCounter() {
        return counter;
    }
}
