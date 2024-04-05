package de.toxic2302.inventorymanagementsystem.core.modules.item.dto;

import de.toxic2302.inventorymanagementsystem.core.modules.item.entity.Item;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link Item}
 */
@Value
public class ItemDto implements Serializable {
    UUID id;
    @NotNull
    String name;
    @NotNull
    String brand;
    String serialNumber;
    String description;
    Boolean sold;
}