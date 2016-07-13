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

package org.yes.cart.web.support.service;

import org.yes.cart.domain.entity.Category;
import org.yes.cart.domain.misc.Pair;

import java.util.Date;
import java.util.List;

/**
 * User: denispavlov
 * Date: 20/11/2014
 * Time: 00:06
 */
public interface CategoryServiceFacade {

    /**
     * Get the category parent ID for given shop.
     *
     * @param shopId shop id
     * @param categoryId given category PK
     * @return parent ID (or symlink parent)
     */
    Long getCategoryParentId(long categoryId, long shopId);

    /**
     * Get category if it belongs to given shop.
     *
     * @param categoryId category id
     * @param shopId     shop id
     *
     * @return category or null
     */
    Category getCategory(long categoryId, long shopId);

    /**
     * Get category id applicable for given current category. Depending on whether category permits
     * search in subcategories or not this method returns one of more category PK.
     *
     * categoryId is always returned as part of list
     *
     * @param categoryId current category PK
     * @param shopId     current shop
     *
     * @return list of searchable categories with flag to indicate if subcategories to be included
     */
    Pair<List<Long>, Boolean> getSearchCategoriesIds(long categoryId, long shopId);

    /**
     * Get current category menu, or top categories if category is not specified or does
     * not belong to this shop.
     *
     * @param currentCategoryId current category (optional)
     * @param shopId            current shop
     * @param locale            locale
     *
     * @return list of sub categories (or top shop categories)
     */
    List<Category> getCurrentCategoryMenu(long currentCategoryId, long shopId, String locale);

    /**
     * Get thumbnail size configuration.
     *
     * @param categoryId category PK
     * @param shopId     current shop
     *
     * @return first width, second height
     */
    Pair<String, String> getThumbnailSizeConfig(long categoryId, long shopId);

    /**
     * Get category viewing image size configuration.
     *
     * @param categoryId category PK
     * @param shopId     current shop
     *
     * @return first width, second height
     */
    Pair<String, String> getProductListImageSizeConfig(long categoryId, long shopId);

    /**
     * Get category viewing image size configuration.
     *
     * @param categoryId category PK
     * @param shopId     current shop
     *
     * @return first width, second height
     */
    Pair<String, String> getCategoryListImageSizeConfig(long categoryId, long shopId);

    /**
     * Get featured products size configuration.
     *
     * @param categoryId category PK
     * @param shopId     current shop
     *
     * @return max number of products
     */
    int getFeaturedListSizeConfig(long categoryId, long shopId);

    /**
     * Get newarrival products size configuration.
     *
     * @param categoryId category PK
     * @param shopId     current shop
     *
     * @return max number of products
     */
    int getNewArrivalListSizeConfig(long categoryId, long shopId);


    /**
     * Number of days that counts towards newarrival products
     *
     * @param categoryId current category
     * @param shopId current shop
     *
     * @return max number of days
     */
    Date getCategoryNewArrivalDate(long categoryId, long shopId);


    /**
     * Get pagination options configuration.
     *
     * @param categoryId category PK
     * @param shopId     current shop
     *
     * @return pagination options
     */
    List<String> getItemsPerPageOptionsConfig(long categoryId, long shopId);

    /**
     * Get sorting options configuration.
     *
     * @param categoryId category PK
     * @param shopId     current shop
     *
     * @return sorting options
     */
    List<String> getPageSortingOptionsConfig(long categoryId, long shopId);

    /**
     * Get number of columns options configuration.
     *
     * @param categoryId category PK
     * @param shopId     current shop
     *
     * @return product columns options
     */
    int getProductListColumnOptionsConfig(long categoryId, long shopId);

    /**
     * Get number of columns options configuration.
     *
     * @param categoryId category PK
     * @param shopId     current shop
     *
     * @return category columns options
     */
    int getCategoryListColumnOptionsConfig(long categoryId, long shopId);


    /**
     * Get category type with failover mechanism. Uses category product type if set, otherwise
     * looks up parent category product type, until one is found
     *
     * @param categoryId category id
     * @param shopId     current shop
     *
     * @return product type for this category
     */
    Long getCategoryProductTypeId(long categoryId, long shopId);


    /**
     * Get number of values to display in a filter nav block.
     *
     * @param categoryId category PK
     * @param shopId     current shop
     *
     * @return filter nav options limit
     */
    int getCategoryFilterLimitConfig(long categoryId, long shopId);


}
