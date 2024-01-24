package org.learning.finalprojectlibrary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "ClientPurchases")
public class ClientPurchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "cant be null")
    @PastOrPresent
    private LocalDate data;
    @NotNull(message = "cant be null")
    private int amount;
    @Column(nullable = false)
    @DecimalMin(value = "1.00", message = "Price can't be lower than 1.00")
    @NotNull(message = "Price must not be empty")
    private BigDecimal price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}