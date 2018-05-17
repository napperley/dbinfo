package org.digieng.dbinfo.column

import java.sql.DatabaseMetaData

internal fun allMysqlColumns(schema: String, table: String, dbMetaData: DatabaseMetaData): Array<ColumnInfo> {
    val tmp = mutableListOf<ColumnInfo>()
    val nullable = 1
    val colNamePos = 4
    val colTypePos = 5
    val nullablePos = 11
    val colSizePos = 7
    val digitsPos = 9
    val columns = dbMetaData.getColumns(null, schema, table, null)

    while (columns.next()) {
        tmp += ColumnInfo(
            name = columns.getString(colNamePos),
            type = columnTypeName(columns.getInt(colTypePos)),
            nullable = columns.getInt(nullablePos) == nullable,
            size = columns.getInt(colSizePos),
            digits = columns.getInt(digitsPos)
        )
    }
    return tmp.toTypedArray()
}

internal fun singleMysqlColumn(
    schema: String,
    table: String,
    column: String,
    dbMetaData: DatabaseMetaData
): ColumnInfo? {
    var result: ColumnInfo? = null
    val nullable = 1
    val colNamePos = 4
    val colTypePos = 5
    val nullablePos = 11
    val colSizePos = 7
    val digitsPos = 9
    val rs = dbMetaData.getColumns(null, schema, table, column)

    if (rs.first()) {
        result = ColumnInfo(
            name = rs.getString(colNamePos),
            type = columnTypeName(rs.getInt(colTypePos)),
            nullable = rs.getInt(nullablePos) == nullable,
            size = rs.getInt(colSizePos),
            digits = rs.getInt(digitsPos)
        )
    }
    return result
}