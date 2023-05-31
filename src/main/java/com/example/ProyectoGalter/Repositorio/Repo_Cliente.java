package com.example.ProyectoGalter.Repositorio;

import com.example.ProyectoGalter.Entidad.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Repo_Cliente extends JpaRepository<Cliente,String> {
}
