import com.github.cheatank.common.Packet
import com.github.cheatank.common.PacketType
import com.github.cheatank.common.data.ByteData
import com.github.cheatank.common.data.EmptyPacketData
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNotNull

class PacketTypeTest {
    @Test
    fun `GetVersionPacket can be converted`() {
        val packetType = PacketType.GetVersion
        assertEquals(0, packetType.id)
        val bytes = Packet.toByteArray(packetType, EmptyPacketData)
        assertEquals(6, bytes.size)
        val rawPacket = Packet.fromByteArray(bytes)
        assertEquals(0, rawPacket.id)
        assertEquals(0, rawPacket.size)
        assertEquals(0, rawPacket.array.size)
        val packet = rawPacket.toPacket(packetType)
        assertNotNull(packet)
        assertEquals(0, packet.type.id)
        val packetData = packet.data
        assertIs<EmptyPacketData>(packetData)
    }

    @Test
    fun `SendVersionPacket can be converted`() {
        val packetType = PacketType.SendVersion
        assertEquals(1, packetType.id)
        val bytes = Packet.toByteArray(packetType, ByteData(12))
        assertEquals(7, bytes.size)
        val rawPacket = Packet.fromByteArray(bytes)
        assertEquals(1, rawPacket.id)
        assertEquals(1, rawPacket.size)
        assertEquals(1, rawPacket.array.size)
        val packet = rawPacket.toPacket(packetType)
        assertNotNull(packet)
        assertEquals(1, packet.type.id)
        val packetData = packet.data
        assertIs<ByteData>(packetData)
        assertEquals(12, packetData.byte)
    }
}
