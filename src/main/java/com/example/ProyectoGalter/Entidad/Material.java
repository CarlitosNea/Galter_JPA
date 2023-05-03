package com.example.ProyectoGalter.Entidad;

import com.example.ProyectoGalter.Entidad.Proveedor;
import jakarta.persistence.*;

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
    private Double cant_mate;

    @ManyToOne
    @JoinColumn(referencedColumnName = "nombre_proveedor")
    private Proveedor proveedor;


    // Creacion de constructores
    public Material(String codi_mate, String nomb_mate, Double cant_mate, Proveedor proveedor) {
        this.setCodi_mate(codi_mate);
        this.setNomb_mate(nomb_mate);
        this.setCant_mate(cant_mate);
        this.setProveedor(proveedor);
    }

    public Material() {
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

    public Double getCant_mate() {
        return cant_mate;
    }

    public void setCant_mate(Double cant_mate) {
        this.cant_mate = cant_mate;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }


    // To String
    @Override
    public String toString() {
        return "Material{" +
                "codi_mate='" + codi_mate + '\'' +
                ", nomb_mate='" + nomb_mate + '\'' +
                ", cant_mate=" + cant_mate +
                ", proveedor=" + proveedor +
                '}';
    }
}
