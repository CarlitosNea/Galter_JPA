package com.example.ProyectoGalter.Entidad;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @Column(nullable = false)
    private int id_pedido;

    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "id_cliente")
    private Pedido cliente;


    @ManyToOne
    @JoinColumn(name = "producto", referencedColumnName = "codi_prod")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "codi_usuario")
    private Usuario usuario;


    @Column(nullable = false)
    private int tiempo_pedido;

    @Temporal(TemporalType.DATE)
    @Column(unique = true)
    private Date fecha_encargo;

    @Temporal(TemporalType.DATE)
    @Column(unique = true)
    private Date fecha_entrega;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id_pedido")
    private Pedido pedido;


    public Pedido(int id_pedido, Pedido cliente, Producto producto, Usuario usuario, int tiempo_pedido, Date fecha_encargo, Date fecha_entrega) {
        this.id_pedido = id_pedido;
        this.cliente = cliente;
        this.producto = producto;
        this.usuario = usuario;
        this.tiempo_pedido = tiempo_pedido;
        this.fecha_encargo = fecha_encargo;
        this.fecha_entrega = fecha_entrega;
    }

    public Pedido() {
    }


    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Pedido getCliente() {
        return cliente;
    }

    public void setCliente(Pedido cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getTiempo_pedido() {
        return tiempo_pedido;
    }

    public void setTiempo_pedido(int tiempo_pedido) {
        this.tiempo_pedido = tiempo_pedido;
    }

    public Date getFecha_encargo() {
        return fecha_encargo;
    }

    public void setFecha_encargo(Date fecha_encargo) {
        this.fecha_encargo = fecha_encargo;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }


    @Override
    public String toString() {
        return "Pedido{" +
                "id_pedido=" + id_pedido +
                ", cliente=" + cliente +
                ", producto=" + producto +
                ", usuario=" + usuario +
                ", tiempo_pedido=" + tiempo_pedido +
                ", fecha_encargo=" + fecha_encargo +
                ", fecha_entrega=" + fecha_entrega +
                '}';
    }
}
