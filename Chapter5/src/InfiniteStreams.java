import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InfiniteStreams {

    public static void main(String[] args) {

        Stream.iterate(1, n -> n + n)
                .limit(10)
                .forEach(System.out::println);


        Stream.iterate(new int[]{0, 1}, i -> new int[]{i[1], i[0] + i[1]})
                .limit(10)
                .forEachOrdered(i -> System.out.println(Arrays.toString(i)));
//        0-1-1-2-3-5-8-13-21


        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);


        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;

            @Override
            public int getAsInt() {
                int oldPrev = previous;
                int nextVal = current + previous;
                previous = current;
                current = nextVal;
                return oldPrev;
            }
        };
        IntStream.generate(fib).limit(10).forEach(System.out::println);

    }


}
