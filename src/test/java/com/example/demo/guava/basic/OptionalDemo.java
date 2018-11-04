package com.example.demo.guava.basic;

import com.google.common.base.Optional;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class OptionalDemo {

    @Test
    public void test() {
        Optional<Integer> possible = Optional.of(5);
        possible.isPresent();
        Integer result = possible.get();
        log.debug("result - > {}",result);
    }
}
