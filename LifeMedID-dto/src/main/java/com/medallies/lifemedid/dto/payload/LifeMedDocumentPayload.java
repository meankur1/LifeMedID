package com.medallies.lifemedid.dto.payload;

import com.medallies.lifemedid.dto.LifeMedDocument;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.List;

/**
 * The type Life med document payload.
 *
 * @param <T> the type parameter
 */
@XmlSeeAlso(value = { Payload.class, LifeMedDocument.class })
@XmlRootElement
public class LifeMedDocumentPayload<T> extends Payload<T> {

    /**
     * The T list.
     */
    private List<T> tList;

    /**
     * Gets t list.
     *
     * @return the t list
     */
    @XmlElement(name = "LifeMedDocument")
    public List<T> getTList () {
        return tList;
    }

    /**
     * Sets t list.
     *
     * @param tList the t list
     */
    public void setTList (List<T> tList) {
        this.tList = tList;
    }
}
