package predicates;

import contracts.Contract;

import java.time.LocalDate;
import java.util.function.Predicate;


public class StartBeforeDate<T> implements Predicate<Contract> {
    @Override
    public boolean test(Contract c) {
        LocalDate date = LocalDate.of(2019, 1, 1);
        return (c.getStart().isBefore(date));
    }
}
