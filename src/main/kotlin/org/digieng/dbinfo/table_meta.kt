package org.digieng.dbinfo

expect fun tableExists(schema: String, table: String): Boolean
expect fun allTables(schema: String): Array<TableInfo>
expect fun singleTable(schema: String, table: String): TableInfo?