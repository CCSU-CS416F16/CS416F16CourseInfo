package edu.ccsu.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Chad Williams
 */
public class XmlCDDemo {

    public static void main(String[] args) {
        CDs cds = new CDs();
        CD cd = new CD("Green Day", "Dookie", 1994);
        cd.addMusician(new Musician("Billy Joe", "Armstrong"));
        cd.addMusician(new Musician("Tre", "Cool"));
        cds.cdList.add(cd);
        cd = new CD("Pearl Jam", "Ten", 1991);
        cd.addMusician(new Musician("Eddie", "Vedder"));
        cd.addMusician(new Musician("Mike", "McCready"));
        cds.cdList.add(cd);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(CDs.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(cds, System.out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
