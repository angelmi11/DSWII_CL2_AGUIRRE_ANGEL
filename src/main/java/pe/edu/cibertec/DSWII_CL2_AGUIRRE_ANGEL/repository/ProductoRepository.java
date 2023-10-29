package pe.edu.cibertec.DSWII_CL2_AGUIRRE_ANGEL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DSWII_CL2_AGUIRRE_ANGEL.model.db.Producto;

import java.util.List;
@Repository
public interface ProductoRepository  extends JpaRepository<Producto, Integer> {
    List<Producto> findByProducto(String producto);

    @Query("SELECT p FROM Producto p WHERE p.cantidad > 10 AND p.cantidad < 100")
    List<Producto> findProductosEntre10y100();

    @Query(value = "SELECT * FROM producto WHERE YEAR(fechavencimiento) = 2024", nativeQuery = true)
    List<Producto> findProductosConVencimiento2024();
}
