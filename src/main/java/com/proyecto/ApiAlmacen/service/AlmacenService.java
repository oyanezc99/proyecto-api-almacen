package com.proyecto.ApiAlmacen.service;

import com.proyecto.ApiAlmacen.entity.Almacen;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import java.util.List;

public interface AlmacenService {
    public List<Almacen> findAll();
    public Page<Almacen> findAll(int page, int size);
    public Almacen findById(Long id);
    public Almacen findByAlmacenName(String almacenName);
    public Almacen add(Almacen product);
    public Almacen update(Almacen product);
    public void delete(Long id);
}
