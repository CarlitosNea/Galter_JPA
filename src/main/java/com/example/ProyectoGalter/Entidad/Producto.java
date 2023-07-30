package com.example.ProyectoGalter.Entidad;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Set;

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
    private float long_prod;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codi_mate",referencedColumnName = "codi_mate", nullable = false)
    @Fetch(FetchMode.JOIN)
    private Material material_prod;

    @Column(nullable = false)
    private int prec_prod;


    @OneToMany(mappedBy = "producto_ped", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Pedido> pedido;


    // Generacion de constructores
    public Producto(String codi_prod, String nomb_prod, int tiempo_prod, float long_prod, Material material_prod, int prec_prod, Set<Pedido> pedido) {
        this.codi_prod = codi_prod;
        this.nomb_prod = nomb_prod;
        this.tiempo_prod = tiempo_prod;
        this.long_prod = long_prod;
        this.material_prod = material_prod;
        this.prec_prod = prec_prod;
        this.pedido = pedido;
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

    public float getLong_prod() {
        return long_prod;
    }

    public void setLong_prod(float long_prod) {
        this.long_prod = long_prod;
    }

    public String getMaterial_prod() {return material_prod.getCodi_mate();}

    public void setMaterial_prod(Material material_prod) {
        this.material_prod = material_prod;
    }

    public int getPrec_prod() {
        return prec_prod;
    }

    public void setPrec_prod(int prec_prod) {
        this.prec_prod = prec_prod;
    }

    public Set<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(Set<Pedido> pedido) {
        this.pedido = pedido;
    }


    // To String
    @Override
    public String toString() {
        return "Producto{" +
                "codi_prod='" + codi_prod + '\'' +
                ", nomb_prod='" + nomb_prod + '\'' +
                ", tiempo_prod=" + tiempo_prod +
                ", long_prod=" + long_prod +
                ", material_prod=" + material_prod.getCodi_mate() +
                ", prec_prod=" + prec_prod +
                ", pedidos=" + pedido +
                '}';
    }
}
