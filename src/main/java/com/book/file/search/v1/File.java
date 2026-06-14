package com.book.file.search.v1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;

@Getter
public class File {
    private Boolean isDirectory ;
    private int size ;
    private String owner ;
    private String filename ;
    private Set<File> entries ;

    public File(Boolean isDirectory, int size, String owner, String filename) {
        this.isDirectory = isDirectory ;
        this.size = size ;
        this.owner = owner ;
        this.filename = filename ;
        this.entries = new HashSet<>() ;
    }
    
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
