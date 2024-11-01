package com.example.ProyectoGalter.Repositorio;

import com.example.ProyectoGalter.Entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo_Usuarios extends JpaRepository<Usuario,String> {
    Usuario findByCorreoUsuario(String correoUsuario);
}
