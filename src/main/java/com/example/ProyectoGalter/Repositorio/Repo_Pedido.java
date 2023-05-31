package com.example.ProyectoGalter.Repositorio;

import com.example.ProyectoGalter.Entidad.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo_Pedido extends JpaRepository<Pedido, String> {

}
