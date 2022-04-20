package lt.vcs.finalproject.repository.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import lt.vcs.finalproject.Constants;
import lt.vcs.finalproject.repository.model.Product;

@Dao
public interface ProductDao {

    @Query("SELECT * FROM " + Constants.ENTITY_PRODUCTS_TABLE)
    List<Product> getAll();

    @Query("SELECT * FROM " + Constants.ENTITY_PRODUCTS_TABLE + " WHERE productId =:productId")
    Product getItem(int productId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProducts(List<Product> products);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProduct(Product product);

    @Delete
    void deleteProducts(List<Product> products);

    @Delete
    void deleteProduct(Product product);

    @Query("DELETE FROM " + Constants.ENTITY_PRODUCTS_TABLE+ " WHERE productId =:productId")
    void deleteItem(int productId);
}
