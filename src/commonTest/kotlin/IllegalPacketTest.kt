import com.github.cheatank.common.Packet
import com.github.cheatank.common.PacketType
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class IllegalPacketTest {
    @Test
    fun too_short_ByteArray_is_null() {
        assertNull(Packet.fromByteArray(byteArrayOf()))
        assertNull(Packet.fromByteArray(byteArrayOf(0)))
        assertNotNull(Packet.fromByteArray(byteArrayOf(0, 0)))
    }

    @Test
    fun packet_using_mismatch_converter_is_null() {
        val rawPacket = Packet.fromByteArray(byteArrayOf(0, 0))
        assertNotNull(rawPacket)
        assertNotNull(rawPacket.toPacket(PacketType.GetVersion)) // Empty
        assertNull(rawPacket.toPacket(PacketType.SendVersion)) // Int
    }
}
