package com.book.file.search.v1;

public class FileSearchCriteria {
    private Predicate predicate ;

    public FileSearchCriteria(Predicate predicate) {
        this.predicate = predicate ;
    }
    
    public boolean isMatch(File file) {
        return predicate.isMatch(file) ;
    }
}
