package pe.edu.cibertec.DSWII_CL2_AGUIRRE_ANGEL.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DSWII_CL2_AGUIRRE_ANGEL.model.db.Producto;
import pe.edu.cibertec.DSWII_CL2_AGUIRRE_ANGEL.repository.ProductoRepository;
import pe.edu.cibertec.DSWII_CL2_AGUIRRE_ANGEL.service.ProductoService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/producto")
public class ProductoController {

    private  ProductoService productoService;
    private ProductoRepository productoRepository;


    @GetMapping("/productos")
    public Iterable<Producto> listarProductos() {
        return productoService.obtenerTodosLosProductos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable Integer id) {
        Optional<Producto> producto = productoService.obtenerProductoPorId(id);
        if (producto.isPresent()) {
            return new ResponseEntity<>(producto.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoService.guardarProducto(producto);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Integer id , @RequestBody Producto producto) {
        producto.setIdproducto(id);
        Producto productoActualizado = productoService.guardarProducto(producto);
        return new ResponseEntity<>(productoActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable int id) {
        productoService.eliminarProducto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/nombre")
    public List<Producto> buscarPorNombre(@RequestParam String nombre) {
        return productoRepository.findByProducto(nombre);
    }

    @GetMapping("/cantidad")
    public List<Producto> buscarProductosEntre10y100() {
        return productoRepository.findProductosEntre10y100();
    }

    @GetMapping("/vencimiento2024")
    public List<Producto> buscarProductosConVencimiento2024() {
        return productoRepository.findProductosConVencimiento2024();
    }
}
