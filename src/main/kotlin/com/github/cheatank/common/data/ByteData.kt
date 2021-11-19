package com.github.cheatank.common.data

import com.google.common.io.ByteStreams

/**
 * バイトデータ
 */
data class ByteData(val byte: Byte) : PacketData {
    companion object : PacketData.Converter<ByteData> {
        @Suppress("UnstableApiUsage")
        override fun toByteArray(data: ByteData): ByteArray {
            return ByteStreams.newDataOutput().apply {
                writeByte(data.byte.toInt())
            }.toByteArray()
        }

        @Suppress("UnstableApiUsage")
        override fun fromByteArray(array: ByteArray): ByteData {
            return ByteStreams.newDataInput(array).run {
                ByteData(readByte())
            }
        }
    }
}
