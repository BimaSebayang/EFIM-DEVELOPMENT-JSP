package id.co.roxas.efim.service;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public abstract class ConfigurationService {

	protected MapperFacade mapperFacade = new DefaultMapperFactory.Builder().build().getMapperFacade();
}
