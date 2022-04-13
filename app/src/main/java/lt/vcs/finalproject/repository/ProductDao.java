package lt.vcs.finalproject.repository;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import lt.vcs.finalproject.Constants;

@Dao
public interface ProductDao {

//    @Query("SELECT * FROM " + Constants.ENTITY_PRODUCTS_TABLE)
//    List<Product> getAll();
//
//    @Query("SELECT * FROM " + Constants.ENTITY_PRODUCTS_TABLE + " WHERE productManufacturer =:productManufacturer")
//    Customer getItem(String productManufacturer);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProducts(List<Product> customers);

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    void insertProduct(Product product);
//
//    @Delete
//    void deleteProducts(List<Product> products);
//
//    @Delete
//    void deleteProduct(Product product);
//
//    @Query("DELETE FROM " + Constants.ENTITY_PRODUCTS_TABLE+ " WHERE productManufacturer =:productManufacturer")
//    void deleteItem(String productManufacturer);
}
