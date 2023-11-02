package com.hugosPetShop.petShop.springboot.exception;

public class PetNotFoundException extends RuntimeException {
    public PetNotFoundException(Long id){
        super("Could not find user with id" + id);
    }
}
