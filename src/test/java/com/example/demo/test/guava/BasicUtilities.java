package com.example.demo.test.guava;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.FixMethodOrder;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

@Slf4j
@FixMethodOrder
public class BasicUtilities {

    @Test
    public void testA() {
        Optional<Integer> possible1 = Optional.of(5);
        possible1.isPresent();
        log.debug("Optional::get -> {}", possible1.get());

        Optional<Integer> possible2 = Optional.absent();
        possible2.or(20);
        log.debug("Optional::orNull -> {}", possible2.orNull());

        Optional<Integer> possibl3 = Optional.of(10);
        log.debug("Optional::or -> {}", possibl3.or(20));
    }

    @Test
    public void testB() {
        Integer mo = MoreObjects.firstNonNull(null, 2);
        log.debug("result -> {}", mo.intValue());
    }

    @Test
    public void testC() {
        log.debug("nullToEmpty -> {}", Strings.nullToEmpty(null));
        log.debug("emptyToNull -> {}", Strings.emptyToNull(""));
        log.debug("repeat -> {}", Strings.repeat("abc", 3));
        log.debug("isNullOrEmpty -> {}", Strings.isNullOrEmpty(""));
        log.debug("isNullOrEmpty -> {}", Strings.isNullOrEmpty(null));
        log.debug("lenientFormat -> {}", Strings.lenientFormat("ABC", 1, 2));
    }

    @Test
    public void testD() {
        Ordering<String> byLengthOrdering = new Ordering<String>() {
            public int compare(String left, String right) {
                return Ints.compare(left.length(), right.length());
            }
        };
        List<String> data = Lists.newArrayList("a", "an", "are", "your");
        log.debug("reverse -> {}", byLengthOrdering.reverse().sortedCopy(data));
        log.debug("leastOf -> {}", byLengthOrdering.leastOf(data, 2));
        assertTrue(byLengthOrdering.isOrdered(data));

        List<String> list = Lists.newArrayList("peida","jerry","harry","eva","jhon","neron");
        Ordering<String> naturalOrdering = Ordering.natural();
        Ordering<Object> usingToStringOrdering = Ordering.usingToString();
        Ordering<Object> arbitraryOrdering = Ordering.arbitrary();

        log.debug("naturalOrdering -> {} ", naturalOrdering.sortedCopy(list));
        log.debug("usingToStringOrdering -> {}", usingToStringOrdering.sortedCopy(list));
        log.debug("arbitraryOrdering -> {}",arbitraryOrdering.sortedCopy(list));
    }

    @Test
    public void testE() {
        log.debug("Objects::equal -> {}" ,Objects.equal(1,2) );
        log.debug("Objects::hashCode -> {}" ,Objects.hashCode(1,2) );
    }
}
