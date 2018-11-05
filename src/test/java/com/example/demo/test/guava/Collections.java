package com.example.demo.test.guava;

import com.google.common.base.Function;
import com.google.common.collect.*;
import com.google.common.primitives.Ints;
import lombok.extern.slf4j.Slf4j;
import org.junit.FixMethodOrder;
import org.junit.Test;
import sun.security.provider.certpath.Vertex;

@Slf4j
@FixMethodOrder
public class Collections {

    @Test
    public void testA() {
        Multimap<String, String> multimap = ArrayListMultimap.create();
        multimap.put("fruit", "bannana");
        multimap.put("fruit", "apple");//key可以重复
        multimap.put("fruit", "apple");//value可以重复,不会覆盖之前的
        multimap.put("fruit", "peach");
        multimap.put("fish","crucian");//欧洲鲫鱼
        multimap.put("fish","carp");//鲤鱼
        log.debug("Collection -> {}",multimap.get("fruit"));
    }

    @Test
    public void testB() {
        ListMultimap<String, String> listMultimap = ArrayListMultimap.create();
        listMultimap.put("fruit", "bannana");
        listMultimap.put("fruit", "apple");
        listMultimap.put("fruit", "peach");
        listMultimap.put("fish","crucian");//欧洲鲫鱼
        listMultimap.put("fish","carp");//鲤鱼
        log.debug("List -> {}",listMultimap.get("fruit"));
    }

    @Test
    public void testC() {
        Multimap<String,String> multimap= HashMultimap.create();
        multimap.put("fruit", "bannana");
        multimap.put("fruit", "apple");
        multimap.put("fruit", "apple");
        log.debug("Collection -> {}",multimap.get("fruit"));
    }

    @Test
    public void testD() {
        ImmutableSet<String> digits = ImmutableSet.of(
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine");
        Function<String, Integer> lengthFunction = string -> string.length();
        ImmutableListMultimap<Integer, String> digitsByLength = Multimaps.index(digits, lengthFunction);
        log.debug("digitsByLength -> {}",digitsByLength);
    }

    @Test
    public void testE() {
        ArrayListMultimap<String, Integer> multimap = ArrayListMultimap.create();
        multimap.putAll("b", Ints.asList(2, 4, 6));
        multimap.putAll("a", Ints.asList(4, 2, 1));
        multimap.putAll("c", Ints.asList(2, 5, 3));

        log.debug("multimap -> {}",multimap);
        TreeMultimap<Integer, String> inverse = Multimaps.invertFrom(multimap,TreeMultimap.create());
        log.debug("inverse -> {}",inverse);
    }

}
