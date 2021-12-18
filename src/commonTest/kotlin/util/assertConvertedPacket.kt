package util

import com.github.cheatank.common.Packet
import com.github.cheatank.common.PacketType
import com.github.cheatank.common.data.PacketData
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNotNull

inline fun <reified T : PacketData> assertConvertedPacket(packetType: PacketType<T>, data: T, size: Int) {
    val bytes = Packet.toByteArray(packetType, data)
    assertEquals(size, bytes.size)
    val rowPacket = Packet.fromByteArray(bytes)
    assertNotNull(rowPacket)
    assertEquals(packetType.id, rowPacket.id)
    assertEquals(size - 2, rowPacket.array.size)
    val packet = rowPacket.toPacket(packetType)
    assertNotNull(packet)
    assertEquals(packetType.id, packet.type.id)
    val packetData = packet.data
    assertIs<T>(packetData)
    assertEquals(packetData, data)
}
