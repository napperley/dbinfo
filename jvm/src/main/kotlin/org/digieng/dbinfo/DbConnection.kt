package org.digieng.dbinfo

actual interface DbConnection {
    actual val dbFile: String
    actual val host: String
    actual val port: Int
    actual val user: String
    actual val password: String
    actual val isOpen: Boolean

    actual fun use(block: () -> Unit)
}