package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return strings -> {
            for (String str : strings) {
                if (!str.trim().substring(0, 1).matches(("[A-Z]"))) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return integers -> {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (Integer i : integers) {
                if (i % 2 == 0) {
                    tmp.add(i);
                }
            }
            integers.addAll(tmp);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> res = new ArrayList<>();
            for (String str : values) {
                boolean isOk = true;
                if (!str.trim().substring(0, 1).matches(("[A-Z]"))) {
                    isOk = false;
                }
                if (!str.endsWith(".")) {
                    isOk = false;
                }
                if (str.split(" ").length <= 3) {
                    isOk = false;
                }
                if (isOk)
                    res.add(str);
            }
            return res;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return strings -> strings.stream().collect(Collectors.toMap(a -> a, String::length, (a, b) -> a));
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (integers, integers2) -> {
            integers.addAll(integers2);
            return integers;
        };
    }
}
