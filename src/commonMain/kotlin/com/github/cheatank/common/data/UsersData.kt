package com.github.cheatank.common.data

/**
 * 自分と相手
 *
 * @see com.github.cheatank.common.PacketType.StartGame
 */
data class UsersData(val me: UserData, val enemy: UserData) : PacketData {
    companion object : PacketData.Converter<UsersData> {
        override fun fromByteArray(array: ByteArray): UsersData? {
            val me = UserData.fromByteArray(array.take(17).toByteArray()) ?: return null
            val enemy = UserData.fromByteArray(array.drop(17).take(17).toByteArray()) ?: return null
            return UsersData(me, enemy)
        }

        override fun toByteArray(data: UsersData): ByteArray {
            return UserData.toByteArray(data.me).plus(UserData.toByteArray(data.enemy))
        }
    }
}
