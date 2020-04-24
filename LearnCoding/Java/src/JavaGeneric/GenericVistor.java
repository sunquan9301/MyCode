package JavaGeneric;

public class GenericVistor {
}

abstract class Tree<E> {
    public interface Visitor<E, R> {

        public R leaf(E elt);

        public R branch(R left, R right);
    }

    public abstract <R> R visit(Visitor<E, R> v);

    public static <T> Tree<T> leaf(final T e) {
        return new Tree<T>() {
            public <R> R visit(Visitor<T, R> v) {
                return v.leaf(e);
            }
        };
    }

    public static <T> Tree<T> branch(final Tree<T> l, final Tree<T> r) {
        return new Tree<T>() {
            public <R> R visit(Visitor<T, R> v) {
                return v.branch(l.visit(v), r.visit(v));
            }
        };
    }
}

class TreeClient {
    public static <T> String toString(Tree<T> t) {
        return t.visit(new Tree.Visitor<T, String>() {

            public String leaf(T e) {
                return e.toString();
            }

            public String branch(String l, String r) {
                return "(" + l + "^" + r + ")";
            }
        });
    }

    public static <N extends Number> double sum(Tree<N> t) {
        return t.visit(new Tree.Visitor<N, Double>() {
            public Double leaf(N e) {
                return e.doubleValue();
            }

            public Double branch(Double l, Double r) {
                return l + r;
            }
        });
    }

    public static void main(String[] args) {
        Tree<Integer> t =
                Tree.branch(Tree.branch(Tree.leaf(1), Tree.leaf(2)),
                        Tree.leaf(3));
        assert toString(t).equals("((1^2)^3)");
        assert sum(t) == 6;
    }
}