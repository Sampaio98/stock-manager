package com.group.stockmanager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "STOCK_STORAGE")
public class Stock {

    @EqualsAndHashCode.Include
    @Id
    @NotBlank(message = "The field 'id' must not be empty!")
    private String id;

    @NotBlank(message = "The field 'description' must not be empty!")
    private String description;
}
