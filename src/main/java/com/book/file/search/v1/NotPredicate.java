package com.book.file.search.v1;

public class NotPredicate implements Predicate {
    private final Predicate operand ;

    public NotPredicate(Predicate operand) {
        this.operand = operand ;
    }

    @Override
    public boolean isMatch(File file) {
        return !operand.isMatch(file);
    }
    
}
