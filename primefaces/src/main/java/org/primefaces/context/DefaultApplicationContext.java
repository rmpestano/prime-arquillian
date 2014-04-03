/*
 * Copyright 2009-2013 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.context;

import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import org.primefaces.cache.CacheProvider;
import org.primefaces.cache.DefaultCacheProvider;

import org.primefaces.config.ConfigContainer;
import org.primefaces.util.Constants;

public class DefaultApplicationContext extends ApplicationContext {

	private ConfigContainer config;
	private ValidatorFactory validatorFactory;
    private CacheProvider cacheProvider;

    public DefaultApplicationContext(FacesContext context) {
    	this.config = new ConfigContainer(context);
    	
    	if (this.config.isBeanValidationAvailable()) {
    	    this.validatorFactory = Validation.buildDefaultValidatorFactory();
    	}
        
        String cacheProviderConfigValue = context.getExternalContext().getInitParameter(Constants.ContextParams.CACHE_PROVIDER);
        if(cacheProviderConfigValue == null) {
            cacheProvider = new DefaultCacheProvider();
        }
        else {
            try {
                cacheProvider = (CacheProvider) Class.forName(cacheProviderConfigValue).newInstance();
            } catch (ClassNotFoundException ex) {
                throw new FacesException(ex);
            } catch (InstantiationException ex) {
                throw new FacesException(ex);
            } catch (IllegalAccessException ex) {
                throw new FacesException(ex);
            }
        }
    }

	@Override
	public ConfigContainer getConfig() {
		return config;
	}

    @Override
    public ValidatorFactory getValidatorFactory() {
        return validatorFactory;
    }

    @Override
    public CacheProvider getCacheProvider() {
        return cacheProvider;
    }
}
