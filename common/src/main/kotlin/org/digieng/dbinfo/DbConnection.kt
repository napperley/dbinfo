package org.digieng.dbinfo

expect interface DbConnection {
    val dbFile: String
    val host: String
    val port: Int
    val user: String
    val password: String
    val isOpen: Boolean

    fun use(block: () -> Unit)
}