package com.github.cheatank.common

import com.github.cheatank.common.data.ByteData
import com.github.cheatank.common.data.EmptyPacketData
import com.github.cheatank.common.data.PacketData

/**
 * パケットの種類
 *
 * @property id パケットの識別子
 * @property sender パケットの送信元
 * @property converter パケットの変換を行うクラス
 */
sealed class PacketType<T : PacketData>(val id: Short, val sender: PacketSender, val converter: PacketData.Converter<T>) {
    /**
     * バージョンの取得
     */
    object GetVersion : PacketType<EmptyPacketData>(0, PacketSender.Client, EmptyPacketData)

    /**
     * バージョンの送信
     */
    object SendVersion : PacketType<ByteData>(1, PacketSender.Server, ByteData)
}
