package com.github.cheatank.common

import com.github.cheatank.common.data.PacketData
import com.google.common.io.ByteStreams

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
        @Suppress("UnstableApiUsage")
        fun fromByteArray(array: ByteArray): RawPacket {
            return ByteStreams.newDataInput(array).run {
                val id = readShort()
                val size = readInt()
                RawPacket(id, size, ByteArray(size).apply { readFully(this) })
            }
        }

        /**
         * [PacketData] を [ByteArray] に変換する
         */
        @Suppress("UnstableApiUsage")
        fun <T : PacketData> toByteArray(type: PacketType<T>, data: T): ByteArray {
            return ByteStreams.newDataOutput().apply {
                writeShort(type.id.toInt())
                type.converter.toByteArray(data).run {
                    writeInt(size)
                    write(this)
                }
            }.toByteArray()
        }
    }
}
