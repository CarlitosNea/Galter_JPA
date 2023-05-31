package com.example.proyecto_galter.repocitorios;

import com.example.proyecto_galter.entidad.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Repo_Cliente extends JpaRepository<Cliente,String> {
}
