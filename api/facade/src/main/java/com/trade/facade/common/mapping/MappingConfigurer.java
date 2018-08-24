package com.trade.facade.common.mapping;

import ma.glasnost.orika.MapperFactory;

public interface MappingConfigurer {
    void configure(MapperFactory factory);
}