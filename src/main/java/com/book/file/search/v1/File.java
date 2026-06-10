package com.book.file.search.v1;

import java.util.Set;

import lombok.Getter;

@Getter
public class File {
    private Boolean isDirectory ;
    private int size ;
    private String owner ;
    private String filename ;
    private Set<File> entries ;
    
    public Object extract(FileAttribute attributeName) {
        switch (attributeName) {
            case SIZE:
                return size ;
            case OWNER:
                return owner;
            case IS_DIRECTORY:
                return isDirectory;
            case FILENAME:
                return filename;
            default:
                break;
        }
        return null ;
    }

    public void addEntry(File entry) {
        entries.add(entry);
        size += entry.getSize() ;
    }
}
