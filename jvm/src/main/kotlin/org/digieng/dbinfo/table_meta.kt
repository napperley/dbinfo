package org.digieng.dbinfo

actual fun tableExists(dbConn: DbConnection, schema: String, table: String): Boolean {
    var result = false

    if (dbConn.isOpen) {
        when (dbConn) {
            is MySqlDbConnection -> {
                val conn = dbConn.conn

                if (conn != null) result = allMySqlTables(schema, conn.metaData).any { it.name == table }
            }
        }
    }
    return result
}

actual fun allTables(dbConn: DbConnection, schema: String): Array<TableInfo> {
    var result: Array<TableInfo> = emptyArray()

    if (dbConn.isOpen) {
        when (dbConn) {
            is MySqlDbConnection -> {
                val conn = dbConn.conn

                if (conn != null) result = allMySqlTables(schema, conn.metaData)
            }
        }
    }
    return result
}

actual fun singleTable(dbConn: DbConnection, schema: String, table: String): TableInfo? {
    var result: TableInfo? = null

    if (dbConn.isOpen) {
        when (dbConn) {
            is MySqlDbConnection -> {
                val conn = dbConn.conn

                if (conn != null) result = singleMySqlTable(dbMetaData = conn.metaData, schema = schema, table = table)
            }
        }
    }
    return result
}
