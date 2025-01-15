package de.toxic2302.inventorymanagementsystem.base.mapper;

import java.util.List;
import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.Collection;
import java.util.Optional;
import org.springframework.data.domain.Page;

public interface BaseMapper<D, E> {
    E toEntity(Optional<D> dto);
    D toDto(Optional<E> entity);

    E toEntity(D dto);
    D toDto(E entity);

    Collection<E> toEntityCollection(Collection<D> dto);
    Collection<D> toDtoCollection(Collection<E> entity);

    List<E> toEntityList(List<D> dto);
    List<D> toDtoList(List<E> entity);

    // workarounds
    default Page<D> toDtoPage(Page<E> entity) {
        return entity.map(this::toDto);
    }

    default Optional<D> toDtoOptional(Optional<E> entity) {
        return entity.map(this::toDto);
    }

    @Named("partialUpdate")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget E entity, D dto);
}
