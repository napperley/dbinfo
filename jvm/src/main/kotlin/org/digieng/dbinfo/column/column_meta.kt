package org.digieng.dbinfo.column

import org.digieng.dbinfo.DbConnection
import org.digieng.dbinfo.MySqlDbConnection
import java.sql.Types


actual fun columnExists(dbConn: DbConnection, schema: String, table: String, column: String): Boolean {
    var result = false

    if (dbConn.isOpen) {
        when (dbConn) {
            is MySqlDbConnection -> {
                val conn = dbConn.conn

                if (conn != null) {
                    val tmp = singleMysqlColumn(
                        dbMetaData = conn.metaData,
                        schema = schema,
                        table = table,
                        column = column
                    )

                    result = tmp != null && tmp.name == column
                }
            }
        }
    }
    return result
}

actual fun allColumns(dbConn: DbConnection, schema: String, table: String): Array<ColumnInfo> {
    var result: Array<ColumnInfo> = emptyArray()

    if (dbConn.isOpen) {
        when (dbConn) {
            is MySqlDbConnection -> {
                val conn = dbConn.conn

                if (conn != null) result = allMysqlColumns(schema = schema, table = table, dbMetaData = conn.metaData)
            }
        }
    }
    return result
}

actual fun singleColumn(dbConn: DbConnection, schema: String, table: String, column: String): ColumnInfo? {
    var result: ColumnInfo? = null

    if (dbConn.isOpen) {
        when (dbConn) {
            is MySqlDbConnection -> {
                val conn = dbConn.conn

                if (conn != null) {
                    result = singleMysqlColumn(
                        dbMetaData = conn.metaData,
                        schema = schema, table = table,
                        column = column
                    )
                }
            }
        }
    }
    return result
}

internal fun columnTypeName(num: Int) = when (num) {
    Types.BOOLEAN -> ColumnType.BOOLEAN.name.toLowerCase()
    Types.BIGINT -> ColumnType.BIGINT.name.toLowerCase()
    Types.BINARY -> ColumnType.BINARY.name.toLowerCase()
    Types.BIT -> ColumnType.BIT.name.toLowerCase()
    Types.BLOB -> ColumnType.BLOB.name.toLowerCase()
    Types.CHAR -> ColumnType.CHAR.name.toLowerCase()
    Types.DATE -> ColumnType.DATE.name.toLowerCase()
    Types.DECIMAL -> ColumnType.DECIMAL.name.toLowerCase()
    Types.DOUBLE -> ColumnType.DOUBLE.name.toLowerCase()
    Types.SMALLINT -> ColumnType.SMALLINT.name.toLowerCase()
    Types.FLOAT -> ColumnType.FLOAT.name.toLowerCase()
    Types.INTEGER -> ColumnType.INTEGER.name.toLowerCase()
    Types.REAL -> ColumnType.REAL.name.toLowerCase()
    Types.TIME -> ColumnType.TIME.name.toLowerCase()
    Types.TIMESTAMP -> ColumnType.TIMESTAMP.name.toLowerCase()
    Types.VARBINARY -> ColumnType.VARBINARY.name.toLowerCase()
    Types.VARCHAR -> ColumnType.VARCHAR.name.toLowerCase()
    else -> "Unknown"
}
