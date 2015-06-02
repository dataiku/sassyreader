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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Ignore
class CountingSasReaderCallback implements SasReaderCallback {

    private static final Logger logger = LoggerFactory.getLogger(CountingSasReaderCallback.class);

    public static final int SAMPLE_LIMIT = 100;

    private final List<Object[]> sampleRows = new ArrayList<Object[]>();
    private final boolean readData;
    private int columnCount = 0;
    private int rowCount = 0;

    public CountingSasReaderCallback(boolean readData) {
        this.readData = readData;
    }

    @Override
    public boolean readData() {
        return readData;
    }

    @Override
    public void column(int columnIndex, String columnName, String columnLabel, SasColumnType columnType,
            int columnLength) {
        columnCount++;
    }

    @Override
    public boolean row(int row, Object[] rowData) {
        logger.info("row no. {}: {}", row, rowData);
        rowCount++;

        if (rowCount < SAMPLE_LIMIT) {
            sampleRows.add(rowData);
        }

        Assert.assertEquals(columnCount, rowData.length);
        return true;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public int getRowCount() {
        return rowCount;
    }

    public List<Object[]> getSampleRows() {
        return sampleRows;
    }
}
