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

package org.yes.cart.search.dto.impl;

import org.yes.cart.search.dto.FilteredNavigationRecord;

import java.io.Serializable;

/**
 * User: Igor Azarny iazarny@yahoo.com
 * Date: 07-May-2011
 * Time: 11:12:54
 */
public class FilteredNavigationRecordImpl implements FilteredNavigationRecord, Serializable {

    private static final long serialVersionUID = 20100711L;

    private String name;

    private String displayName;

    private String code;

    private String value;

    private String displayValue;

    private int count;

    private int rank;

    private String type;

    /**
     * {@inheritDoc}
     */
    public String getCode() {
        return code;
    }

    /**
     * {@inheritDoc}
     */
    public void setCode(final String code) {
        this.code = code;
    }

    /**
     * {@inheritDoc}
     */
    public String getValue() {
        return value;
    }

    /**
     * {@inheritDoc}
     */
    public void setValue(final String value) {
        this.value = value;
    }

    /**
     * {@inheritDoc}
     */
    public int getCount() {
        return count;
    }

    /**
     * {@inheritDoc}
     */
    public void setCount(final int itemsCount) {
        this.count = itemsCount;
    }

    /**
     * {@inheritDoc}
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * {@inheritDoc}
     */
    public void setDisplayName(final String displayName) {
        this.displayName = displayName;
    }

    /**
     * {@inheritDoc}
     */
    public int getRank() {
        return rank;
    }

    /**
     * {@inheritDoc}
     */
    public void setRank(final int rank) {
        this.rank = rank;
    }

    /**
     * {@inheritDoc}
     */
    public String getType() {
        return type;
    }

    /**
     * {@inheritDoc}
     */
    public void setType(final String type) {
        this.type = type;
    }

    /**
     * {@inheritDoc}
     */
    public String getDisplayValue() {
        return displayValue;
    }

    /**
     * {@inheritDoc}
     */
    public void setDisplayValue(final String displayValue) {
        this.displayValue = displayValue;
    }

    /**
     * Construct filtered navigation record for simple non-localisable values.
     * E.g. brands
     *
     * @param name  attribute nave
     * @param code  attribute code
     * @param value value
     * @param count count of objects.
     */
    public FilteredNavigationRecordImpl(final String name, final String code, final String value, final int count) {
        this.name = name;
        this.code = code;
        this.value = value;
        this.count = count;
    }

    /**
     * Construct filtered navigation record for localisable records.
     *
     * @param name  attribute nave
     * @param displayName attribute displayName
     * @param code  attribute code
     * @param value value
     * @param displayValue display value
     * @param count count of objects.
     * @param rank  rank
     * @param type  type of navigation S - single value R - range value
     */
    public FilteredNavigationRecordImpl(final String name, final String displayName,
                                        final String code,
                                        final String value, final String displayValue,
                                        final int count, final int rank, final String type) {
        this.name = name;
        this.displayName = displayName;
        this.code = code;
        this.value = value;
        this.displayValue = displayValue;
        this.count = count;
        this.rank = rank;
        this.type = type;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FilteredNavigationRecord clone() {
        try {
            return (FilteredNavigationRecord) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilteredNavigationRecordImpl that = (FilteredNavigationRecordImpl) o;
        // we do not include display* fields as they will be the same if the original are the same
        if (rank != that.rank) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        // we do not include display* fields as they will be the same if the original are the same
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + rank;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
