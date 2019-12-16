import java.util.function.Function;

public class TestRunner {

  private static Object anotherObject = getAnEmpty();

  public static void main(String[] args) {
    int localVar = 1;
    Object empty = getAnEmpty();

    for (NPEGenerator.Pair<String, Function<Void, Void>> NpeCase : new NPEGenerator().getCases()) {
      try {
          NpeCase.getSecond().apply(null);
      } catch (NullPointerException npe) {
        System.out.println("NPE has been thrown for "+ NpeCase.getFirst() + " with message:" + npe.getMessage());
      }
    }
  }

  public static Object getAnEmpty() {
    return null;
  }
}
