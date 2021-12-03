package com.github.cheatank.common.util

import kotlin.experimental.and

/**
 * [ByteArray] から指定した [length] で整数値を取り出す。取り出せなければ null
 */
private fun ByteArray.read(length: Int, offset: Int): Int? {
    if ((size - offset) < length) return null
    var result = 0
    repeat(length) {
        result = result shl 8
        result = result or (get(it + offset) and 0xFF.toByte()).toInt()
    }
    return result
}

/**
 * [ByteArray] から [Short] のデータを取り出す。取り出せなければ null
 */
fun ByteArray.readShort(offset: Int): Short? {
    return read(2, offset)?.toShort()
}

/**
 * [ByteArray] から [Int] のデータを取り出す。取り出せなければ null
 */
fun ByteArray.readInt(offset: Int): Int? {
    return read(4, offset)
}

/**
 * [Short] を [ByteArray] として取得する
 */
fun Short.bytes() = byteArrayOf(
    ((toInt() shl 8) and 0xFF).toByte(),
    ((toInt() shl 0) and 0xFF).toByte()
)

/**
 * [Int] を [ByteArray] として取得する
 */
fun Int.bytes() = byteArrayOf(
    ((this shl 24) and 0xFF).toByte(),
    ((this shl 16) and 0xFF).toByte(),
    ((this shl 8) and 0xFF).toByte(),
    ((this shl 0) and 0xFF).toByte()
)
