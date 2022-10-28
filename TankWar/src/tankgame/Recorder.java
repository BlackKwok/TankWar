package tankgame;

import javax.xml.soap.Node;
import java.io.*;
import java.util.Vector;

/**
 * @author 郭润达
 * @version 1.0
 **/
public class Recorder {
    private static int allEnemyTanNum = 0; //击毁的坦克数量
    private static FileWriter fw = null;
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    private static String recordFile = "src\\myRecord.txt";
    private static Vector<Enemy> enemys = null;
    private static Vector<Node_> nodes = new Vector<>();

    public static void setEnemys(Vector<Enemy> enemys) {
        Recorder.enemys = enemys;
    }

    public static String getRecordFile() {
        return recordFile;
    }

    public static Vector<Node_> getNodesAndEnemyTankRec() {
        try {
            br = new BufferedReader(new FileReader(recordFile));
            allEnemyTanNum = Integer.parseInt(br.readLine());
            String line = "";
            while((line = br.readLine()) !=null) {
                String[] xyd = line.split(",");
                Node_ node = new Node_(Integer.parseInt(xyd[0]), Integer.parseInt(xyd[1]),
                        Integer.parseInt(xyd[2]));
                nodes.add(node);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (br !=null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return nodes;
    }

    public static void saveRecord() {

        try {
            bw = new BufferedWriter(new FileWriter(recordFile));
            bw.write(allEnemyTanNum + "\r\n");
            for (int i = 0; i < enemys.size(); i++) {
                Enemy enemy = enemys.get(i);
                if (enemy.isAlive) {
                    String record = enemy.getX() + "," + enemy.getY() + "," + enemy.getDirect();
                    bw.write(record + "\r\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getAllEnemyTanNum() {
        return allEnemyTanNum;
    }

    public static void setAllEnemyTanNum(int allEnemyTanNum) {
        Recorder.allEnemyTanNum = allEnemyTanNum;
    }

    public static void addAllEnemyTanNum() {
        Recorder.allEnemyTanNum++;
    }
}
