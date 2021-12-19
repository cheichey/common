package com.github.cheatank.common.data

import com.github.cheatank.common.util.bytes
import com.github.cheatank.common.util.readLocationData

/**
 * プレイヤーの位置情報
 *
 * @property id プレイヤーの識別子
 * @property x x座標
 * @property y y座標
 * @property yaw 銃口の角度
 *
 * @see com.github.cheatank.common.PacketType.UpdateLocation
 */

data class LocationData(
    val id: Short,
    val x: Int,
    val y: Int,
    val yaw: Int,
) : PacketData {
    companion object : PacketData.Converter<LocationData> {
        override fun toByteArray(data: LocationData): ByteArray {
            return byteArrayOf(
                *data.id.bytes(),
                *data.x.bytes(),
                *data.y.bytes(),
                *data.yaw.bytes(),
            )
        }

        override fun fromByteArray(array: ByteArray): LocationData? {
            return array.readLocationData(0)
        }
    }
}
