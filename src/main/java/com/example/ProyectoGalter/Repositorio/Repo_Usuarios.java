package com.example.proyecto_galter.repocitorios;

import com.example.proyecto_galter.entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo_Usuarios extends JpaRepository<Usuario,String> {
}
