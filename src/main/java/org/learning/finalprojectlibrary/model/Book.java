package org.learning.finalprojectlibrary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

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
    @Size(max = 10000)
    private String description;
    @NotNull
    @DecimalMin(value = "1.00")
    @Column(nullable = false)
    private BigDecimal price;
    @OneToMany(mappedBy = "book")
    private List<SupplierBookPurchase> supplierPurchases;
    @OneToMany(mappedBy = "book")
    private List<ClientPurchase> clientPurchases;
    @ManyToMany(mappedBy = "bookList")
    @OnDelete(action = OnDeleteAction.CASCADE)
    List<Category> categoryList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getWarehouse() {
        int supplier = 0;
        int client = 0;
        for (SupplierBookPurchase supplierBookPurchase : supplierPurchases) {
            supplier += supplierBookPurchase.getAmount();
        }
        for (ClientPurchase clientPurchase : clientPurchases) {
            client += clientPurchase.getAmount();
        }
        return supplier - client;
    }

    public int getAmountPurchases() {
        int amount = 0;
        for (ClientPurchase clientPurchase : clientPurchases) {
            amount += clientPurchase.getAmount();
        }
        return amount;
    }

    public int getAmountPurchasesLastMonth() {
        LocalDate today = LocalDate.now();
        LocalDate oneMonthAgo = today.minusMonths(1);
        int amount = 0;
        for (ClientPurchase clientPurchase : clientPurchases) {
            if (clientPurchase.getDate().isAfter(oneMonthAgo)) {
                amount += clientPurchase.getAmount();
            }
        }
        return amount;

    }

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

    public List<SupplierBookPurchase> getSupplierPurchases() {
        return supplierPurchases;
    }

    public void setSupplierPurchases(List<SupplierBookPurchase> supplierPurchases) {
        this.supplierPurchases = supplierPurchases;
    }

    public List<ClientPurchase> getClientPurchases() {
        return clientPurchases;
    }

    public void setClientPurchases(List<ClientPurchase> clientPurchases) {
        this.clientPurchases = clientPurchases;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

}
