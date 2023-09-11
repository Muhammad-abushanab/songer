package com.sing.songer.Exceptions;

public class AlbumNotFoundException extends RuntimeException {
    public AlbumNotFoundException(String msg) {
        super(msg);
    }
    public AlbumNotFoundException(Throwable cause) {
        super(cause);
    }
}
