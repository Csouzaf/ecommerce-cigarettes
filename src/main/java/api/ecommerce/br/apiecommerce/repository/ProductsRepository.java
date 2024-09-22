package api.ecommerce.br.apiecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.ecommerce.br.apiecommerce.model.Product;
import api.ecommerce.br.apiecommerce.model.UserModel;
import java.util.List;


@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {
    UserModel findByUserModelId(Long id);

    Product findByQuantityProducts(Long quantityProduct);
}
