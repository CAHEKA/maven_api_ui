package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Product {
    private Integer id;
    private String name;
    private String category;
    private Double price;
    private Double discount;
}
