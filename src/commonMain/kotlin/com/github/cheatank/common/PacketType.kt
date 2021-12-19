package com.github.cheatank.common

import com.github.cheatank.common.data.ConfigData
import com.github.cheatank.common.data.EmptyPacketData
import com.github.cheatank.common.data.IntData
import com.github.cheatank.common.data.LocationData
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
    object SendVersion : PacketType<IntData>(1, IntData)

    /**
     * コンフィグの送信
     */
    @PacketSender(PacketSenderType.Server)
    object SendConfig : PacketType<ConfigData>(2, ConfigData)

    /**
     * プレイヤーの位置情報を更新
     */
    @PacketSender(PacketSenderType.Server)
    object UpdateLocation : PacketType<LocationData>(3, LocationData)

    /**
     * ゲームの開始
     */
    @PacketSender(PacketSenderType.Server)
    object StartGame : PacketType<EmptyPacketData>(4, EmptyPacketData)

    /**
     * ゲームの終了
     */
    @PacketSender(PacketSenderType.Server)
    object EndGame : PacketType<EmptyPacketData>(5, EmptyPacketData)

    /**
     * 待ち行列に参加
     */
    @PacketSender(PacketSenderType.Client)
    object JoinQueue : PacketType<EmptyPacketData>(6, EmptyPacketData)
}
