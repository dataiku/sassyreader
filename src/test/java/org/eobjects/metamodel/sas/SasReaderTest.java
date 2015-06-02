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

import java.util.List;

import org.junit.Test;

// Note: These tests have been dumbed down from the original code
// because they don't include the comparison code anymore ...
public class SasReaderTest extends SasReaderTestBase {
    @Test
    public void testCharsetMostlyLatin() throws Exception {
        readSas("charset_mostly_latin.sas7bdat", 1, 7);
    }

    @Test
    public void testReadEvent2() throws Exception {
        readSas("event2.sas7bdat", 9, 1506);
    }
    @Test
    public void testReadMathAttitudes() throws Exception {
        readSas("mathattitudes.sas7bdat", 15, 1907);
    }

    /**
     * TODO: Ignored for release
     */
    //    @Test 
    //    public void testReadPhyseds2006() throws Exception {
    //     List<Object[]> sampleRows = readSas("physeds2006.sas7bdat", 232, 51);
    //    
    //     assertEquals(51, sampleRows.size());
    //    
    //     assertEquals("Alabama", sampleRows.get(0)[1]);
    //     assertEquals("Alaska", sampleRows.get(1)[1]);
    //     assertEquals("Arizona", sampleRows.get(2)[1]);
    //     assertEquals("Arkansas", sampleRows.get(3)[1]);
    //     assertEquals("California", sampleRows.get(4)[1]);
    //     assertEquals("Colorado", sampleRows.get(5)[1]);
    //     assertEquals("Connecticut", sampleRows.get(6)[1]);
    //     assertEquals("Delaware", sampleRows.get(7)[1]);
    //     assertEquals("Wyoming", sampleRows.get(50)[1]);
    //     }
    
    @Test
    public void testReadBeef() throws Exception {
        readSas("beef.sas7bdat", 9, 30);
    }
    @Test
    public void testReadMammals() throws Exception {
        readSas("mammals.sas7bdat", 31, 30);
    }
    @Test
    public void testReadPizza() throws Exception {
        readSas("pizza.sas7bdat", 9, 300);
    }

}
