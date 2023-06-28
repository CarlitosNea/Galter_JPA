package com.example.ProyectoGalter.Entidad;

import jakarta.persistence.*;

import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @Column(unique = true, length = 10)
    private String id_pedido;

    @ManyToOne
    @JoinColumn(name="cliente",referencedColumnName = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "producto", referencedColumnName = "codi_prod")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "codi_usuario")
    private Usuario usuario;

    @Column(nullable = false)
    private int tiempo_pedido;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_encargo;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_entrega;


    // Constructores

    public Pedido(String id_pedido, Cliente cliente, Producto producto, Usuario usuario, int tiempo_pedido, Date fecha_encargo, Date fecha_entrega) {
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


    // Metodos GET & SET


    public String getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(String id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getCliente() {
        if (cliente != null) {
            return cliente.getId_cliente();
        }
        return null;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getProducto() {
        if (producto != null) {
            return producto.getCodi_prod();
        }
        return null;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getUsuario() {
        if (usuario != null) {
            return usuario.getCodi_usuario();
        }
        return null;
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


    //To String


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