import java.util.*;

public class GameLogical {
    private GameProcessTableFrame gameProcessTableFrame;
    private Random rand = new Random();
    //当前的4位随机数字
    private String currentSequence;
    private int tryTimes=0;
    ArrayList<Integer> list = new ArrayList<Integer>();
    private void initList()
    {
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
    }
    public GameLogical(String str)
    {
        initList();
        currentSequence=str;
    }
    public GameLogical(GameProcessTableFrame gameProcessTableFrame)
    {
        this.gameProcessTableFrame=gameProcessTableFrame;
        initList();
        currentSequence=numSequenceGen();
    }
    //返回响应结果
    public String getResult(String str)
    {
        int A=0,B=0;
        tryTimes++;
        for(int i = 0 ;i<4;i++)
        {
            if(currentSequence.substring(i,i+1).equals(str.substring(i,i+1)))
            {
                A++;
            }
            else if(currentSequence.contains(str.substring(i,i+1)))
            {
                B++;
            }
        }
        if(A==4)
        {
            if(gameProcessTableFrame!=null)
                gameProcessTableFrame.success();
            return A+"A"+B+"B";
        }
        if(tryTimes==6)
        {
            if(gameProcessTableFrame!=null)
                gameProcessTableFrame.fail(currentSequence);
            return A+"A"+B+"B";
        }
        return A+"A"+B+"B";
    }
     //产生不重复的4位数字序列
    public String numSequenceGen()
    {
         String tempStr = "";
         for(int i=0;i<4;i++)
         {
             int k = rand.nextInt(list.size());
             tempStr += list.get(k);
             list.remove(k);
         }
         return tempStr;
    }
}
