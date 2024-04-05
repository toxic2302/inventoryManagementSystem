package de.toxic2302.inventorymanagementsystem.core.modules.item.mapper;

import de.toxic2302.inventorymanagementsystem.base.EntityMapper;
import de.toxic2302.inventorymanagementsystem.core.modules.item.entity.Item;
import de.toxic2302.inventorymanagementsystem.core.modules.item.dto.ItemDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ItemMapper extends EntityMapper<ItemDto, Item> {
}