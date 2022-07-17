package com.san.tech.rent.mapper;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.List;

public class Mapper {
    private static MapperFactory FACTORY = new DefaultMapperFactory.Builder().build();
    private static MapperFacade FACADE = FACTORY.getMapperFacade();

    public static <E, D> D map(E source, Class<D> target){
        return source == null ? null : FACADE.map(source, target);
    }

    public static <E, D> List<D> listMap(List<E> source, Class<D> target){
        return source == null ? null : FACADE.mapAsList(source, target);
    }
}
