package org.digieng.dbinfo.column

data class ColumnInfo(val name: String, val type: String, val nullable: Boolean, val size: Int, val digits: Int = 0)