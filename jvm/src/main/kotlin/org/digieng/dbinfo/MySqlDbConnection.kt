package org.digieng.dbinfo

import java.sql.Connection
import java.sql.DriverManager
import java.util.*

@Suppress("unused")
class MySqlDbConnection(
    override val host: String,
    override val port: Int,
    override val user: String,
    override val password: String
) : DbConnection {
    internal var conn: Connection? = null
    override val isOpen: Boolean
        get() = conn != null
    override val dbFile: String = ""

    private fun open() {
        val connProps = Properties().apply {
            this["user"] = user
            this["password"] = password
        }

        if (!isOpen) conn = DriverManager.getConnection("jdbc:mysql://$host:$port", connProps)
    }

    private fun close() {
        conn?.close()
        conn = null
    }

    override fun use(block: () -> Unit) {
        open()
        block()
        close()
    }
}