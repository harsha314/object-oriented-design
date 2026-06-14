package com.book.file.search.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;


public class FileTest {
    @Test
    void testSearch() {
        final File root = new File(true, 0, "adam", "root") ;
        final File a = new File(false, 2000, "adam", "a") ;
        final File b = new File(false, 3000, "george", "b") ;

        root.addEntry(a);
        root.addEntry(b);


        assertEquals(5000, root.getSize()) ;
        assertEquals(2, root.getEntries().size());

    }
}
