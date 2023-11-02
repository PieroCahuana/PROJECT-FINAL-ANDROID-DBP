package com.example.projectdbp.Models;
import java.time.LocalDateTime;

public class Paciente {
    private int idPaciente;
    private String nomPaciente;
    private String apePaciente;
    private String dniPaciente;
    private String nacPaciente;
    private int idGenero;
    private String telPaciente;
    private String usuPaciente;
    private String contraPaciente;

    public Paciente() {
    }

    public Paciente(int idPaciente,
                    String nomPaciente,
                    String apePaciente,
                    String dniPaciente,
                    String nacPaciente,
                    int idGenero,
                    String telPaciente,
                    String usuPaciente,
                    String contraPaciente) {
        this.idPaciente = idPaciente;
        this.nomPaciente = nomPaciente;
        this.apePaciente = apePaciente;
        this.dniPaciente = dniPaciente;
        this.nacPaciente = nacPaciente;
        this.idGenero = idGenero;
        this.telPaciente = telPaciente;
        this.usuPaciente = usuPaciente;
        this.contraPaciente = contraPaciente;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNomPaciente() {
        return nomPaciente;
    }

    public void setNomPaciente(String nomPaciente) {
        this.nomPaciente = nomPaciente;
    }

    public String getApePaciente() {
        return apePaciente;
    }

    public void setApePaciente(String apePaciente) {
        this.apePaciente = apePaciente;
    }

    public String getDniPaciente() {
        return dniPaciente;
    }

    public void setDniPaciente(String dniPaciente) {
        this.dniPaciente = dniPaciente;
    }

    public String getNacPaciente() {
        return nacPaciente;
    }

    public void setNacPaciente(String nacPaciente) {
        this.nacPaciente = nacPaciente;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public String getTelPaciente() {
        return telPaciente;
    }

    public void setTelPaciente(String telPaciente) {
        this.telPaciente = telPaciente;
    }

    public String getUsuPaciente() {
        return usuPaciente;
    }

    public void setUsuPaciente(String usuPaciente) {
        this.usuPaciente = usuPaciente;
    }

    public String getContraPaciente() {
        return contraPaciente;
    }

    public void setContraPaciente(String contraPaciente) {
        this.contraPaciente = contraPaciente;
    }
}
