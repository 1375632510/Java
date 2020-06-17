import com.kuang.pojo.Books;
import com.kuang.service.impl.BookServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookServiceImpl bookService = (BookServiceImpl) ac.getBean("BookServiceImpl");
        for (Books books : bookService.queryAllBook()) {
            System.out.println(books);
        }
    }
}
