package com.crud.comidas.models;

import com.crud.comidas.enums.Categoria;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="COMIDAS")

public class ComidaModel {  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

   
    @Column(name="id")
    private long id;

    
    @NotBlank
    @Column(name="nombre")
    private String nombre;

    @Min(1)
    @Column(name="precio")
    private double precio;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="categoria")
    private Categoria categoria;

    @NotNull
    @Column(name="esVegano")
    private boolean esVegano;

    @NotNull
    @Column(name="esVegetariano")
    private boolean esVegetariano;

    @NotNull
    @Column(name="esSinTacc")
    private boolean esSinTacc;

    public ComidaModel(){

    }

    public ComidaModel(String nombre, double precio, Categoria categoria, boolean esVegano, boolean esVegetariano, boolean esSinTacc){
        setNombre(nombre);
        setPrecio(precio);
        setCategoria(categoria);
        setEsVegano(esVegano);
        setEsVegetariano(esVegetariano);
        setEsSinTacc(esSinTacc);
    }


    @PrePersist
    @PreUpdate
    public void normalizar(){
        this.nombre = nombre.toUpperCase().trim();
    }


    public void setNombre(String nombre){this.nombre = nombre;    }
    public String getNombre(){return this.nombre;}
    public void setPrecio(double precio){ this.precio = precio;}
    public double getPrecio(){return this.precio;}
    public void setCategoria(Categoria categoria){this.categoria = categoria;}
    public Categoria getCategoria(){return this.categoria;}
    public void setEsVegano(boolean esVegano){this.esVegano = esVegano;}
    public boolean getEsVegano(){return this.esVegano;}
    public void setEsVegetariano(boolean esVegetariano){this.esVegetariano = esVegetariano;}
    public boolean getEsVegetariano(){return this.esVegetariano;}
    public void setEsSinTacc(boolean esSinTacc){this.esSinTacc = esSinTacc;}
    public boolean getEsSinTacc(){return this.esSinTacc;}






}

