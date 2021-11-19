package com.github.cheatank.common

/**
 * パケットの送信元
 */
enum class PacketSender {
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
