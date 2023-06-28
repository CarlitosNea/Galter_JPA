package com.example.ProyectoGalter.Entidad;

import jakarta.persistence.*;
@Entity
@Table(name = "producto")
public class Producto {

    // Creacion de columnas
    @Id
    @Column(unique = true,length = 10)
    private String codi_prod;

    @Column(unique = true,length = 100)
    private String nomb_prod;

    @Column(nullable = false)
    private int tiempo_prod;

    @Column(nullable = false)
    private Double long_prod;

    @ManyToOne
    @JoinColumn(name = "material_prod",referencedColumnName = "codi_mate")
    private Material material_prod;

    @Column(nullable = false)
    private int prec_prod;


    @ManyToOne
    @JoinColumn(referencedColumnName = "codi_prod")
    private Producto producto;


    // Generacion de constructores
    public Producto(String codi_prod, String nomb_prod, int tiempo_prod, Double long_prod, Material material_prod, int prec_prod) {
        this.codi_prod = codi_prod;
        this.nomb_prod = nomb_prod;
        this.tiempo_prod = tiempo_prod;
        this.long_prod = long_prod;
        this.material_prod = material_prod;
        this.prec_prod = prec_prod;
    }

    public Producto() {
    }


    // Metodos GET & SET
    public String getCodi_prod() {
        return codi_prod;
    }

    public void setCodi_prod(String codi_prod) {
        this.codi_prod = codi_prod;
    }

    public String getNomb_prod() {
        return nomb_prod;
    }

    public void setNomb_prod(String nomb_prod) {
        this.nomb_prod = nomb_prod;
    }

    public int getTiempo_prod() {
        return tiempo_prod;
    }

    public void setTiempo_prod(int tiempo_prod) {
        this.tiempo_prod = tiempo_prod;
    }

    public Double getLong_prod() {
        return long_prod;
    }

    public void setLong_prod(Double long_prod) {
        this.long_prod = long_prod;
    }

    public String getMaterial_prod() {
        if (material_prod != null) {
            return material_prod.getCodi_mate();
        }
        return null;

    }

    public void setMaterial_prod(Material material_prod) {
        this.material_prod = material_prod;
    }

    public int getPrec_prod() {
        return prec_prod;
    }

    public void setPrec_prod(int prec_prod) {
        this.prec_prod = prec_prod;
    }


    // To String
    @Override
    public String toString() {
        return "Producto{" +
                "codi_prod='" + codi_prod + '\'' +
                ", nomb_prod='" + nomb_prod + '\'' +
                ", tiempo_prod=" + tiempo_prod +
                ", long_prod=" + long_prod +
                ", material_prod=" + material_prod +
                ", prec_prod=" + prec_prod +
                '}';
    }
}
