import com.github.cheatank.common.Packet
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
}
