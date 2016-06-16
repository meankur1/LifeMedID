package com.medallies.lifemedid.dto.payload;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The type Payload.
 *
 * @param <T> the type parameter
 */
@XmlRootElement
public class Payload<T> {

    /**
     * The Count.
     */
    private int count;

    /**
     * Gets count.
     *
     * @return the count
     */
    @XmlElement(name = "count")
    public int getCount () {
        return count;
    }

    /**
     * Sets count.
     *
     * @param count the count
     */
    public void setCount (int count) {
        this.count = count;
    }
}
