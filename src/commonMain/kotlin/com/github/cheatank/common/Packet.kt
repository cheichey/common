package com.github.cheatank.common

import com.github.cheatank.common.data.PacketData
import com.github.cheatank.common.util.bytes
import com.github.cheatank.common.util.readShort

/**
 * パケット
 *
 * @property type 種類
 * @property data データ
 */
data class Packet<T : PacketData>(
    val type: PacketType<T>,
    val data: PacketData,
) {
    companion object {
        /**
         * [ByteArray] から [RawPacket] に変換する
         */
        fun fromByteArray(array: ByteArray): RawPacket? {
            val arraySize = array.size
            if (arraySize < 2) return null
            return RawPacket(array.readShort(0), array.copyOfRange(2, arraySize))
        }

        fun <T : PacketData> toByteArray(type: PacketType<T>, data: T): ByteArray {
            val array = type.converter.toByteArray(data)
            return byteArrayOf(*type.id.bytes(), *array)
        }
    }
}
