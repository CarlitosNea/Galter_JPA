package com.example.ProyectoGalter.Repositorio;

import com.example.ProyectoGalter.Entidad.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo_User extends JpaRepository<User, String> {
    User findByEmail(String email);
}
