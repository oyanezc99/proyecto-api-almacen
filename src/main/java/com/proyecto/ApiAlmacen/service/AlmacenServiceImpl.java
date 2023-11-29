package com.proyecto.ApiAlmacen.service;

import com.proyecto.ApiAlmacen.dao.AlmacenRepository;
import com.proyecto.ApiAlmacen.entity.Almacen;
import com.proyecto.ApiAlmacen.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlmacenServiceImpl implements AlmacenService{
    @Autowired
    private AlmacenRepository almacenRepository;

    @Override
    public List<Almacen> findAll() {
        return almacenRepository.findAll();
    }

    @Override
    public Page<Almacen> findAll(int page, int size) {
        return almacenRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Almacen findById(Long id) {
        var message = "Almacen with id =" + id.toString() + "" + "Not Found";
        return almacenRepository.findById(id)
                .orElseThrow(
                        ()-> new EntityNotFoundException(message)
                );
    }
    @Override
    public Almacen findByAlmacenName(String nombreAlm) {
        return almacenRepository.findByAlmacenName(nombreAlm);
    }

    @Override
    public Almacen add(Almacen product) {
        return almacenRepository.save(product);
    }

    @Override
    public Almacen update(Almacen almacen) {
        var almacenDB = almacenRepository.findById(almacen.getId()).get();
        almacenDB.setAlmacenName(almacen.getAlmacenName());
        almacenDB.setCodAlm(almacen.getCodAlm());
        almacenDB.setUbicacionAlm(almacen.getUbicacionAlm());
        return almacenRepository.save(almacenDB);
    }

    @Override
    public void delete(Long id) {
        var almacenDB = almacenRepository.findById(id).get();
        almacenRepository.delete(almacenDB);
    }

}
