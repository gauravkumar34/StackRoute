package com.notesbook.userservice.exception;

public class UserAlreadyExist extends Exception{
    public String errorMsg;

    public UserAlreadyExist(){}

    public UserAlreadyExist(String errorMsg){
        super();
        this.errorMsg=errorMsg;
    }
}
