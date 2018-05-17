package org.digieng.dbinfo.index

import org.digieng.dbinfo.DbConnection

expect fun allPrimaryKeys(dbConn: DbConnection, schema: String, table: String): Array<PrimaryKeyInfo>
expect fun primaryKeyExists(dbConn: DbConnection, schema: String, table: String, column: String): Boolean
expect fun foreignKeyExists(dbConn: DbConnection, schema: String, table: String, column: String): Boolean
expect fun singleForeignKey(dbConn: DbConnection, schema: String, table: String, column: String): ForeignKeyInfo?
expect fun allForeignKeys(dbConn: DbConnection, schema: String, table: String): Array<ForeignKeyInfo>