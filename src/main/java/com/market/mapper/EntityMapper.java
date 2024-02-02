package com.market.mapper;


import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EntityMapper<D,E>{
    D toDTO(E e);
    E toEntity(D d);
    List<D> toDTOs(List<E> es);
    List<E> toEntities(List<D> ds);
}