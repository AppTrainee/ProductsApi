// Mydata.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package com.example.productsapi;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Mydata {
    @SerializedName("total")
    @Expose
    private String  total;
    @SerializedName("limit")
    @Expose
    private String  limit;
    @SerializedName("skip")
    @Expose
    private String  skip;

    @SerializedName("products")
    @Expose
    private List<Product> products;

    public Mydata(String total, String limit, String skip, List<Product> products) {
        this.total = total;
        this.limit = limit;
        this.skip = skip;
        this.products = products;
    }

    public String  getTotal() { return (String) total; }

    public void setTotal(String  value) { this.total = value; }

    public String  getLimit() { return (String) limit; }
    public void setLimit(String value) { this.limit = value; }

    public String getSkip() { return skip; }
    public void setSkip(String value) { this.skip = value; }

    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> value) { this.products = value; }
}

// Product.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

class Product {
    @SerializedName("discountPercentage")
    @Expose
    private String discountPercentage;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("images")
    @Expose
    private List<String> images;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("stock")
    @Expose
    private String stock;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("brand")
    @Expose
    private String brand;

    public Product(String discountPercentage, String thumbnail,
                   //List<String> images,
                   String price, String rating, String description, String id, String title, String stock,
                   String category, String brand) {
        this.discountPercentage = discountPercentage;
        this.thumbnail = thumbnail;
     //   this.images = images;
        this.price = price;
        this.rating = rating;
        this.description = description;
        this.id = id;
        this.title = title;
        this.stock = stock;
        this.category = category;
        this.brand = brand;
    }

    public String getDiscountPercentage() { return discountPercentage; }
    public void setDiscountPercentage(String value) { this.discountPercentage = value; }

    public String getThumbnail() { return thumbnail; }
    public void setThumbnail(String value) { this.thumbnail = value; }

    public List<String> getImages() { return images; }
    public void setImages(List<String> value) { this.images = value; }

    public String getPrice() { return price; }
    public void setPrice(String value) { this.price = value; }

    public String getRating() { return rating; }
    public void setRating(String value) { this.rating = value; }

    public String getDescription() { return description; }
    public void setDescription(String value) { this.description = value; }

    public String getid() { return id; }
    public void setid(String value) { this.id = value; }

    public String getTitle() { return title; }
    public void setTitle(String value) { this.title = value; }

    public String  getStock() { return stock; }
    public void setStock(String value) { this.stock = value; }

    public String getCategory() { return category; }
    public void setCategory(String value) { this.category = value; }

    public String getBrand() { return brand; }
    public void setBrand(String value) { this.brand = value; }
}
