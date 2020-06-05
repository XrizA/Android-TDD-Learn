import order.IEmailUtil
import order.Order
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class OrderTest {

    @Mock
    lateinit var mockEmailUtil: IEmailUtil

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun insertOrder() {
        val order = Order()
        val mockEmailUtil = MockEmailUtil()

        val userEmail = "someMail@gmail.com"
        order.insertOrder(userEmail, 1, 200, mockEmailUtil)

        //用mockEmailUtil.receiveEmail來驗證order.insert裡是否有呼叫IEmailUtil.setCustomer
        Assert.assertEquals(userEmail, mockEmailUtil.receiveEmail)
    }

    @Test
    fun insertOrder_mockito() {
        val order = Order()
        val mockEmailUtil = mock(IEmailUtil::class.java)

        val userEmail = "someMail@gmail.com"
        order.insertOrder(userEmail, 1, 200, mockEmailUtil)

        //驗證是否有呼叫sendCustomer，並傳入正確的userEmail
        verify(mockEmailUtil).sendCustomer(userEmail)
    }

    @Test
    fun insertOrder_mockito_simplify() {
        val order = Order()

        val userEmail = "someMail@gmail.com"
        order.insertOrder(userEmail, 1, 200, mockEmailUtil)

        //驗證是否有呼叫sendCustomer，並傳入正確的userEmail

        // 驗證呼叫1次
        verify(mockEmailUtil, times(1)).sendCustomer(userEmail)
        // 驗證不能呼叫此方法
        //verify(mockEmailUtil, never()).sendCustomer(userEmail)
        // 驗證最少呼叫1次
        //verify(mockEmailUtil, atLeast(1)).sendCustomer(userEmail)
        // 驗證最多呼叫1次
        //verify(mockEmailUtil, atMost(1)).sendCustomer(userEmail)
        // any 方法
        //verify(mockEmailUtil).sendCustomer(ArgumentMatchers.any())
    }
}