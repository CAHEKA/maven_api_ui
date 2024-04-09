package dto.request;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class Card {
    private Integer product_id;
    private Integer quantity;
}
