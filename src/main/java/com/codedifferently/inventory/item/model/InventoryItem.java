package com.codedifferently.inventory.item.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;





@Entity // JPA to save to the database
@NoArgsConstructor // No-argument constructor
@RequiredArgsConstructor // Constructor with required (non-null) fields
@Data // Generates getters, setters, equals, hashCode, toString
public class InventoryItem {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private int quantity;

    @NonNull
    private String location;

    @NonNull
    private String lockerCombo;

    @Override
    public String toString() {
        return String.format("Item[id=%d, name=%s, quantity=%d, location=%s, lockerCombo=%s]",
                id, name, quantity, location, lockerCombo);
    }
}