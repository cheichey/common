package com.github.cheatank.common

import com.github.cheatank.common.data.ByteData
import com.github.cheatank.common.data.EmptyPacketData
import com.github.cheatank.common.data.PacketData

/**
 * パケットの種類
 *
 * @property id パケットの識別子
 * @property converter パケットの変換を行うクラス
 */
sealed class PacketType<T : PacketData>(val id: Short, val converter: PacketData.Converter<T>) {
    /**
     * バージョンの取得
     */
    @PacketSender(PacketSenderType.Client)
    object GetVersion : PacketType<EmptyPacketData>(0, EmptyPacketData)

    /**
     * バージョンの送信
     */
    @PacketSender(PacketSenderType.Server)
    object SendVersion : PacketType<ByteData>(1, ByteData)
}
