package com.book.file.search.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.book.file.search.v1.operators.ComparisonOperator;
import com.book.file.search.v1.operators.EqualsOperator;
import com.book.file.search.v1.operators.RegexMatchOperator;

public class RegexMatchOperatorTest {
    @Test
    void testSearch() {
        ComparisonOperator<String> comparisonOperator = new RegexMatchOperator<>() ;
        boolean result1 = comparisonOperator.isMatch("ge.*", "george") ;
        assertEquals(true, result1);
    }
}
