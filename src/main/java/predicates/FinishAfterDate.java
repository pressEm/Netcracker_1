package predicates;

import contracts.Contract;

import java.time.LocalDate;
import java.util.function.Predicate;


public class FinishAfterDate<T> implements Predicate<Contract> {
    @Override
    public boolean test(Contract c) {
        LocalDate date = LocalDate.of(2022, 10, 10);
        return (date.isBefore(c.getEnd()));
    }
}

