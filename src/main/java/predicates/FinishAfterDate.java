package predicates;

import contracts.Contract;
import contracts.IContract;

import java.time.LocalDate;
import java.util.function.Predicate;


public class FinishAfterDate<T> implements Predicate<Contract> {
    @Override
    public boolean test(Contract c) {
        LocalDate date = LocalDate.of(2022, 10, 10);
        return (date.isBefore(c.getEnd()));
    }

//    @Override
//    public boolean test(T t) {
//        LocalDate date = LocalDate.of(2022, 10, 10);
//        return (date.isBefore(t.getEnd()));
//    }
}

