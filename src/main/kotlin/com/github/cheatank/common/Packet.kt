package com.github.cheatank.common

import com.github.cheatank.common.data.PacketData
import com.github.cheatank.common.util.bytes
import com.github.cheatank.common.util.readInt
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
        fun fromByteArray(array: ByteArray): RawPacket {
            return RawPacket(array.readShort(0), array.readInt(2), array.copyOfRange(6, array.size))
        }


        fun <T : PacketData> toByteArray(type: PacketType<T>, data: T): ByteArray {
            val array = type.converter.toByteArray(data)
            return byteArrayOf(*type.id.bytes(), *array.size.bytes(), *array)
        }
    }
}
