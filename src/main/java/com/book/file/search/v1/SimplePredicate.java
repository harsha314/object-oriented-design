package com.book.file.search.v1;

import com.book.file.search.v1.operators.ComparisonOperator;

public class SimplePredicate implements Predicate {
    private FileAttribute attributeName ;
    private ComparisonOperator operator ;
    private String expectedValue ;
    
    @Override
    public boolean isMatch(File file) {
        return true ;
    }
}
