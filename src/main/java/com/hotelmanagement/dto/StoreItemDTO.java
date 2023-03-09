package com.hotelmanagement.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link com.hotelmanagement.entity.Item} entity
 */
public class StoreItemDTO implements Serializable {
    @Size(max = 50)
    @NotNull
    private String name;
    @Size(max = 20)
    @NotNull
    private String category;
    @Size(max = 150)
    private String description;
    @NotNull
    private BigDecimal price;
    @Size(max = 300)
    @NotNull
    private String image;

    public StoreItemDTO() {
    }

    public StoreItemDTO(String name, String category, String description, BigDecimal price, String image) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreItemDTO entity = (StoreItemDTO) o;
        return Objects.equals(this.name, entity.name) &&
                Objects.equals(this.category, entity.category) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.price, entity.price) &&
                Objects.equals(this.image, entity.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, description, price, image);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "name = " + name + ", " +
                "category = " + category + ", " +
                "description = " + description + ", " +
                "price = " + price + ", " +
                "image = " + image + ")";
    }
}