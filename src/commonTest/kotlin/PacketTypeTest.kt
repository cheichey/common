
import com.github.cheatank.common.PacketType
import com.github.cheatank.common.data.ConfigData
import com.github.cheatank.common.data.EmptyPacketData
import com.github.cheatank.common.data.IntData
import com.github.cheatank.common.data.PlayerData
import util.assertConvertedPacket
import kotlin.test.Test

class PacketTypeTest {
    @Test
    fun GetVersionPacket_can_be_converted() {
        assertConvertedPacket(PacketType.GetVersion, EmptyPacketData, 2)
    }

    @Test
    fun SendVersionPacket_can_be_converted() {
        assertConvertedPacket(PacketType.SendVersion, IntData(12), 6)
    }

    @Test
    fun SendConfigPacket_can_be_converted() {
        assertConvertedPacket(PacketType.SendConfig, ConfigData(3, 100), 5)
    }

    @Test
    fun SendPlayer_can_be_converted() {
        assertConvertedPacket(PacketType.SendPlayer, PlayerData(1, 2, 3, 4), 16)
    }

    @Test
    fun StartGame_can_be_converted() {
        assertConvertedPacket(PacketType.StartGame, EmptyPacketData, 2)
    }

    @Test
    fun EndGame_can_be_converted() {
        assertConvertedPacket(PacketType.EndGame, EmptyPacketData, 2)
    }

    @Test
    fun JoinQueue_can_be_converted() {
        assertConvertedPacket(PacketType.JoinQueue, EmptyPacketData, 2)
    }
}
