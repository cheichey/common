package com.github.cheatank.common.data

import com.github.cheatank.common.util.bytes
import com.github.cheatank.common.util.readPlayerData

/**
 * プレイヤーの情報
 *
 * @property id プレイヤーの識別子
 * @property x x座標
 * @property y y座標
 * @property direction 銃口の角度
 *
 * @see com.github.cheatank.common.PacketType.SendPlayer
 */

data class PlayerData(
    val id: Short,
    val x: Int,
    val y: Int,
    val direction: Int,
) : PacketData {
    companion object : PacketData.Converter<PlayerData> {
        override fun toByteArray(data: PlayerData): ByteArray {
            return byteArrayOf(
                *data.id.bytes(),
                *data.x.bytes(),
                *data.y.bytes(),
                *data.direction.bytes(),
            )
        }

        override fun fromByteArray(array: ByteArray): PlayerData? {
            return array.readPlayerData(0)
        }
    }
}
