package id.co.roxas.efim.service;

import id.co.roxas.efim.lib.CommonConstant;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public abstract class ConfigurationService extends CommonConstant{

	protected MapperFacade mapperFacade = new DefaultMapperFactory.Builder().build().getMapperFacade();
}
