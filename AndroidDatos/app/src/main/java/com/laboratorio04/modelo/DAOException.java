package com.laboratorio04.modelo;

public class DAOException extends  Exception {
    public DAOException(){
        super();
    }

    public DAOException(String message, Throwable throwable){
        super(message, throwable);
    }

    public DAOException(String message){
        super(message);
    }

    public DAOException(Throwable throwable){
        super(throwable);
    }
}