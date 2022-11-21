package com.fipe.api.exceptions;

public class FipeAlreadyExistsExceptions extends RuntimeException {
        private String message;
        public FipeAlreadyExistsExceptions(String message) {
            super(message);
            this.message = message;
        }


}
