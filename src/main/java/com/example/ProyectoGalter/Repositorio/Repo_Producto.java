package com.example.ProyectoGalter.Repositorio;

import com.example.ProyectoGalter.Entidad.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo_Producto extends JpaRepository<Producto,String>{
}
