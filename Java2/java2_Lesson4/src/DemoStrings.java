import java.applet.Applet;
import java.awt.*;


public class DemoStrings extends Applet {

	@Override
	public void start(){

	}

	public void paint(Graphics g){
		int y = 15;
		String str = "Java is hot";
		g.drawString(str, 10, y*1);

		String java = str.substring(0,6);
		g.drawString("The method substring - from index 0 to 6 gives: " + java, 10, y*2);
		int len = "Hot Java".length();
		g.drawString("The length of the string HotJava is: " + len, 10, y*4);
		String obj = new String("A String is an Object");
		g.drawString(obj, 10, y*6);
		String word = "Mississippi";
		g.drawString(word,  10,  y*8);
		g.drawString(word.replace('i', 'a'),10, y*9);
		g.drawString(word.toUpperCase(), 10, y*10);
		g.drawString("The original word is still: " +word, 10, y*12);

	}

}
