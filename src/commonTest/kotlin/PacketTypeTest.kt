
import com.github.cheatank.common.PacketType
import com.github.cheatank.common.data.ConfigData
import com.github.cheatank.common.data.EmptyPacketData
import com.github.cheatank.common.data.IntData
import com.github.cheatank.common.data.PlayerData
import util.assertConvertedPacket
import kotlin.test.Test
import kotlin.test.assertEquals

class PacketTypeTest {
    @Test
    fun GetVersionPacket_can_be_converted() {
        val packetType = PacketType.GetVersion
        assertEquals(0, packetType.id)
        assertConvertedPacket(packetType, EmptyPacketData, 2)
    }

    @Test
    fun SendVersionPacket_can_be_converted() {
        val packetType = PacketType.SendVersion
        assertEquals(1, packetType.id)
        val version = IntData(12)
        assertConvertedPacket(packetType, version, 6)
    }

    @Test
    fun SendConfigPacket_can_be_converted() {
        val packetType = PacketType.SendConfig
        assertEquals(2, packetType.id)
        val configData = ConfigData(3, 100)
        assertConvertedPacket(packetType, configData, 5)
    }

    @Test
    fun SendPlayerData_can_be_converted() {
        val packetType = PacketType.SendPlayerData
        assertEquals(3, packetType.id)
        val playerData = PlayerData(1, 2, 3, 4, 5)
        assertConvertedPacket(packetType, playerData, 19)
    }

    @Test
    fun StartGame_can_be_converted() {
        val packetType = PacketType.StartGame
        assertEquals(4, packetType.id)
        assertConvertedPacket(packetType, EmptyPacketData, 2)
    }

    @Test
    fun EndGame_can_be_converted() {
        val packetType = PacketType.EndGame
        assertEquals(5, packetType.id)
        assertConvertedPacket(packetType, EmptyPacketData, 2)
    }
}
