package com.example.proyecto_galter.entidad;

import javax.persistence.*;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @Column(unique = true, length = 10)
    private String id_pedido;

    @Column(unique = true, length = 100)
    private String cliente;


    @Column(unique = true, length = 100)
    private String producto;

    @Column(unique = true, length = 100)
    private String usuario;


    @Column(unique = false)
    private int tiempo_pedido;

    @Column(unique = false)
    private String fecha_encargo;


    @Column(unique = false)
    private String fecha_entrega;

    @ManyToOne
    @JoinColumn(name = "client", referencedColumnName = "id_cliente")
    private Pedido client;


    public Pedido(String id_pedido, String cliente, String producto, String usuario, int tiempo_pedido, String fecha_encargo, String fecha_entrega, Pedido client) {
        this.id_pedido = id_pedido;
        this.cliente = cliente;
        this.producto = producto;
        this.usuario = usuario;
        this.tiempo_pedido = tiempo_pedido;
        this.fecha_encargo = fecha_encargo;
        this.fecha_entrega = fecha_entrega;
        this.client = client;
    }

    public Pedido() {
    }


    public String getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(String id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getTiempo_pedido() {
        return tiempo_pedido;
    }

    public void setTiempo_pedido(int tiempo_pedido) {
        this.tiempo_pedido = tiempo_pedido;
    }

    public String getFecha_encargo() {
        return fecha_encargo;
    }

    public void setFecha_encargo(String fecha_encargo) {
        this.fecha_encargo = fecha_encargo;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public Pedido getClient() {
        return client;
    }

    public void setClient(Pedido client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id_pedido='" + id_pedido + '\'' +
                ", cliente='" + cliente + '\'' +
                ", producto='" + producto + '\'' +
                ", usuario='" + usuario + '\'' +
                ", tiempo_pedido=" + tiempo_pedido +
                ", fecha_encargo=" + fecha_encargo +
                ", fecha_entrega=" + fecha_entrega +
                ", cliente=" + cliente +
                '}';
    }
}
