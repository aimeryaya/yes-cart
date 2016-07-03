/*
 * Copyright 2009 Denys Pavlov, Igor Azarnyi
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.yes.cart.service.domain.impl;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.yes.cart.dao.GenericDAO;
import org.yes.cart.domain.entity.Carrier;
import org.yes.cart.service.domain.CarrierService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
* User: Igor Azarny iazarny@yahoo.com
 * Date: 09-May-2011
 * Time: 14:12:54
 */
public class CarrierServiceImpl extends BaseGenericServiceImpl<Carrier> implements CarrierService {

    /**
     * Construct service.
     * @param genericDao  doa to use.
     */
    public CarrierServiceImpl(final GenericDAO<Carrier, Long> genericDao) {
        super(genericDao);
    }

    /**
     * {@inheritDoc}
     */
    public List<Carrier> findCarriersByShopId(final long shopId) {
        final List<Carrier> rez  = getGenericDao().findByNamedQuery("CARRIER.BY.SHOPID", shopId);
        return rez;
    }

    /**
     * {@inheritDoc}
     */
    @Cacheable("carrierService-getCarriersByShopIdAndCurrency")
    public List<Carrier> getCarriersByShopId(final long shopId) {
        // This method must be READONLY transaction since we are modifying the list of SLA
        final List<Carrier> rez  = findCarriersByShopId(shopId);
        if (CollectionUtils.isEmpty(rez)) {
            return Collections.emptyList();
        }
        return new ArrayList<Carrier>(rez);
    }

    /** {@inheritDoc} */
    @CacheEvict(value = {
            "carrierService-getCarriersByShopIdAndCurrency"
    }, allEntries = true)
    public Carrier create(final Carrier instance) {
        return super.create(instance);
    }

    /** {@inheritDoc} */
    @CacheEvict(value = {
            "carrierService-getCarriersByShopIdAndCurrency"
    }, allEntries = true)
    public Carrier update(final Carrier instance) {
        return super.update(instance);
    }

    /** {@inheritDoc} */
    @CacheEvict(value = {
            "carrierService-getCarriersByShopIdAndCurrency"
    }, allEntries = true)
    public void delete(final Carrier instance) {
        super.delete(instance);
    }
}
