package org.digieng.dbinfo.column

import org.digieng.dbinfo.DbConnection

expect fun columnExists(dbConn: DbConnection, schema: String, table: String, colName: String): Boolean
expect fun allColumns(dbConn: DbConnection, schema: String, table: String): Array<ColumnInfo>
expect fun singleColumn(dbConn: DbConnection, schema: String, table: String, colName: String): ColumnInfo?
