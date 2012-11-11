import  java.util.*;
public class ParkingArea {
    private int posLeft;
    private int posTotal;
    private List<String> posArray = new ArrayList<String>();
    public ParkingArea(int posNum)
    {
        this.posLeft=posNum;
        this.posTotal=posNum;
    }
    public int showPosLeft()
    {
        return posLeft;
    }
    //park car
    public boolean parkCar(String carNumber)
    {
        if(posLeft==0)
            return false;
        else
        {
            posArray.add(carNumber);
            posLeft--;
            return  true;
        }
    }
    //get car
    public boolean getCar(String carNumber)
    {
        if(posArray.size()==0)
            return false;
        else
        {
            if(posArray.remove(carNumber))
            {
                posLeft++;
                return true;
            }
            return false;
        }
    }
}
