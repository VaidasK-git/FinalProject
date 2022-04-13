package lt.vcs.finalproject.repository;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lt.vcs.finalproject.Constants;

@Entity(tableName = Constants.ENTITY_PRODUCTS_TABLE)
public class Product {

    @PrimaryKey(autoGenerate = true)
    private int productId;

    @ColumnInfo(name = "productGroup")
    private String productGroup;

    @ColumnInfo(name = "productManufacturer")
    private String productManufacturer;

    @ColumnInfo(name = "productName")
    private String productName;

    public Product(String productGroup, String productManufacturer, String productName) {
        this.productGroup = productGroup;
        this.productManufacturer = productManufacturer;
        this.productName = productName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(String productGroup) {
        this.productGroup = productGroup;
    }

    public String getProductManufacturer() {
        return productManufacturer;
    }

    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
