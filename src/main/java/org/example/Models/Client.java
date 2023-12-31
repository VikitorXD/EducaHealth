package org.example.Models;

import java.time.LocalDate;

public class Client {
    private long idUser;
    private LocalDate birth_date;
    private String nmCliente;
    private String email;
    private String password;

    public Client(long idUser,  LocalDate birth_date, String nmCliente, String email, String password) {
        this.idUser = idUser;
        this.nmCliente = nmCliente;
        this.email = email;
        this.password = password;
        this.birth_date = birth_date;
    }

    public Client() {
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public String getNmCliente() {
        return nmCliente;
    }

    public void setNmCliente(String nmCliente) {
        this.nmCliente = nmCliente;
    }

    public void novo(){

    }
}
