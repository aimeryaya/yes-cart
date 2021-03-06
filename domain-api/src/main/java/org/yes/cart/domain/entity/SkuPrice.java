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

package org.yes.cart.domain.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * User: Igor Azarny iazarny@yahoo.com
 * Date: 07-May-2011
 * Time: 11:13:01
 * <p/>
 * Product sku prices per shop, currency and quantity of skus. Quantity of sku shows
 * what price per single sku if shopper gonna buy more that 1 item. Regular price - price without
 * any discounts and promotional. Sale price will be show in particular time frame or every time if
 * time frame is not present. Minimal price will be used in "name-your-price" pricing strategy.
 */
public interface SkuPrice extends Auditable, Taggable {

    /**
     * Get SKU code.
     *
     * @return sku
     */
    String getSkuCode();

    /**
     * Set SKU code.
     *
     * @param skuCode SKU code
     */
    void setSkuCode(String skuCode);

    /**
     * Get shop.
     *
     * @return {@link Shop}
     */
    Shop getShop();

    /**
     * Set shop
     *
     * @param shop {@link Shop}
     */
    void setShop(Shop shop);

    /**
     * Get currency code.
     *
     * @return currency code
     */
    String getCurrency();

    /**
     * set currency code.
     *
     * @param currency curr code
     */
    void setCurrency(String currency);

    /**
     * Get price quantity.
     *
     * @return quantity
     */
    BigDecimal getQuantity();

    /**
     * Set quantity.
     *
     * @param quantity quantity to set
     */
    void setQuantity(BigDecimal quantity);

    /**
     * Get regular/list price.
     *
     * @return regular price.
     */
    BigDecimal getRegularPrice();

    /**
     * Set regular price.
     *
     * @param regularPrice regular price.
     */
    void setRegularPrice(BigDecimal regularPrice);

    /**
     * Get sale price.
     *
     * @return sale price.
     */
    BigDecimal getSalePrice();

    /**
     * Get sale price for calculation.
     *
     * @return sale price for calculation.
     */
    BigDecimal getSalePriceForCalculation();

    /**
     * Set sale price.
     *
     * @param salePrice sale price.
     */
    void setSalePrice(BigDecimal salePrice);

    /**
     * Get minimal price to use in discount per day or name your price strategy.
     *
     * @return minimal price
     */
    BigDecimal getMinimalPrice();

    /**
     * Set minimal price
     *
     * @param minimalPrice minimal price
     */
    void setMinimalPrice(BigDecimal minimalPrice);

    /**
     * Set sale from date.
     *
     * @return sale from date.
     */
    Date getSalefrom();

    /**
     * Get sale from date.
     *
     * @param salefrom sale from date.
     */
    void setSalefrom(Date salefrom);

    /**
     * Get sale to date.
     *
     * @return sale to date.
     */
    Date getSaleto();

    /**
     * Set sale to date
     *
     * @param saleto sale to date
     */
    void setSaleto(Date saleto);

    /**
     * Primary key.
     *
     * @return pk value
     */
    long getSkuPriceId();

    /**
     * Set pk value
     *
     * @param skuPriceId pk value.
     */
    void setSkuPriceId(long skuPriceId);

    /**
     * Tag allows classification of price entries. E.g. It is hard to understand
     * price with salefrom/to: 01/12/12 - 25/12/12, but it is easier if it has a tag
     * Christmas sales 2012.
     *
     * @return tag or null.
     */
    String getTag();

    /**
     * Set tag value.
     *
     * @param tag price tag
     */
    void setTag(String tag);


    /**
     * Get price type. Price type defines customer segment that has access to this price.
     *
     * @return price type
     */
    String getPricingPolicy();

    /**
     * Set price type. Price type defines customer segment that has access to this price.
     *
     * @param pricingPolicy price type
     */
    void setPricingPolicy(String pricingPolicy);

    /**
     * Get reference for this price list.
     *
     * @return reference
     */
    String getRef();

    /**
     * Set reference for this price list
     *
     * @param ref reference (e.g. contract number or special price mark)
     */
    void setRef(String ref);

}
