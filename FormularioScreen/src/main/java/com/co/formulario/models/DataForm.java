package com.co.formulario.models;

public class DataForm {

    private String name;
    private String email;
    private String adress;
    private String adresspermanent;

    public DataForm(String name, String email, String adress, String adresspermanent) {
        this.name = name;
        this.email = email;
        this.adress = adress;
        this.adresspermanent = adresspermanent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAdresspermanent() {
        return adresspermanent;
    }

    public void setAdresspermanent(String adresspermanent) {
        this.adresspermanent = adresspermanent;
    }
}
