package com.proyecto.ApiAlmacen.controller;

import com.proyecto.ApiAlmacen.entity.Almacen;
import com.proyecto.ApiAlmacen.service.AlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/almacen")
public class AlmacenController {
    @Autowired
    private AlmacenService almacenService;

    @GetMapping("/findAll/page/{page}/size/{size}")
    public ResponseEntity<Page<Almacen>> findAll(@PathVariable int page, @PathVariable int size){
        return new ResponseEntity<>(almacenService.findAll(page, size), HttpStatus.OK);
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<Almacen>> findAll(){
        return new ResponseEntity<>(almacenService.findAll(),
                HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Almacen> findById(@PathVariable Long id){
        return new ResponseEntity<>(almacenService.findById(id),
                HttpStatus.OK);
    }
    @GetMapping("/findByAlmacenName/{almacenName}")
    public ResponseEntity<Almacen> findByAlmacenName(@PathVariable String almacenName){
        return new ResponseEntity<>(almacenService.findByAlmacenName(almacenName),
                HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Almacen> add(@RequestBody Almacen almacen){
        return new ResponseEntity<>(almacenService.add(almacen),
                HttpStatus.OK) ;
    }
    @PutMapping("/update")
    public ResponseEntity<Almacen> update(@RequestBody Almacen almacen){
        return new ResponseEntity<>(almacenService.update(almacen),
                HttpStatus.OK) ;
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        almacenService.delete(id);
    }

}
