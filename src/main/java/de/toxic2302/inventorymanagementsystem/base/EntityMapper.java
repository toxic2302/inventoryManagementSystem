package de.toxic2302.inventorymanagementsystem.base;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.Collection;
import java.util.Optional;

public interface EntityMapper<D, E> {
    E toEntity(Optional<D> dto);
    D toDto(Optional<E> entity);

    E toEntity(D dto);
    D toDto(E entity);

    Collection<E> toEntityCollection(Collection<D> dto);
    Collection<D> toDtoCollection(Collection<E> entity);

    @Named("partialUpdate")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget E entity, D dto);
}
