package org.learning.finalprojectlibrary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Lob
    private String photo;
    @NotEmpty
    @Column(nullable = false)
    private String title;
    @Lob
    private String description;
    @NotNull
    @DecimalMin(value = "1.00")
    @Column(nullable = false)
    private BigDecimal price;
    @OneToMany(mappedBy = "bookId")
    private List<SupplierBookPurchase> supplierBookPurchaseList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<SupplierBookPurchase> getSupplierBookPurchaseList() {
        return supplierBookPurchaseList;
    }

    public void setSupplierBookPurchaseList(List<SupplierBookPurchase> supplierBookPurchaseList) {
        this.supplierBookPurchaseList = supplierBookPurchaseList;
    }
}
