package com.github.cheatank.common

/**
 * パケットの送信元の種類
 */
enum class PacketSenderType {
    /**
     * クライアント
     */
    Client,

    /**
     * サーバー
     */
    Server,

    /**
     * クライアント・サーバー
     */
    Both,
}
