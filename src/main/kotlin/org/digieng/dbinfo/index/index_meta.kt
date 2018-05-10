package org.digieng.dbinfo.index

expect fun allPrimaryKeys(schema: String, table: String): Array<PrimaryKeyInfo>
expect fun primaryKeyExists(schema: String, table: String, colName: String): Boolean
expect fun foreignKeyExists(schema: String, table: String, colName: String): Boolean
expect fun singleForeignKey(schema: String, table: String, colName: String): ForeignKeyInfo?
expect fun allForeignKeys(schema: String, table: String): Array<ForeignKeyInfo>