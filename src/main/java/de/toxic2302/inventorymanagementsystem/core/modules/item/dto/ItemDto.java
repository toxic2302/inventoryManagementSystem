package de.toxic2302.inventorymanagementsystem.core.modules.item.dto;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record ItemDto(
    UUID id,
    @NotNull
    String name,
    @NotNull String brand,
    String serialNumber,
    String description,
    Boolean sold,
    Integer amount
) {
}
/**
 * DTO for {@link Item}/*
 *//*
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
}*/