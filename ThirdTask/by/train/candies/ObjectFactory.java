//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0-b170531.0717 
//         See <a href="https://jaxb.java.net/">https://jaxb.java.net/</a> 
//         Any modifications to this file will be lost upon recompilation of the source schema. 
//         Generated on: 2019.10.07 at 11:08:27 PM MSK 
//


package by.train.candies;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the by.train.candies package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: by.train.candies
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SweetStuff }
     * 
     */
    public SweetStuff createSweetStuff() {
        return new SweetStuff();
    }

    /**
     * Create an instance of {@link Candy }
     * 
     */
    public Candy createCandy() {
        return new Candy();
    }

    /**
     * Create an instance of {@link Kind }
     * 
     */
    public Kind createKind() {
        return new Kind();
    }

    /**
     * Create an instance of {@link Ingredients }
     * 
     */
    public Ingredients createIngredients() {
        return new Ingredients();
    }

    /**
     * Create an instance of {@link EnergyValue }
     * 
     */
    public EnergyValue createEnergyValue() {
        return new EnergyValue();
    }

    /**
     * Create an instance of {@link Production }
     * 
     */
    public Production createProduction() {
        return new Production();
    }

}
