import com.example.btcPriceCall
import com.example.plugins.configureRouting
import com.example.usdPriceCall
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ApplicationTest {

    @Test
    fun testBTC() = testApplication {
        application {
            configureRouting()
        }
        val response = client.get("/convert/btc?value=1")
        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals(btcPriceCall(), response.bodyAsText().toDouble(), 0.1)
    }

    @Test
    fun testMinute() = testApplication {
        application {
            configureRouting()
        }
        val response = client.get("/convert/usd?value=1")
        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals(usdPriceCall(), response.bodyAsText().toDouble(), 0.00001)
    }

    @Test
    fun testT() = testApplication {
        application {
            configureRouting()
        }
        var response = client.get("/convert/btc?=17")
        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("ERROR: No input value", response.bodyAsText())

        response = client.get("/convert/btc?value=Seventeen")
        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("ERROR: input value is not a number", response.bodyAsText())
    }
}