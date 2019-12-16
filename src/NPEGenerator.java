import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class NPEGenerator {

    private Integer field = null;

    public List<Pair<String, Function<Void, Void>>> getCases() {
        return Arrays.asList(
            Pair.of("Local object is null", nothing -> {
                Object object = getEmpty();
                object.toString();
                return null;
            }),
            Pair.of("Function is null", nothing -> {
                getEmpty().toString();
                return null;
            }),
            Pair.of("Class member is null", nothing -> {
                field.toString();
                return null;
            }),
            Pair.of("Synchronized section is null", nothing -> {
                synchronized (getEmpty().getClass()) {
                    getEmpty();
                }
                return null;
            }),
            Pair.of("Array element is null", nothing -> {
                int i = 1;
                String[] strings = new String[]{"Hey", null, "no"};
                strings[i].toString().toString();
                return null;
            }),
            Pair.of("Array of array element is null", nothing -> {
                int i = 1;
                String[][] strings = new String[][]{
                    new String[] { "Hey" },
                    new String[] { null },
                    new String[] {"Hello"}};
                strings[i][0].toString().toString();
                return null;
            })
        );
    }

    public Object getEmpty() {
        return null;
    }

    public static class Pair<T, Y> {

        private final T first;
        private final Y second;

        public static <T,Y> Pair<T,Y> of(T first, Y second) {
            return new Pair<>(first, second);
        }

        public Pair(T first, Y second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public Y getSecond() {
            return second;
        }
    }
}
