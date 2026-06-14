package com.book.file.search.v1;

import java.util.List;

public class AndPredicate implements CompositePredicate {
    private List<Predicate> operands ;

    public AndPredicate(final List<Predicate> operands) {
        this.operands = operands ;
    }

    public boolean isMatch(File file) {
        return operands.stream()
            .allMatch(predicate -> predicate.isMatch(file)) ;
    }
}
