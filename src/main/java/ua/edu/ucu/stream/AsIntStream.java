package ua.edu.ucu.stream;

import ua.edu.ucu.function.IntBinaryOperator;
import ua.edu.ucu.function.IntToIntStreamFunction;
import ua.edu.ucu.function.IntConsumer;
import ua.edu.ucu.function.IntUnaryOperator;
import ua.edu.ucu.function.IntPredicate;

import java.util.LinkedList;
import java.util.Objects;

public class AsIntStream implements IntStream {
    private final LinkedList<Integer> intStream;

    public AsIntStream(LinkedList<Integer> stream) {
        this.intStream = new LinkedList<>();
        this.intStream.addAll(stream);
    }

    public static IntStream of(int... values) {
        LinkedList<Integer> stream = new LinkedList<>();
        for (Integer integer : values) {
            stream.add(integer);
        }
        return new AsIntStream(stream);
    }

    @Override
    public Double average() {
        checkEmpty();
        return (double) (sum() / intStream.size());
    }

    @Override
    public Integer max() {
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
        checkEmpty();
        return intStream.size();
    }

    @Override
    public Integer sum() {
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
        LinkedList<Integer> temp = new LinkedList<>();

        for (Integer i : intStream) {
            if (predicate.test(i)) {
                temp.add(i);
            }
        }
        return new AsIntStream(temp);
    }

    @Override
    public void forEach(IntConsumer action) {
        Objects.requireNonNull(action);
        for (Integer i : intStream) {
            action.accept(i);
        }
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
        LinkedList<Integer> temp = new LinkedList<>();

        for (Integer i : intStream) {
            int[] items = func.applyAsIntStream(i).toArray();
            for (Object j : items) {
                temp.add((Integer) j);
            }
        }
        return new AsIntStream(temp);
    }

    @Override
    public int reduce(int identity, IntBinaryOperator op) {
        Objects.requireNonNull(op);
        int result = identity;

        for (Integer i : intStream) {
            result = op.apply(result, i);
        }
        return result;
    }

    @Override
    public int[] toArray() {
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
