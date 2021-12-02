package com.github.cheatank.common.data

/**
 * バイトデータ
 */
data class ByteData(val byte: Byte) : PacketData {
    companion object : PacketData.Converter<ByteData> {
        override fun toByteArray(data: ByteData): ByteArray {
            return byteArrayOf(data.byte)
        }

        override fun fromByteArray(array: ByteArray): ByteData {
            return ByteData(array.first())
        }
    }
}
