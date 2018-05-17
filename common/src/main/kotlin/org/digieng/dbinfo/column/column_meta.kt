package org.digieng.dbinfo.column

import org.digieng.dbinfo.DbConnection

expect fun columnExists(dbConn: DbConnection, schema: String, table: String, column: String): Boolean
expect fun allColumns(dbConn: DbConnection, schema: String, table: String): Array<ColumnInfo>
expect fun singleColumn(dbConn: DbConnection, schema: String, table: String, column: String): ColumnInfo?
