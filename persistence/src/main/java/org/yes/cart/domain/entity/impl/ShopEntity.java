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
package org.yes.cart.domain.entity.impl;


import org.apache.commons.lang.StringUtils;
import org.yes.cart.constants.AttributeNamesKeys;
import org.yes.cart.domain.entity.*;

import java.util.*;

/**
 * User: Igor Azarny iazarny@yahoo.com
 * Date: 27 0ct 2012
 * Time: 9:10 AM
 */
public class ShopEntity implements org.yes.cart.domain.entity.Shop, java.io.Serializable {

    private long shopId;
    private long version;

    private String code;
    private String name;
    private String description;
    private String fspointer;
    private boolean disabled;
    private Set<ShopUrl> shopUrl = new HashSet<ShopUrl>(0);
    private Collection<ShopAdvPlace> advertisingPlaces = new ArrayList<ShopAdvPlace>(0);
    private Collection<AttrValueShop> attributes = new ArrayList<AttrValueShop>(0);
    private SeoEntity seoInternal;
    private Collection<ShopCategory> shopCategory = new ArrayList<ShopCategory>(0);
    private Date createdTimestamp;
    private Date updatedTimestamp;
    private String createdBy;
    private String updatedBy;
    private String guid;

    private List<String> supportedCurrenciesAsList;
    private List<String> supportedShippingCountriesAsList;
    private List<String> supportedBillingCountriesAsList;
    private List<String> supportedLanguagesAsList;

    private Map<String, List<String>> supportedRegistrationFormAttributesByType = new HashMap<String, List<String>>();
    private Map<String, List<String>> supportedProfileFormAttributesByType = new HashMap<String, List<String>>();
    private Map<String, List<String>> supportedProfileFormReadOnlyAttributesByType = new HashMap<String, List<String>>();

    private Map<String, Map<String, String>> addressFormattingByLanguageByCountryCode = new HashMap<String, Map<String, String>>();

    public ShopEntity() {
    }



    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFspointer() {
        return this.fspointer;
    }

