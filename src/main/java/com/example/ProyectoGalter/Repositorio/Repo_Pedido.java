package com.example.proyecto_galter.repocitorios;


import com.example.proyecto_galter.entidad.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo_Pedido extends JpaRepository<Pedido, String> {

}
