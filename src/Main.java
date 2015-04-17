import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.DOMBuilder;
import org.jdom2.input.SAXBuilder;



public class Main {
	public static void main(String args[])
	{
		SAXBuilder saxB = new SAXBuilder();
		try {
			Document document = saxB.build("test/tp.xml.xmf");
			Element textureAtlas = document.getRootElement();
			Attribute imagePath = textureAtlas.getAttribute("imagePath");
			List<Element> sprite = textureAtlas.getChildren();
			System.out.println(imagePath.getValue()+"\nformat: RGBA8888\nfilter: Linear,Linear\nrepeat: none");
			for(Element e : sprite)
			{
				System.out.println(e.getAttributeValue("n"));
				System.out.println("\trotate: false");
				System.out.println("\txy: "+e.getAttributeValue("x") +", "+ e.getAttributeValue("y"));
				System.out.println("\tsize: "+e.getAttributeValue("w")+", "+e.getAttributeValue("h"));
				System.out.println("\torig: "+e.getAttributeValue("w") + "," + e.getAttributeValue("h"));
				System.out.println("\toffset: 0, 0");
				System.out.println("\tindex: -1");
			}
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
