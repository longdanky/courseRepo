import javax.swing.table.*;
import java.util.ArrayList;

public class GameProcessTableModel extends AbstractTableModel {
    private ArrayList<GameData> dataList = new ArrayList<GameData>();
    private int columnNum=2,rowNum=0;
    public void changeModel(GameData gameData)
    {
        dataList.add(gameData);
        rowNum++;
        this.fireTableDataChanged();
    }
    public void clearData()
    {
        dataList.clear();
        rowNum=0;
        this.fireTableDataChanged();
    }
    public int getRowCount()
    {
        return rowNum;
    }

    public int getColumnCount()
    {
        return columnNum;
    }

    public Object getValueAt(int r, int c)
    {
        return dataList.get(r).getData(c);
    }
    public String getColumnName(int c)
    {
        return c==0?"inputNumber":"result";
    }
}
