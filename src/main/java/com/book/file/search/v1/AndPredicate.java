package com.book.file.search.v1;

import java.util.List;

public class AndPredicate implements CompositePredicate {
    private List<Predicate> operands ;

    public boolean isMatch(File file) {
        return operands.stream()
            .map((predicate) -> predicate.isMatch(file))
            .reduce(true, Boolean::logicalAnd) ;
    }
}
