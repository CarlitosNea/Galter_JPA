package com.example.ProyectoGalter.Repositorio;

import com.example.ProyectoGalter.Entidad.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Repo_Proveedor extends JpaRepository<Proveedor,String> {
}
