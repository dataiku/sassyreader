/**
 * eobjects.org SassyReader
 * Copyright (C) 2011 eobjects.org
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.eobjects.metamodel.sas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public abstract class SasReaderTestBase {

    protected List<Object[]> readSas(String filename, int columns, int rows) throws Exception {
        File file = new File("src/test/resources/" + filename);
        return readSas(file, columns, rows);
    }

    private List<Object[]> readSas(File file, int columns, int rows) throws Exception {
        try (InputStream is = new FileInputStream(file)) {
            SasReader reader = new SasReader(is, file.getName());

            CountingSasReaderCallback callback = new CountingSasReaderCallback(
                    true);
            reader.read(callback);
            assertEquals(columns, callback.getColumnCount());
            assertEquals(rows, callback.getRowCount());

            return callback.getSampleRows();
        }
    }

    public void testIsMagicNumber() throws Exception {
        int[] identical = new int[] { 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0,
                0x0, 0x0, 0x0, 0x0, 0xc2, 0xea, 0x81, 0x60, 0xb3, 0x14, 0x11,
                0xcf, 0xbd, 0x92, 0x8, 0x0, 0x9, 0xc7, 0x31, 0x8c, 0x18, 0x1f,
                0x10, 0x11 };

        int[] diff1 = new int[] { 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0,
                0x0, 0x0, 0x0, 0xc2, 0xea, 0x81, 0x60, 0xb3, 0x14, 0x11, 0xcf,
                0xbd, 0x92, 0x8, 0x0, 0x9, 0xc7, 0x31, 0x8c, 0x18, 0x1f, 0x10,
                0x12 };
        int[] diff2 = new int[] { 0x0, 0x0 };
        int[] diff3 = new int[] {};
        int[] diff4 = null;

        assertTrue(SasReader.isMagicNumber(identical));
        assertFalse(SasReader.isMagicNumber(diff1));
        assertFalse(SasReader.isMagicNumber(diff2));
        assertFalse(SasReader.isMagicNumber(diff3));
        assertFalse(SasReader.isMagicNumber(diff4));
    }
}
