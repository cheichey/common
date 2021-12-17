package com.github.cheatank.common.data

import com.github.cheatank.common.util.bytes
import com.github.cheatank.common.util.readShort

/**
 * ゲームの設定
 *
 * @see com.github.cheatank.common.PacketType.SendConfig
 */
data class ConfigData(
    val lifeCount: Byte,
    val timeLimit: Short,
) : PacketData {
    companion object : PacketData.Converter<ConfigData> {
        override fun toByteArray(data: ConfigData): ByteArray {
            return byteArrayOf(
                data.lifeCount,
                *data.timeLimit.bytes(),
            )
        }

        override fun fromByteArray(array: ByteArray): ConfigData? {
            val lifeCount = array.getOrNull(0) ?: return null
            val timeLimit = array.readShort(1) ?: return null
            return ConfigData(lifeCount, timeLimit)
        }
    }
}
