package org.digieng.dbinfo

import org.digieng.dbinfo.column.ColumnInfo
import org.digieng.dbinfo.index.ForeignKeyInfo
import org.digieng.dbinfo.index.PrimaryKeyInfo

@Suppress("ArrayInDataClass")
data class TableInfo(
    val name: String,
    val columns: Array<ColumnInfo>,
    val primaryKeys: Array<PrimaryKeyInfo> = emptyArray(),
    val foreignKeys: Array<ForeignKeyInfo> = emptyArray()
)