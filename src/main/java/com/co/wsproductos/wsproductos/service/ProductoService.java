package com.co.wsproductos.wsproductos.service;

import com.co.wsproductos.wsproductos.exception.ResourceNotFoundException;
import com.co.wsproductos.wsproductos.model.Producto;
import com.co.wsproductos.wsproductos.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Producto> obtenerTodos() {
        return repository.findAll();
    }

    public Producto obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));
    }

    public Producto crear(Producto producto) {
        return repository.save(producto);
    }

    public Producto actualizar(Long id, Producto productoActualizado) {

        Producto producto = obtenerPorId(id);

        producto.setNombre(productoActualizado.getNombre());
        producto.setDescripcion(productoActualizado.getDescripcion());
        producto.setPrecio(productoActualizado.getPrecio());

        return repository.save(producto);
    }

    public void eliminar(Long id) {
        Producto producto = obtenerPorId(id);
        repository.delete(producto);
    }
}
