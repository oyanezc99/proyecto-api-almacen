package com.proyecto.ApiAlmacen.dao;

import com.proyecto.ApiAlmacen.entity.Almacen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlmacenRepository extends JpaRepository<Almacen, Long> {
    Almacen findByAlmacenName(String almacenName);
}
