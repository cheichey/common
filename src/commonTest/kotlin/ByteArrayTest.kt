import com.github.cheatank.common.util.bytes
import com.github.cheatank.common.util.readInt
import kotlin.test.Test
import kotlin.test.assertEquals

class ByteArrayTest {
    private fun assertConvert(expected: Int) {
        assertEquals(expected, expected.bytes().readInt(0))
    }

    @Test
    fun array_can_be_converted() {
        assertConvert(Int.MAX_VALUE)
        assertConvert(Int.MIN_VALUE)
        assertConvert(0)
    }
}
