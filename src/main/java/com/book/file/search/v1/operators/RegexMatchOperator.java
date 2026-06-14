package com.book.file.search.v1.operators;

import java.util.regex.Pattern;

public class RegexMatchOperator<T extends String> implements ComparisonOperator<T> {

    @Override
    public boolean isMatch(T expectedValue, T attributeValue) {
        final Pattern p = Pattern.compile(expectedValue) ;
        return p.matcher(attributeValue).matches() ;
    }
    
}
