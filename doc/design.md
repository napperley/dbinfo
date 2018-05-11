# DB Info (dbinfo-common) Design

This document provides details about the original design. Below are the basic design principals:

- Stick with SQL standards where possible
- Have a single implementation per DBMS loosely coupled from the design
- Separate DB elements (schema, table, column etc) into functionality

## API Structure

Root package is *org.digieng.dbinfo.common*. All APIs are structured around the DB elements by providing the following:

- DbConnection (interface)
  * dbFile (String val)
  * host (String val)
  * port (Int val)
  * user (String val)
  * password (String val)
  * use (function)
- table_meta (kt file)
  * tableExists (function)
  * allTables (function)
  * singleTable (function)
- TableInfo (data class)
  * name (String val)
  * primaryKeys (Array<PrimaryKeyInfo> val)
  * foreignKeys (Array<ForeignKeyInfo> val)
  * columns (Array<ColumnInfo> val)
- column.column_meta (kt file)
  * columnExists (function)
  * allColumns (function)
  * singleColumn (function)
- column.ColumnInfo (data class)
  * name (String val)
  * type (String val)
  * nullable (Boolean val)
  * size (Int val)
  * digits (Int val)
- index.index_meta (file)
  * allPrimaryKeys (function)
  * primaryKeyExists (function)
  * foreignKeyExists (function)
  * singleForeignKey (function)
  * allForeignKeys (function)
- index.PrimaryKeyInfo (data class)
  * colName (String val)
  * pkName (String val)
- index.ForeignKeyInfo (data class)
  * colName (String val)
  * pkTable (String val)
  * pkName (String val)
- column.ColumnType (enum)
