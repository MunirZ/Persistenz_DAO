package dataLayer.dataAccessObjects;

import Kaufvertrag.businessObjects.IWare;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public interface IWareDao {
    public IWare create() throws ParserConfigurationException;
    public IWare create(IWare ware);
    public List<IWare> read();
    public IWare read(int id);
    public void update(IWare ware);
    public void delete(int id) throws ParserConfigurationException, IOException, SAXException;
}
