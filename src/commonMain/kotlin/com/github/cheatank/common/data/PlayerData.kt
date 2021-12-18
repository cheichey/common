package com.github.cheatank.common.data

import com.github.cheatank.common.util.bytes
import com.github.cheatank.common.util.readPlayerData

/**
 * プレイヤーの情報
 *
 * @see com.github.cheatank.common.PacketType.SendPlayerData
 */

data class PlayerData(
    val id: Int,
    val xAxis: Int,
    val yAxis: Int,
    val direction: Int,
    val lifeCount: Byte,
) : PacketData {
    companion object : PacketData.Converter<PlayerData> {
        override fun toByteArray(data: PlayerData): ByteArray {
            return byteArrayOf(
                *data.id.bytes(),
                *data.xAxis.bytes(),
                *data.yAxis.bytes(),
                *data.direction.bytes(),
                data.lifeCount
            )
        }

        override fun fromByteArray(array: ByteArray): PlayerData? {
            return array.readPlayerData(0)
        }
    }
}
