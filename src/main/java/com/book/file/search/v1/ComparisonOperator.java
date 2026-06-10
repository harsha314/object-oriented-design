package com.book.file.search.v1;

public interface ComparisonOperator<T> {
    boolean isMatch(T a, T b);
}
