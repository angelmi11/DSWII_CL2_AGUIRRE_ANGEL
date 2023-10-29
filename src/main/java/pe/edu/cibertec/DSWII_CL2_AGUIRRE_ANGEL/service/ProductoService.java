package pe.edu.cibertec.DSWII_CL2_AGUIRRE_ANGEL.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_CL2_AGUIRRE_ANGEL.model.db.Producto;
import pe.edu.cibertec.DSWII_CL2_AGUIRRE_ANGEL.repository.ProductoRepository;

import java.util.Optional;
@Service
@AllArgsConstructor
public class ProductoService {
    private  ProductoRepository productoRepository;

    public Optional<Producto> obtenerProductoPorId(int id) {
        return productoRepository.findById(id);
    }

    public Iterable<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public void eliminarProducto(int id) {
        productoRepository.deleteById(id);
    }
}
