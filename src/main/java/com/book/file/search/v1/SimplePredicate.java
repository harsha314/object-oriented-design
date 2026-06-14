package com.book.file.search.v1;

import com.book.file.search.v1.operators.ComparisonOperator;

public class SimplePredicate<T> implements Predicate {
    private FileAttribute attributeName ;
    private ComparisonOperator<T> comparisonOperator ;
    private T expectedValue ;

    public SimplePredicate(final FileAttribute attributeName, final ComparisonOperator<T> comparisonOperator, final T exepectedValue) {
        this.attributeName = attributeName ;
        this.comparisonOperator = comparisonOperator ;
        this.expectedValue = exepectedValue ;
    }
    
    @Override
    public boolean isMatch(File file) {
        Object actualValue = file.extract(attributeName);
        if(expectedValue.getClass().isInstance(actualValue)) {
            return comparisonOperator.isMatch(expectedValue, (T) actualValue);
        } else {
            return false ;
        }
    }
}
