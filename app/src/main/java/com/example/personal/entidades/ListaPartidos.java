package com.example.personal.entidades;

public class ListaPartidos {
    private String equiposP;
    private String fechaP;
    private String tpartidoP;
    private int foto;


    public ListaPartidos(String equiposP, String fechaP, String tpartidoP, int foto) {
        this.equiposP = equiposP;
        this.fechaP = fechaP;
        this.tpartidoP = tpartidoP;
        this.foto = foto;
    }

    public String getEquiposP() {
        return equiposP;
    }

    public String getFechaP() {
        return fechaP;
    }

    public String getTpartidoP() {
        return tpartidoP;
    }

    public int getFoto() {
        return foto;
    }
}
