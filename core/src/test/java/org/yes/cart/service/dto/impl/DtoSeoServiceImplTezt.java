/*
 * Copyright 2009 Igor Azarnyi, Denys Pavlov
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

package org.yes.cart.service.dto.impl;

import org.junit.Before;
import org.junit.Test;
import org.yes.cart.BaseCoreDBTestCase;
import org.yes.cart.constants.ServiceSpringKeys;
import org.yes.cart.domain.dto.SeoDTO;
import org.yes.cart.exception.UnableToCreateInstanceException;
import org.yes.cart.exception.UnmappedInterfaceException;
import org.yes.cart.service.dto.DtoSeoService;

import static org.junit.Assert.*;

/**
 * User: Igor Azarny iazarny@yahoo.com
 * Date: 09-May-2011
 * Time: 14:12:54
 */
public class DtoSeoServiceImplTezt extends BaseCoreDBTestCase {

    private DtoSeoService dtoService;

    @Before
    public void setUp() throws Exception {
        dtoService = (DtoSeoService) ctx().getBean(ServiceSpringKeys.DTO_SEO_SERVICE);
    }

    @Test
    public void testCreate() throws Exception {
        SeoDTO seoDTO = getDto();
        seoDTO = dtoService.create(seoDTO);
        assertTrue(seoDTO.getSeoId() > 0);
    }

    @Test
    public void testUpdate() throws Exception {
        SeoDTO seoDTO = getDto();
        seoDTO = dtoService.create(seoDTO);
        assertTrue(seoDTO.getSeoId() > 0);
        long pk = seoDTO.getSeoId();
        seoDTO.setUri("Bender-Bending-Rodríguez-Robot");
        dtoService.update(seoDTO);
        seoDTO = dtoService.getById(pk);
        assertEquals("Bender-Bending-Rodríguez-Robot", seoDTO.getUri());
    }

    @Test
    public void testRemove() throws Exception {
        SeoDTO seoDTO = getDto();
        seoDTO = dtoService.create(seoDTO);
        assertTrue(seoDTO.getSeoId() > 0);
        long pk = seoDTO.getSeoId();
        dtoService.remove(pk);
        seoDTO = dtoService.getById(pk);
        assertNull(seoDTO);
    }

    private SeoDTO getDto() throws UnableToCreateInstanceException, UnmappedInterfaceException {
        SeoDTO seoDTO = dtoService.getNew();
        seoDTO.setUri("Bender-Bending-Rodríguez");
        seoDTO.setTitle("Bender Bending Rodríguez");
        seoDTO.setMetadescription("Bender (full name Bender Bending Rodríguez), designated Bending Unit 22, is a fictional robot character in the animated television series Futurama.");
        seoDTO.setMetakeywords("Robot, Beer, Futurama");
        return seoDTO;
    }
}
