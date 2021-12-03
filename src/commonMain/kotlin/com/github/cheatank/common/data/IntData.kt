package com.github.cheatank.common.data

import com.github.cheatank.common.util.bytes
import com.github.cheatank.common.util.readInt

/**
 * 4バイトデータ
 */
data class IntData(val int: Int) : PacketData {
    companion object : PacketData.Converter<IntData> {
        override fun toByteArray(data: IntData): ByteArray {
            return data.int.bytes()
        }

        override fun fromByteArray(array: ByteArray): IntData {
            return IntData(array.readInt(0))
        }
    }
}
