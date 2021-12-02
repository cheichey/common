package com.github.cheatank.common.data

/**
 * パケットデータ
 */
sealed interface PacketData {
    /**
     * [PacketData] と [ByteArray] の変換を行うクラス
     */
    interface Converter<T : PacketData> {
        /**
         * [PacketData] を [ByteArray] に変換する
         */
        fun toByteArray(data: T): ByteArray

        /**
         * [ByteArray] を [PacketData] に変換する
         */
        fun fromByteArray(array: ByteArray): T?
    }
}
