package com.nestor.market.domain.dto;

public class AuthenticationResponse {
    private String jwt;

    /*
    Cuando es necesario crear un constructor? y cuando no?..
    Cuando se necesite tener información desde el momento en que creas un objeto es necesario que se utilice
    un constructor o un builder (sí son muchos atributos ó si hay algunos opcionales).

    */
    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }


    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
