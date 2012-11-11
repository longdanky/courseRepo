import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-11
 * Time: 下午3:20
 * To change this template use File | Settings | File Templates.
 */
public class ParkTest {
    private ParkingArea parkingArea;
    @Before
    public void init()
    {
        parkingArea=new ParkingArea(10);
    }
    @Test
    public void when_have_Post_should_return_can_park(){
        Assert.assertEquals(true,parkingArea.parkCar("A"));
    }

    @Test
    public void show_left_pos(){
        parkingArea.parkCar("A");
        Assert.assertEquals(8,parkingArea.showPosLeft());
    }
    @Test
    public void when_have_got_wrong_car(){
        parkingArea.parkCar("A");
        Assert.assertEquals(true,parkingArea.getCar("B"));
    }

    @Test
    public void when_get_car_successful(){
        parkingArea.parkCar("A");
        Assert.assertEquals(true,parkingArea.getCar("A"));
    }

    @Test
    public void when_continue_fetch(){
        parkingArea.parkCar("A");
        Assert.assertEquals(true,parkingArea.getCar("A"));
        Assert.assertEquals(true,parkingArea.getCar("A"));
    }
}
