package q12.operation;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class Operation<T, R> {
    private Function<T, R> operation;
    private Map<T, R> cache = new HashMap<>();
    private Supplier<R> supp;

    public Operation() {
    }

    public Operation(Function<T, R> operation) {
        this.operation = operation;
    }

    public Operation(Function<T, R> operation, Supplier<R> supp) {
        this.operation = operation;
        this.supp = supp;
    }

    public <V> Operation<T, V> then(Function<R, V> fct) {
        Function<T, V> newFct = x -> fct.apply(operation.apply(x));
        Operation<T, V> newOperation = new Operation<T, V>(newFct);
        return newOperation;
    }

    public Operation<T, R> except(Supplier<R> supp) {
        return new Operation<T, R>(operation, supp);
    }

    public boolean hasCachedResult(T forInput) {
        if (cache.get(forInput) != null) {
            return true;
        } else {
            return false;
        }
    }

    public R resolve(T input) {
        // Check whether it is cached otherwise compute
        try {
            if (hasCachedResult(input)) {
                return cache.get(input);
            } else {
                R res = operation.apply(input);
                cache.put(input, res);
                return res;
            }
        } catch (Exception e) {
            return supp.get();
        }

    }
}