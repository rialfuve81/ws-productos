package com.co.wsproductos.wsproductos.repository;

import com.co.wsproductos.wsproductos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
