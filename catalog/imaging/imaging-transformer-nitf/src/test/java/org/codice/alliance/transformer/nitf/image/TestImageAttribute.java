/**
 * Copyright (c) Codice Foundation
 * <p/>
 * This is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser
 * General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details. A copy of the GNU Lesser General Public License
 * is distributed along with this program and can be found at
 * <http://www.gnu.org/licenses/lgpl.html>.
 */
package org.codice.alliance.transformer.nitf.image;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

import java.util.stream.Stream;

import org.codice.imaging.nitf.core.common.NitfFormatException;
import org.codice.imaging.nitf.core.image.ImageSegment;
import org.junit.Before;
import org.junit.Test;

public class TestImageAttribute {

    private ImageSegment imageSegment;

    @Before
    public void setUp() {
        this.imageSegment = mock(ImageSegment.class);
    }

    @Test
    public void testImageAttributes() throws NitfFormatException {
        Stream.of(ImageAttribute.values())
                .forEach(attribute -> assertThat(attribute.getShortName(), is(notNullValue())));

        assertThat(ImageAttribute.TARGET_IDENTIFIER.getAccessorFunction()
                .apply(imageSegment), is(nullValue()));
        assertThat(ImageAttribute.IMAGE_DATE_AND_TIME.getAccessorFunction()
                .apply(imageSegment), is(nullValue()));
        assertThat(ImageAttribute.IMAGE_IDENTIFIER_2.getAccessorFunction()
                .apply(imageSegment), is(nullValue()));
        assertThat(ImageAttribute.NUMBER_OF_SIGNIFICANT_ROWS_IN_IMAGE.getAccessorFunction()
                .apply(imageSegment), is(0L));
        assertThat(ImageAttribute.NUMBER_OF_SIGNIFICANT_COLUMNS_IN_IMAGE.getAccessorFunction()
                .apply(imageSegment), is(0L));
        assertThat(ImageAttribute.IMAGE_SOURCE.getAccessorFunction()
                .apply(imageSegment), is(nullValue()));
    }
}