    public void setFspointer(String fspointer) {
        this.fspointer = fspointer;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(final boolean disabled) {
        this.disabled = disabled;
    }

    public Set<ShopUrl> getShopUrl() {
        return this.shopUrl;
    }

    public void setShopUrl(Set<ShopUrl> shopUrl) {
        this.shopUrl = shopUrl;
    }

    public Collection<ShopAdvPlace> getAdvertisingPlaces() {
        return this.advertisingPlaces;
    }

    public void setAdvertisingPlaces(Collection<ShopAdvPlace> advertisingPlaces) {
        this.advertisingPlaces = advertisingPlaces;
    }

    public Collection<AttrValueShop> getAttributes() {
        return this.attributes;
    }

    public void setAttributes(Collection<AttrValueShop> attributes) {
        this.attributes = attributes;
    }

    public Collection<AttrValue> getAllAttributes() {
        return new ArrayList<AttrValue>(attributes);
    }

    public Map<String, AttrValue> getAllAttributesAsMap() {
        final Map<String, AttrValue> rez = new HashMap<String, AttrValue>();
        for (AttrValue attrValue : getAllAttributes()) {
            if (attrValue != null && attrValue.getAttribute() != null) {
                rez.put(attrValue.getAttribute().getCode(), attrValue);
            }
        }
        return rez;
    }

    public SeoEntity getSeoInternal() {
        return this.seoInternal;
    }

    public void setSeoInternal(SeoEntity seo) {
        this.seoInternal = seo;
    }

    public Collection<ShopCategory> getShopCategory() {
        return this.shopCategory;
    }

    public void setShopCategory(Collection<ShopCategory> shopCategory) {
        this.shopCategory = shopCategory;
    }

    public Date getCreatedTimestamp() {
        return this.createdTimestamp;
    }

    public void setCreatedTimestamp(Date createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public Date getUpdatedTimestamp() {
        return this.updatedTimestamp;
    }

    public void setUpdatedTimestamp(Date updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getGuid() {
        return this.guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public long getShopId() {
        return this.shopId;
    }

    public long getId() {
        return this.shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(final long version) {
        this.version = version;
    }

    public String getSupportedCurrencies() {
        return getAttributeValueByCode(AttributeNamesKeys.Shop.SUPPORTED_CURRENCIES);
    }

    public String getDefaultCurrency() {
        List<String> currencies = getSupportedCurrenciesAsList();
        if (currencies != null && !currencies.isEmpty()) {
            return currencies.get(0);
        }
        return null;
    }

    public List<String> getSupportedCurrenciesAsList() {
        if (supportedCurrenciesAsList == null) {
            final String currencies = getSupportedCurrencies();
            if (currencies != null) {
                supportedCurrenciesAsList = Arrays.asList(StringUtils.split(currencies, ','));
            } else {
                supportedCurrenciesAsList = Collections.emptyList();
            }
        }
        return supportedCurrenciesAsList;
    }


    public String getSupportedShippingCountries() {
        return getAttributeValueByCode(AttributeNamesKeys.Shop.SUPPORTED_COUNTRY_SHIP);
    }

    public List<String> getSupportedShippingCountriesAsList() {
        if (supportedShippingCountriesAsList == null) {
            final String countries = getSupportedShippingCountries();
            if (countries != null) {
                supportedShippingCountriesAsList = Arrays.asList(StringUtils.split(countries, ','));
            } else {
                supportedShippingCountriesAsList = Collections.emptyList();
            }

        }
        return supportedShippingCountriesAsList;
    }

    public String getSupportedBillingCountries() {
        return getAttributeValueByCode(AttributeNamesKeys.Shop.SUPPORTED_COUNTRY_BILL);
    }

    public List<String> getSupportedBillingCountriesAsList() {
        if (supportedBillingCountriesAsList == null) {
            final String countries = getSupportedBillingCountries();
            if (countries != null) {
                supportedBillingCountriesAsList = Arrays.asList(StringUtils.split(countries, ','));
            } else {
                supportedBillingCountriesAsList = Collections.emptyList();
            }
        }
        return supportedBillingCountriesAsList;
    }

    public String getSupportedLanguages() {
        return getAttributeValueByCode(AttributeNamesKeys.Shop.SUPPORTED_LANGUAGES);
    }

    public List<String> getSupportedLanguagesAsList() {
        if (supportedLanguagesAsList == null) {
            final String languages = getSupportedLanguages();
            if (languages != null) {
                supportedLanguagesAsList = Arrays.asList(StringUtils.split(languages, ','));
            } else {
                supportedLanguagesAsList = Collections.emptyList();
            }
        }
        return supportedLanguagesAsList;
    }

    public String getAddressFormatByCountryAndCustomerTypeAndLocale(final String countryCode, final String locale, final String customerType) {

        Map<String, String> formatByCountryCode = addressFormattingByLanguageByCountryCode.get(locale);

        if (formatByCountryCode == null) {
            formatByCountryCode = new HashMap<String, String>();
            addressFormattingByLanguageByCountryCode.put(locale, formatByCountryCode);
        }

        final String countryKey = StringUtils.isNotBlank(customerType) ? countryCode + "_" + customerType : countryCode;
        String format = formatByCountryCode.get(countryKey);
        if (!formatByCountryCode.containsKey(countryKey)) {
            if (StringUtils.isNotBlank(customerType)) {
                format = getAttributeValueByCode(AttributeNamesKeys.Shop.ADDRESS_FORMATTER_PREFIX + "_" + countryCode + "_" + locale + "_" + customerType);
                if (format == null) {
                    format = getAttributeValueByCode(AttributeNamesKeys.Shop.ADDRESS_FORMATTER_PREFIX + "_" + countryCode + "_" + customerType);
                }
                if (format == null) {
                    format = getAttributeValueByCode(AttributeNamesKeys.Shop.ADDRESS_FORMATTER_PREFIX + "_" + locale + "_" + customerType);
                }
                if (format == null) {
                    format = getAttributeValueByCode(AttributeNamesKeys.Shop.ADDRESS_FORMATTER_PREFIX + "_" + customerType);
                }
            }
            if (format == null) {
                format = getAttributeValueByCode(AttributeNamesKeys.Shop.ADDRESS_FORMATTER_PREFIX + "_" + countryCode + "_" + locale);
            }
            if (format == null) {
                format = getAttributeValueByCode(AttributeNamesKeys.Shop.ADDRESS_FORMATTER_PREFIX + "_" + countryCode);
            }
            if (format == null) {
                format = getAttributeValueByCode(AttributeNamesKeys.Shop.ADDRESS_FORMATTER_PREFIX + "_" + locale);
            }
            if (format == null) {
                format = getAttributeValueByCode(AttributeNamesKeys.Shop.ADDRESS_FORMATTER_PREFIX);
            }
            formatByCountryCode.put(countryKey, format);
        }

        return format;
    }

    public String getSupportedRegistrationFormAttributes(final String customerType) {
        if (StringUtils.isBlank(customerType)) {
            return getAttributeValueByCode(AttributeNamesKeys.Shop.CUSTOMER_REGISTRATION_ATTRIBUTES_PREFIX);
        }
        return getAttributeValueByCode(AttributeNamesKeys.Shop.CUSTOMER_REGISTRATION_ATTRIBUTES_PREFIX + '_' + customerType);
    }

    public List<String> getSupportedRegistrationFormAttributesAsList(final String customerType) {
        List<String> supportedRegistrationFormAttributesAsList = this.supportedRegistrationFormAttributesByType.get(customerType);
        if (supportedRegistrationFormAttributesAsList == null) {
            final String attrs = getSupportedRegistrationFormAttributes(customerType);
            if (attrs != null) {
                supportedRegistrationFormAttributesAsList = Arrays.asList(StringUtils.split(attrs, ','));
            } else {
                supportedRegistrationFormAttributesAsList = Collections.emptyList();
            }
            this.supportedRegistrationFormAttributesByType.put(customerType, supportedRegistrationFormAttributesAsList);
        }
        return supportedRegistrationFormAttributesAsList;
    }

    public String getSupportedProfileFormAttributes(final String customerType) {
        if (StringUtils.isBlank(customerType)) {
            return getAttributeValueByCode(AttributeNamesKeys.Shop.CUSTOMER_PROFILE_ATTRIBUTES_VISIBLE_PREFIX);
        }
        return getAttributeValueByCode(AttributeNamesKeys.Shop.CUSTOMER_PROFILE_ATTRIBUTES_VISIBLE_PREFIX + '_' + customerType);
    }

    public List<String> getSupportedProfileFormAttributesAsList(final String customerType) {
        List<String> supportedProfileFormAttributesAsList = this.supportedProfileFormAttributesByType.get(customerType);
        if (supportedProfileFormAttributesAsList == null) {
            final String attrs = getSupportedProfileFormAttributes(customerType);
            if (attrs != null) {
                supportedProfileFormAttributesAsList = Arrays.asList(StringUtils.split(attrs, ','));
            } else {
                supportedProfileFormAttributesAsList = Collections.emptyList();
            }
            this.supportedProfileFormAttributesByType.put(customerType, supportedProfileFormAttributesAsList);
        }
        return supportedProfileFormAttributesAsList;
    }

    public String getSupportedProfileFormReadOnlyAttributes(final String customerType) {
        if (StringUtils.isBlank(customerType)) {
            return getAttributeValueByCode(AttributeNamesKeys.Shop.CUSTOMER_PROFILE_ATTRIBUTES_READONLY_PREFIX);
        }
        return getAttributeValueByCode(AttributeNamesKeys.Shop.CUSTOMER_PROFILE_ATTRIBUTES_READONLY_PREFIX + '_' + customerType);
    }

    public List<String> getSupportedProfileFormReadOnlyAttributesAsList(final String customerType) {
        List<String> supportedProfileFormReadOnlyAttributesAsList = this.supportedProfileFormReadOnlyAttributesByType.get(customerType);
        if (supportedProfileFormReadOnlyAttributesAsList == null) {
            final String attrs = getSupportedProfileFormReadOnlyAttributes(customerType);
            if (attrs != null) {
                supportedProfileFormReadOnlyAttributesAsList = Arrays.asList(StringUtils.split(attrs, ','));
            } else {
                supportedProfileFormReadOnlyAttributesAsList = Collections.emptyList();
            }
            this.supportedProfileFormReadOnlyAttributesByType.put(customerType, supportedProfileFormReadOnlyAttributesAsList);
        }
        return supportedProfileFormReadOnlyAttributesAsList;
    }

    public Collection<AttrValueShop> getAttributesByCode(final String attributeCode) {
        final Collection<AttrValueShop> result = new ArrayList<AttrValueShop>();
        if (attributeCode != null && this.attributes != null) {
            for (AttrValueShop attrValue : this.attributes) {
                if (attrValue.getAttribute().getCode().equals(attributeCode)) {
                    result.add(attrValue);
                }
            }
        }
        return result;
    }

    public AttrValueShop getAttributeByCode(final String attributeCode) {
        if (attributeCode == null) {
            return null;
        }
        if (this.attributes != null) {
            for (AttrValueShop attrValue : this.attributes) {
                if (attrValue.getAttribute() != null && attributeCode.equals(attrValue.getAttribute().getCode())) {
                    return attrValue;
                }
            }
        }
        return null;
    }

    public String getAttributeValueByCode(final String attributeCode) {
        final AttrValueShop val = getAttributeByCode(attributeCode);
        return val != null ? val.getVal() : null;
    }

    public boolean isAttributeValueByCodeTrue(final String attributeCode) {
        final AttrValueShop val = getAttributeByCode(attributeCode);
        return val != null && Boolean.valueOf(val.getVal());
    }

    @Override
    public String toString() {
        return this.getClass().getName() + this.getShopId();
    }

    public boolean isB2BProfileActive() {
        final String avs = getAttributeValueByCode(AttributeNamesKeys.Shop.SHOP_B2B);
        if (avs != null) {
            return Boolean.valueOf(avs);
        }
        return false;
    }

    public String getDefaultShopUrl() {
        for (ShopUrl shopUrl : getShopUrl()) {
            if (shopUrl.isPrimary()) {
                return "http://" + shopUrl.getUrl();
            }
        }
        for (ShopUrl shopUrl : getShopUrl()) {
            if (shopUrl.getUrl().endsWith("localhost") || shopUrl.getUrl().contains("127.0.0.1")) {
                continue;
            }
            return "http://" + shopUrl.getUrl();
        }
        return "";
    }


    public Seo getSeo() {
        SeoEntity seo = getSeoInternal();
        if (seo == null) {
            seo = new SeoEntity();
            this.setSeoInternal(seo);
        }
        return seo;
    }

    public void setSeo(final Seo seo) {
        this.setSeoInternal((SeoEntity) seo);
    }


    /** {@inheritDoc} */
    public int hashCode() {
        return (int) (shopId ^ (shopId >>> 32));
    }

}


