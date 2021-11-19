package com.github.cheatank.common.data

/**
 * 空のパケット
 */
object EmptyPacketData : PacketData, PacketData.Converter<EmptyPacketData> {
    override fun toByteArray(data: EmptyPacketData): ByteArray {
        return ByteArray(0)
    }

    override fun fromByteArray(array: ByteArray): EmptyPacketData {
        return EmptyPacketData
    }
}
