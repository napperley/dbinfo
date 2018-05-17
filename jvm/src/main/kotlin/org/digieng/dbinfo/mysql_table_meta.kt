package org.digieng.dbinfo

import org.digieng.dbinfo.column.allMysqlColumns
import org.digieng.dbinfo.index.allMysqlForeignKeys
import org.digieng.dbinfo.index.allMysqlPrimaryKeys
import java.sql.DatabaseMetaData

internal fun allMySqlTables(schema: String, dbMetaData: DatabaseMetaData): Array<TableInfo> {
    val types = arrayOf("TABLE")
    val tableNamePattern = "%"
    val tmp = mutableListOf<TableInfo>()
    val tables = dbMetaData.getTables(null, schema, tableNamePattern, types)
    val tableNamePos = 3

    while (tables.next()) {
        val tblName = tables.getString(tableNamePos)

        tmp += TableInfo(
            name = tblName,
            columns = allMysqlColumns(schema = schema, table = tblName, dbMetaData = dbMetaData),
            primaryKeys = allMysqlPrimaryKeys(table = tables, dbMetaData = dbMetaData),
            foreignKeys = allMysqlForeignKeys(schema = schema, table = tblName, dbMetaData = dbMetaData)
        )
    }
    return tmp.toTypedArray()
}

internal fun singleMySqlTable(schema: String, table: String, dbMetaData: DatabaseMetaData): TableInfo? {
    var result: TableInfo? = null
    val types = arrayOf("TABLE")
    val rs = dbMetaData.getTables(null, schema, table, types)

    if (rs.first()) {
        result = TableInfo(
            name = table,
            columns = allMysqlColumns(schema = schema, table = table, dbMetaData = dbMetaData),
            primaryKeys = allMysqlPrimaryKeys(table = rs, dbMetaData = dbMetaData),
            foreignKeys = allMysqlForeignKeys(schema = schema, table = table, dbMetaData = dbMetaData)
        )
    }
    return result
}