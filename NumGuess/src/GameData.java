public class GameData {
    private String  numGuessed,result;
    public GameData(String numGuessed,String result)
    {
        this.numGuessed=numGuessed;
        this.result=result;
    }
    public String getData(int k)
    {
         return k==0?numGuessed:result;
    }
}
