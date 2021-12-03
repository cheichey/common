package com.github.cheatank.common

import com.github.cheatank.common.data.PacketData

/**
 * 受信したパケット
 *
 * @property id
 * @property array
 */
class RawPacket(val id: Short, val array: ByteArray) {
    /**
     * [Packet] に変換する
     */
    fun <T : PacketData> toPacket(type: PacketType<T>): Packet<T>? {
        val converter = type.converter
        return converter.fromByteArray(array)?.let { data ->
            Packet(type, data)
        }
    }
}
