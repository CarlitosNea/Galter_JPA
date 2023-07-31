package com.example.ProyectoGalter.Entidad;


import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cliente")
public class Cliente {

    // Creacion de columnas
    @Id
    @Column(unique = true)
    private String id_cliente;

    @Column(unique = true, length = 50)
    private String nombre_cliente;

    @Column(unique = true, length = 15)
    private String telefono_cliente;

    @Column(unique = true, length = 50)
    private String representante_cliente;

    @Column(unique = true, length = 50)
    private String direccion;

    @OneToMany(mappedBy = "cliente_ped", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Pedido> pedido;


    public Cliente(String id_cliente, String nombre_cliente, String telefono_cliente, String representante_cliente, String direccion, Set<Pedido> pedido) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.telefono_cliente = telefono_cliente;
        this.representante_cliente = representante_cliente;
        this.direccion = direccion;
        this.pedido = pedido;
    }


    public Cliente() {
    }


    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getTelefono_cliente() {
        return telefono_cliente;
    }

    public void setTelefono_cliente(String telefono_cliente) {
        this.telefono_cliente = telefono_cliente;
    }

    public String getRepresentante_cliente() {
        return representante_cliente;
    }

    public void setRepresentante_cliente(String representante_cliente) {
        this.representante_cliente = representante_cliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Set<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(Set<Pedido> pedido) {
        this.pedido = pedido;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "id_cliente=" + id_cliente +
                ", nombre_cliente='" + nombre_cliente + '\'' +
                ", telefono_cliente='" + telefono_cliente + '\'' +
                ", representante_cliente='" + representante_cliente + '\'' +
                ", direccion='" + direccion + '\'' +
                ", pedidos=" + pedido +
                '}';
    }
}
