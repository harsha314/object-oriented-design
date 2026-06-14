package com.book.file.search.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.book.file.search.v1.operators.EqualsOperator;
import com.book.file.search.v1.operators.RegexMatchOperator;

public class SimplePredicateTest {
    @Test
    void testSearch() {
        final File root = new File(true, 0, "adam", "root") ;
        final File a = new File(false, 2000, "adam", "a") ;
        final File b = new File(false, 3000, "george", "b") ;

        root.addEntry(a);
        root.addEntry(b);

        SimplePredicate<Boolean> checkIfNotDirectory = 
            new SimplePredicate<>(FileAttribute.IS_DIRECTORY, new EqualsOperator<>(), false) ;

        assertEquals(false, checkIfNotDirectory.isMatch(root));
        assertEquals(true, checkIfNotDirectory.isMatch(a));
        assertEquals(true, checkIfNotDirectory.isMatch(b));

        SimplePredicate<String> simplePredicate2 = 
            new SimplePredicate<>(FileAttribute.OWNER, new RegexMatchOperator<>(), "ge.*") ;
        
        assertEquals(true, simplePredicate2.isMatch(b));

    }
}
