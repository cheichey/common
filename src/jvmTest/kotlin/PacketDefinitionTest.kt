import com.github.cheatank.common.PacketSender
import com.github.cheatank.common.PacketType
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class PacketDefinitionTest {
    @Test
    fun check_PacketType_id_is_not_conflict() {
        val idList = mutableSetOf<Short>()
        PacketType::class.sealedSubclasses.forEach {
            val instance = it.objectInstance
            assertNotNull(instance)
            assertTrue(idList.add(instance.id), "PacketType#id is conflict. (${instance::class.java.simpleName})")
        }
    }

    @Test
    fun PacketType_sender_can_be_get() {
        PacketType::class.sealedSubclasses.forEach {
            val instance = it.objectInstance
            assertNotNull(instance)
            assertTrue(instance::class.annotations.filterIsInstance<PacketSender>().isNotEmpty(), "PacketSender is not set. (${instance::class.java.simpleName})")
        }
    }
}
