package com.book.file.search.v1;

import java.util.List;

public class OrPredicate implements CompositePredicate {
    private final List<Predicate> operands ;

    public OrPredicate(List<Predicate> operands) {
        this.operands = operands ;
    }

    @Override
    public boolean isMatch(File file) {
        return operands.stream()
                .anyMatch(predicate -> predicate.isMatch(file)) ;
    }    
}
