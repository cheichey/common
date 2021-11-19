package com.github.cheatank.common

import com.github.cheatank.common.data.EmptyPacketData
import com.github.cheatank.common.data.PacketData

/**
 * 受信したパケット
 *
 * @property id
 * @property size
 * @property array
 */
class RawPacket(val id: Short, val size: Int, val array: ByteArray) {
    /**
     * [Packet] に変換する
     */
    fun <T : PacketData> toPacket(type: PacketType<T>): Packet<T>? {
        val converter = type.converter
        return if (size == 0) {
            EmptyPacketData
        } else {
            converter.fromByteArray(array)
        }?.let { data ->
            Packet(type, data)
        }
    }
}
