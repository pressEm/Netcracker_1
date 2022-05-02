package contracts;

import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Interface is used to create all types of the contracts
 * @autor Valentina Filonova
 */
@XmlJavaTypeAdapter(Contract.Adapter.class)
public interface IContract {
    public int getID();
}
