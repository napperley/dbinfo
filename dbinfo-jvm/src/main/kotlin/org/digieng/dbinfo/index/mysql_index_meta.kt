package org.digieng.dbinfo.index

import java.sql.DatabaseMetaData
import java.sql.ResultSet

internal fun allMysqlPrimaryKeys(table: ResultSet, dbMetaData: DatabaseMetaData): Array<PrimaryKeyInfo> {
    val catalog = table.getString("TABLE_CAT")
    val schema = table.getString("TABLE_SCHEM")
    val tableName = table.getString("TABLE_NAME")
    val colNamePos = 4
    val pkNamePos = 6
    val tmp = mutableListOf<PrimaryKeyInfo>()
    val keys = dbMetaData.getPrimaryKeys(catalog, schema, tableName)

    while (keys.next()) {
        val pkName = keys.getString(pkNamePos)

        tmp += PrimaryKeyInfo(
            colName = keys.getString(colNamePos),
            pkName = if (pkName != "PRIMARY") pkName else ""
        )
    }
    return tmp.toTypedArray()
}

internal fun allMysqlForeignKeys(schema: String, table: String, dbMetaData: DatabaseMetaData): Array<ForeignKeyInfo> {
    val colNamePos = 8
    val pkTablePos = 3
    val pkNamePos = 4
    val tmp = mutableListOf<ForeignKeyInfo>()
    val keys = dbMetaData.getImportedKeys(null, schema, table)

    while (keys.next()) {
        tmp += ForeignKeyInfo(
            colName = keys.getString(colNamePos),
            pkName = keys.getString(pkNamePos),
            pkTable = keys.getString(pkTablePos)
        )
    }
    return tmp.toTypedArray()
}