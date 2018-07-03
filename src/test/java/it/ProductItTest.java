package it;

import com.pribas.controller.HttpRequest;
import org.junit.*;


public class ProductItTest {

    /*
    @BeforeClass
    public void initialize(){

    }

    @AfterClass
    public void destory(){

    }
    */

    @Test
    public void GetProductByNameTest() {
        HttpRequest request = new HttpRequest();
        Assert.assertEquals(200, request.getProductByName("test4"));
    }

    @Test
    public void GetListTest() {
        HttpRequest request = new HttpRequest();
        Assert.assertEquals(200, request.getProducts());
    }

    @Test
    public void GetNameTestWithoutExisting() {
        HttpRequest request = new HttpRequest();
        Assert.assertEquals(404, request.getProductByName("test4fasfsa"));
    }
    @Test
    public void AddingProductWithName()
    {
        HttpRequest request = new HttpRequest();
        Assert.assertEquals(200,request.addProduct("Testers"));
    }
    @Test
    public void AddingProductWithNameAndText()
    {
        HttpRequest request = new HttpRequest();
        Assert.assertEquals(200,request.addProduct("Test","20 cm"));
    }
}
