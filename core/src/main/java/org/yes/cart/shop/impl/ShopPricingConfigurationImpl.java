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

package org.yes.cart.shop.impl;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yes.cart.domain.entity.Shop;
import org.yes.cart.service.domain.ShopService;
import org.yes.cart.shoppingcart.PriceResolver;
import org.yes.cart.shoppingcart.PricingPolicyProvider;
import org.yes.cart.shoppingcart.TaxProvider;

import java.util.List;

/**
 * User: denispavlov
 * Date: 09/07/2017
 * Time: 16:47
 */
public class ShopPricingConfigurationImpl extends AbstractShopConfigurationImpl {

    private static final Logger LOG = LoggerFactory.getLogger(ShopPricingConfigurationImpl.class);

    private PricingPolicyProvider pricingPolicyProvider;
    private PriceResolver priceResolver;
    private TaxProvider taxProvider;

    public ShopPricingConfigurationImpl(final String shopCode, final ShopService shopService) {
        super(shopCode, shopService);
    }

    void registerCustomTaxProvider(final Shop shop, final List<Shop> subs) {
        if (taxProvider != null) {
            configureShop(shop.getCode(), taxProvider);
        }
    }

    void registerCustomPricingPolicyProvider(final Shop shop, final List<Shop> subs) {
        if (pricingPolicyProvider != null) {
            configureShop(shop.getCode(), pricingPolicyProvider);
        }
    }

    void registerCustomPriceResolver(final Shop shop, final List<Shop> subs) {
        if (priceResolver != null) {
            configureShop(shop.getShopId(), priceResolver);
            if (CollectionUtils.isNotEmpty(subs)) {
                for (final Shop sub : subs) {
                    configureShop(sub.getShopId(), priceResolver);
                }
            }
        }
    }

    /** {@inheritDoc} */
    protected void doConfigurations(final Shop shop, final List<Shop> subs) {
        this.registerCustomTaxProvider(shop, subs);
        this.registerCustomPricingPolicyProvider(shop, subs);
        this.registerCustomPriceResolver(shop, subs);
    }

    /**
     * Spring IoC.
     *
     * @param pricingPolicyProvider policy
     */
    public void setPricingPolicyProvider(final PricingPolicyProvider pricingPolicyProvider) {
        this.pricingPolicyProvider = pricingPolicyProvider;
    }

    /**
     * Spring IoC.
     *
     * @param priceResolver resolver
     */
    public void setPriceResolver(final PriceResolver priceResolver) {
        this.priceResolver = priceResolver;
    }

    /**
     * Spring IoC.
     *
     * @param taxProvider resolver
     */
    public void setTaxProvider(final TaxProvider taxProvider) {
        this.taxProvider = taxProvider;
    }

}
