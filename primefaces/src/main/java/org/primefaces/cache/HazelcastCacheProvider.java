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
package org.primefaces.cache;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class HazelcastCacheProvider implements CacheProvider {

    private HazelcastInstance cache;
    
    public HazelcastCacheProvider() {
        Config config = new Config();
        cache = Hazelcast.newHazelcastInstance(config);
    }
    
    public Object get(String region, String key) {
        IMap<String,Object> cacheRegion = getRegion(region);
        
        return cacheRegion.get(key);
    }

    public void put(String region, String key, Object object) {
        IMap<String,Object> cacheRegion = getRegion(region);
        
        cacheRegion.put(key, object);
    }

    public void remove(String region, String key) {
        IMap<String,Object> cacheRegion = getRegion(region);
        
        cacheRegion.remove(key);
    }

    public void clear() {
        
    }
    
    private IMap<String,Object> getRegion(String name) {
        IMap<String,Object> region = cache.getMap(name);   
        
        return region;
    }
}
