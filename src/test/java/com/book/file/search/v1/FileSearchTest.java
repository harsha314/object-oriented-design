package com.book.file.search.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.book.file.search.v1.operators.EqualsOperator;
import com.book.file.search.v1.operators.RegexMatchOperator;

public class FileSearchTest {
    @Test
    void testSearch() {
        final File root = new File(true, 0, "adam", "root") ;
        final File a = new File(false, 2000, "adam", "a") ;
        final File b = new File(false, 3000, "george", "b") ;
        
        root.addEntry(a);
        root.addEntry(b);

        FileSearchCriteria fileSearchCriteria = new FileSearchCriteria(new AndPredicate(List.of(
            new SimplePredicate<>(FileAttribute.IS_DIRECTORY, new EqualsOperator<>(), false),
            new SimplePredicate<>(FileAttribute.OWNER, new RegexMatchOperator<>(), "ge.*")
        )));

        final FileSearch fileSearch = new FileSearch();

        final List<File> result = fileSearch.search(root, fileSearchCriteria) ;

        assertEquals(1, result.size()) ;
        assertEquals("b", result.get(0).getFilename());

    }
}
