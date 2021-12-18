package com.github.cheatank.common.data

import com.github.cheatank.common.util.bytes
import com.github.cheatank.common.util.readUserData

/**
 * ユーザーの情報
 *
 * @see com.github.cheatank.common.PacketType.StartGame
 */

data class UserData(
    val id: Int,
    val xAxis: Int,
    val yAxis: Int,
    val direction: Int,
    val lifeCount: Byte,
) : PacketData {
    companion object : PacketData.Converter<UserData> {
        override fun toByteArray(data: UserData): ByteArray {
            return byteArrayOf(
                *data.id.bytes(),
                *data.xAxis.bytes(),
                *data.yAxis.bytes(),
                *data.direction.bytes(),
                data.lifeCount
            )
        }

        override fun fromByteArray(array: ByteArray): UserData? {
            return array.readUserData(0)
        }
    }
}
