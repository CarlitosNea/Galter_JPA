package com.example.ProyectoGalter.Entidad;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "pedido")
public class Pedido {
    //Creacion de columnas

    @Id
    @Column(unique = true,length = 10)
    private String id_pedido;

    @ManyToOne
    @JoinColumn(name = "cliente",referencedColumnName = "nombre_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "producto", referencedColumnName = "codi_prod")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "usuario",referencedColumnName = "nombre_usuario")
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


    // Creacion de constructores


    public Pedido(String id_pedido, Cliente cliente, Producto producto, Usuario usuario, int tiempo_pedido, Date fecha_encargo, Date fecha_entrega) {
        this.setId_pedido(id_pedido);
        this.setCliente(cliente);
        this.setProducto(producto);
        this.setUsuario(usuario);
        this.setTiempo_pedido(tiempo_pedido);
        this.setFecha_encargo(fecha_encargo);
        this.setFecha_entrega(fecha_entrega);
    }

    public Pedido() {
    }


    //Metodos GET & SET

    public String getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(String id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
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


    // To String


    @Override
    public String toString() {
        return "Pedido{" +
                "id_pedido='" + id_pedido + '\'' +
                ", cliente=" + cliente +
                ", producto=" + producto +
                ", usuario=" + usuario +
                ", tiempo_pedido=" + tiempo_pedido +
                ", fecha_encargo=" + fecha_encargo +
                ", fecha_entrega=" + fecha_entrega +
                '}';
    }
}
