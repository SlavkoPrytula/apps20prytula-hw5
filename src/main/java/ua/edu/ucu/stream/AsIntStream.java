package ua.edu.ucu.stream;

import ua.edu.ucu.function.*;
import ua.edu.ucu.itterator.Iterator;

import java.util.LinkedList;
import java.util.Objects;

public class AsIntStream implements IntStream {
    static LinkedList<Integer> intStream;
    private static Iterator<Integer> iterator;

    public AsIntStream() {
        // To Do
    }

    public AsIntStream(LinkedList<Integer> stream) {
        // To Do
        intStream = new LinkedList<>();
        intStream.addAll(stream);
    }

    public static IntStream of(int... values) {
        LinkedList<Integer> stream = new LinkedList<>();
        for (Integer integer : values) {
            stream.add(integer);
        }
//        Iterable<Integer> iterable = intStream;
//        iterator = (Iterator<Integer>) iterable.iterator();

        return new AsIntStream(stream); // ??
    }

    @Override
    public Double average() {
        // terminal method
        checkEmpty();
        return (double) (sum() / intStream.size());
    }

    @Override
    public Integer max() {
        // terminal method
        checkEmpty();
        int max = intStream.get(0);
        for (Integer integer : intStream) {
            if (integer > max) {
                max = integer;
            }
        }
        return max;
    }

    @Override
    public Integer min() {
        // terminal method
        checkEmpty();
        int min = intStream.get(0);
        for (Integer integer : intStream) {
            if (integer < min) {
                min = integer;
            }
        }
        return min;
    }

    @Override
    public long count() {
        // terminal method
        return intStream.size();
    }

    @Override
    public Integer sum() {
        // terminal method
        checkEmpty();
        int sum = 0;
        for (Integer integer : intStream) {
            sum += integer;
        }
        return sum;
    }

    @Override
    public IntStream filter(IntPredicate predicate) {
        Objects.requireNonNull(predicate);
//        Iterable<Integer> iterable = intStream;
//        Iterator<Integer> iterator = (Iterator<Integer>) iterable.iterator();

        LinkedList<Integer> temp = new LinkedList<>();

        for (Integer i : intStream) {
            if (predicate.test(i)){
                temp.add(i);
            }
        }
//        intStream = temp;
//        while (iterator.hasNext()) {
//            Integer integer = iterator.next();
//            if (predicate.test(integer)) {
//                temp.add(integer);
//            }
//        }
        return new AsIntStream(temp);
    }

    @Override
    public void forEach(IntConsumer action) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IntStream map(IntUnaryOperator mapper) {
        Objects.requireNonNull(mapper);
        LinkedList<Integer> temp = new LinkedList<>();

        for (Integer i : intStream) {
            Integer integer = mapper.apply(i);
            temp.add(integer);
        }
        return new AsIntStream(temp);
    }

    @Override
    public IntStream flatMap(IntToIntStreamFunction func) {
        Objects.requireNonNull(func);
        LinkedList<IntStream> temp = new LinkedList<>();

        for (Integer i : intStream) {
            IntStream integer = func.applyAsIntStream(i);
            temp.add(integer);
        }
        return new AsIntStream();
    }

    @Override
    public int reduce(int identity, IntBinaryOperator op) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[] toArray() {
        // terminal method
        int[] array = new int[intStream.size()];
        for (int i = 0; i < intStream.size(); i++) {
            array[i] = intStream.get(i);
        }
        return array;
    }

    private void checkEmpty() {
        if (intStream.size() == 0) {
            throw new IllegalArgumentException();
        }
    }

}
