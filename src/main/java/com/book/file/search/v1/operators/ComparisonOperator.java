package com.book.file.search.v1.operators;

public interface ComparisonOperator<T> {
    boolean isMatch(T a, T b);
}
