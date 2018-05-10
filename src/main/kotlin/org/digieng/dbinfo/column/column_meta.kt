package org.digieng.dbinfo.column

expect fun columnExists(schema: String, table: String, colName: String): Boolean
expect fun allColumns(schema: String, table: String): Array<ColumnInfo>
expect fun singleColumn(schema: String, table: String, colName: String): ColumnInfo?
