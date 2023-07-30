package com.example.ProyectoGalter.Entidad;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "proveedor")
public class Proveedor {


    // Creacion de columnas
    @Id
    @Column(unique = true,length = 50)
    private String nombre_proveedor;

    @Column(unique = true,length = 10)
    private String telefono_proveedor;


    @OneToMany(mappedBy = "proveedor_mate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Material> material;



    // Creacion de constructores

    public Proveedor() {
    }

    public Proveedor(String nombre_proveedor, String telefono_proveedor, Set<Material> material) {
        this.nombre_proveedor = nombre_proveedor;
        this.telefono_proveedor = telefono_proveedor;
        this.material = material;
    }


    // Metodos GET & SET

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public String getTelefono_proveedor() {
        return telefono_proveedor;
    }

    public void setTelefono_proveedor(String telefono_proveedor) {
        this.telefono_proveedor = telefono_proveedor;
    }

    public Set<Material> getMaterial() {
        return material;
    }

    public void setMaterial(Set<Material> material) {
        this.material = material;
    }

    // To String

    @Override
    public String toString() {
        return "Proveedor{" +
                "nombre_proveedor=" + nombre_proveedor +
                ", telefono_proveedor=" + telefono_proveedor +
                ", materiales=" + material +
                '}';
    }
}
