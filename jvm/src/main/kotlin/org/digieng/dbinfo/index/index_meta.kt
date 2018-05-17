package org.digieng.dbinfo.index

import org.digieng.dbinfo.DbConnection
import org.digieng.dbinfo.MySqlDbConnection

actual fun allPrimaryKeys(dbConn: DbConnection, schema: String, table: String): Array<PrimaryKeyInfo> {
    var result: Array<PrimaryKeyInfo> = emptyArray()
    val types = arrayOf("TABLE")

    if (dbConn.isOpen) {
        when (dbConn) {
            is MySqlDbConnection -> {
                val conn = dbConn.conn

                if (conn != null) {
                    val rs = conn.metaData.getTables(null, schema, table, types)

                    if (rs.fetchSize > 0) {
                        rs.next()
                        result = allMysqlPrimaryKeys(table = rs, dbMetaData = conn.metaData)
                    }
                }
            }
        }
    }
    return result
}

actual fun primaryKeyExists(dbConn: DbConnection, schema: String, table: String, column: String): Boolean {
    var result = false

    if (dbConn.isOpen) {
        when (dbConn) {
            is MySqlDbConnection -> {
                val conn = dbConn.conn

                if (conn != null) {
                    result = allPrimaryKeys(dbConn = dbConn, schema = schema, table = table)
                        .any { it.colName == column }
                }
            }
        }
    }
    return result
}

actual fun foreignKeyExists(dbConn: DbConnection, schema: String, table: String, column: String): Boolean {
    var result = false

    if (dbConn.isOpen) {
        when (dbConn) {
            is MySqlDbConnection -> {
                val conn = dbConn.conn

                if (conn != null) {
                    result = allMysqlForeignKeys(schema = schema, table = table, dbMetaData = conn.metaData)
                        .any { it.colName == column }
                }
            }
        }
    }
    return result
}

actual fun singleForeignKey(dbConn: DbConnection, schema: String, table: String, column: String): ForeignKeyInfo? {
    var result: ForeignKeyInfo? = null

    if (dbConn.isOpen) {
        when (dbConn) {
            is MySqlDbConnection -> {
                val conn = dbConn.conn

                if (conn != null) {
                    result = allMysqlForeignKeys(schema = schema, table = table, dbMetaData = conn.metaData)
                        .singleOrNull { it.colName == column }
                }
            }
        }
    }
    return result
}

actual fun allForeignKeys(dbConn: DbConnection, schema: String, table: String): Array<ForeignKeyInfo> {
    var result: Array<ForeignKeyInfo> = emptyArray()

    if (dbConn.isOpen) {
        when (dbConn) {
            is MySqlDbConnection -> {
                val conn = dbConn.conn

                if (conn != null) {
                    result = allMysqlForeignKeys(schema = schema, table = table, dbMetaData = conn.metaData)
                }
            }
        }
    }
    return result
}
