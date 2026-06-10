package com.book.file.search.v1;

public class SimplePredicate implements Predicate {
    private FileAttribute attributeName ;
    private ComparisonOperator operator ;
    private String expectedValue ;
    
    @Override
    public boolean isMatch(File file) {
        return true ;
    }
}
