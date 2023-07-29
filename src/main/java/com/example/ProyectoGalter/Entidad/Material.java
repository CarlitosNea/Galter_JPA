package com.example.ProyectoGalter.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "material")
public class Material {

    // Creacion de columnas

    @Id
    @Column(unique = true,length = 10)
    private String codi_mate;

    @Column(unique = true,length = 10)
    private String nomb_mate;

    @Column(nullable = false)
    private float cant_mate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nombre_proveedor",referencedColumnName = "nombre_proveedor", nullable = false)
    @Fetch(FetchMode.JOIN)
    private Proveedor proveedor_mate;

    // Creacion de constructores
    public Material() {
    }
    public Material(String codi_mate, String nomb_mate, float cant_mate, Proveedor proveedor_mate) {
        this.setCodi_mate(codi_mate);
        this.setNomb_mate(nomb_mate);
        this.setCant_mate(cant_mate);
        this.setProveedor_mate(proveedor_mate);
    }


    // Metodos GET & SET
    public String getCodi_mate() {
        return codi_mate;
    }

    public void setCodi_mate(String codi_mate) {
        this.codi_mate = codi_mate;
    }

    public String getNomb_mate() {
        return nomb_mate;
    }

    public void setNomb_mate(String nomb_mate) {
        this.nomb_mate = nomb_mate;
    }

    public float getCant_mate() {
        return cant_mate;
    }

    public void setCant_mate(float cant_mate) {
        this.cant_mate = cant_mate;
    }

    public String getProveedor_mate() {
        return proveedor_mate.getNombre_proveedor();
    }

    public void setProveedor_mate(Proveedor proveedor_mate) {
        this.proveedor_mate = proveedor_mate;
    }


    // To String
    @Override
    public String toString() {
        return "Material{" +
                "codi_mate=" + codi_mate +
                ", nomb_mate=" + nomb_mate  +
                ", cant_mate=" + cant_mate +
                ", proveedor=" + proveedor_mate.getNombre_proveedor() +
                '}';
    }
}
