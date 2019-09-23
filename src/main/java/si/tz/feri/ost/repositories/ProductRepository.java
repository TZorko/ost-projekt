package si.tz.feri.ost.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import si.tz.feri.ost.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
