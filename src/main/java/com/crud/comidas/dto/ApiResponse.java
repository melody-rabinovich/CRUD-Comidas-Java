package com.crud.comidas.dto;

public class ApiResponse<T> { // de momento no hace falta que sea generic. Podría ser del tipo ComidaModel, pero por posibilidad de escalabilidad, quiero probar hacerlo generic.
    private int status;
    private String message;
    private T data;

    public ApiResponse(int status, String message, T data){
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus(){ return this.status;}
    public String getMessage(){ return this.message;}
    public T getData() { return this.data;}

}
