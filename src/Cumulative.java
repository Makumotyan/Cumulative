import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Cumulative{
	public static long CountNumberOfTextLines(String filePath){
        long lineCount = 0;
        long lineCount2 = 0;
        int z = 0;
        int y = 0;
        int y2 = 0;
        BufferedReader br = null;

        try{
            FileReader fr = new FileReader(filePath);
            		br = new BufferedReader(fr);
            String line;
			line = br.readLine();

            while( line != null ){
  //////////////(　　　XX:XX　　　)形式//////////////
                lineCount++;
                String t = line;
                t = t+"                                                      ";
                //":"の総履歴葉
                char a = t.charAt(2);
                char d = t.charAt(1);
                //
                String b = t.substring(9,15);
                //String c = t.substring(0,12);
                //String d = t.substring(0,13);
                //String f = t.substring(0,14);
                //3文字目が":"でないときにこの処理
                if(a != ':'){
                	lineCount = lineCount-1;
                	y++;
                }
                else if(a == ':' || d == ':'){
                	z++;
                }
  //////////////(　　　X:XX　　　)形式//////////////
                lineCount2++;
                String t2 = line;
                t2 = t2+"                                                      ";
                if(d != ':'){
                	lineCount2 = lineCount2-1;
                	y2++;
                }
                else if(d == ':'){
                	z++;
                }

                line = br.readLine();
            }
        }
		catch( FileNotFoundException e ){
            System.out.println(e);
		}
        catch( IOException e ){
            System.out.println(e);
        }
        finally{
        	try{
                if( br != null )
            		br.close();
            }
            catch( IOException e ){
	            System.out.println(e);
            }
        }
        System.out.println("送受信数:"+lineCount);
        System.out.println("送受信数:"+lineCount2);
        System.out.println("合計送受信数:"+(lineCount+lineCount2));
        System.out.println("写真、スタンプ、通話等を含む");
        //System.out.println(z);
        //System.out.println(y);
        //System.out.println(y2);
        return lineCount;
	}

	public static void main(String[] args) {
		CountNumberOfTextLines("20170331.txt");
	}
}