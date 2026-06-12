package com.book.file.search.v1.operators;

import java.util.Objects;

public class EqualsOperator<T> implements ComparisonOperator<T> {

    @Override
    public boolean isMatch(T a, T b) {
        return Objects.equals(a, b);
    }
    
}
