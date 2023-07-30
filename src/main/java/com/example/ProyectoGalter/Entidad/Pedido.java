package com.example.ProyectoGalter.Entidad;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Date;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pedido;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", nullable = false)
    @Fetch(FetchMode.JOIN)
    private Cliente cliente_ped;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codi_prod", referencedColumnName = "codi_prod", nullable = false)
    private Producto producto_ped;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codi_usuario", referencedColumnName = "codi_usuario", nullable = false)
    @Fetch(FetchMode.JOIN)
    private Usuario usuario_ped;

    @Column(nullable = false)
    private int tiempo_pedido;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_encargo;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_entrega;


    // Constructores

    public Pedido(Integer id_pedido, Cliente cliente_ped, Producto producto_ped, Usuario usuario_ped, int tiempo_pedido, Date fecha_encargo, Date fecha_entrega) {
        this.id_pedido = id_pedido;
        this.cliente_ped = cliente_ped;
        this.producto_ped = producto_ped;
        this.usuario_ped = usuario_ped;
        this.tiempo_pedido = tiempo_pedido;
        this.fecha_encargo = fecha_encargo;
        this.fecha_entrega = fecha_entrega;
    }

    public Pedido() {
    }


    // Metodos GET & SET


    public Integer getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getCliente_ped() {return cliente_ped.getNombre_cliente();}

    public void setCliente_ped(Cliente cliente_ped) {
        this.cliente_ped = cliente_ped;
    }

    public String getProducto_ped() {return producto_ped.getCodi_prod();}

    public void setProducto_ped(Producto producto_ped) {
        this.producto_ped = producto_ped;
    }

    public String getUsuario_ped() {return usuario_ped.getNombre_usuario();}

    public void setUsuario_ped(Usuario usuario_ped) {
        this.usuario_ped = usuario_ped;
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
                ", cliente=" + cliente_ped.getNombre_cliente() +
                ", producto=" + producto_ped.getCodi_prod() +
                ", usuario=" + usuario_ped.getNombre_usuario() +
                ", tiempo_pedido=" + tiempo_pedido +
                ", fecha_encargo=" + fecha_encargo +
                ", fecha_entrega=" + fecha_entrega +
                '}';
    }
}