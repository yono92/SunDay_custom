package com.sunday.sundaycustom.model;

import com.sunday.sundaycustom.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customizations")
public class Customization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customization_id")
    private Integer customizationId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "customization_name")
    private String customizationName;

    @Column(name = "additional_cost")
    private BigDecimal additionalCost;

    private String description;
}
