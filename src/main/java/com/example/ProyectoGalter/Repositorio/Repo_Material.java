package com.example.ProyectoGalter.Repositorio;

import com.example.ProyectoGalter.Entidad.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo_Material extends JpaRepository<Material,String> {

}
