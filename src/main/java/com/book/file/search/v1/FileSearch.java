package com.book.file.search.v1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class FileSearch {
    public List<File> search(File root, FileSearchCriteria fileSearchCriteria) {
        final List<File> result = new ArrayList<>();
        final ArrayDeque<File> recursionStack = new ArrayDeque<>();
        recursionStack.push(root) ;
        while(!recursionStack.isEmpty()) {
            File next = recursionStack.pop() ;
            System.out.println("File name : " + next.getFilename());
            if(fileSearchCriteria.isMatch(next)) {
                result.add(next) ;
            }
            for(File entry : next.getEntries()) {
                recursionStack.push(entry) ;
            }
        }
        return result ;
    }
}
