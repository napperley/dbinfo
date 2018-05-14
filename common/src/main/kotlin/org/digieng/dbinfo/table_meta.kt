package org.digieng.dbinfo

expect fun tableExists(dbConn: DbConnection, schema: String, table: String): Boolean
expect fun allTables(dbConn: DbConnection, schema: String): Array<TableInfo>
expect fun singleTable(dbConn: DbConnection, schema: String, table: String): TableInfo?