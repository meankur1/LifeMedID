package com.medallies.lifemedid.dto.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The type Request params.
 */
@XmlRootElement(name = "requestParams")
//@XmlAccessorType(XmlAccessType.FIELD)
public class RequestParams {

    /**
     * The constant logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(RequestParams.class);

    /**
     * The Is error.
     */
    private boolean isError;

    /**
     * The Is delete all.
     */
    private boolean isDeleteAll;

    /**
     * The Page size.
     */
    private Integer pageSize;

    /**
     * The Start limit.
     */
    private Long startLimit;

    /**
     * The End limit.
     */
    private Long endLimit;

    /**
     * The Id. This Id can be mechanic id or ticket id
     */
    private Integer id;

    /**
     * The Status.
     */
    private String status;

    /**
     * The Token.
     */
    private String token;

    /**
     * Instantiates a new Request params.
     */
    public RequestParams () {
        logger.debug("Class initiated" + this.getClass( ).getCanonicalName( ));
    }

    /**
     * Is error.
     *
     * @return the boolean
     */
    @XmlElement(name = "isError")
    public boolean isError () {
        return isError;
    }

    /**
     * Sets is error.
     *
     * @param isError the is error
     */
    public void setIsError (final boolean isError) {
        this.isError = isError;
    }

    /**
     * Is delete all boolean.
     *
     * @return the boolean
     */
    @XmlElement(name = "isDeleteAll")
    public boolean isDeleteAll () {
        return isDeleteAll;
    }

    /**
     * Sets delete all.
     *
     * @param deleteAll the delete all
     */
    public void setDeleteAll (boolean deleteAll) {
        isDeleteAll = deleteAll;
    }

    /**
     * Gets page size.
     *
     * @return the page size
     */
    @XmlElement(name = "pageSize")
    public Integer getPageSize () {
        return pageSize;
    }

    /**
     * Sets page size.
     *
     * @param pageSize the page size
     */
    public void setPageSize (final Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * Gets start limit.
     *
     * @return the start limit
     */
    @XmlElement(name = "startLimit")
    public Long getStartLimit () {
        return startLimit;
    }

    /**
     * Sets start limit.
     *
     * @param startLimit the start limit
     */
    public void setStartLimit (final Long startLimit) {
        this.startLimit = startLimit;
    }

    /**
     * Gets end limit.
     *
     * @return the end limit
     */
    @XmlElement(name = "endLimit")
    public Long getEndLimit () {
        return endLimit;
    }

    /**
     * Sets end limit.
     *
     * @param endLimit the end limit
     */
    public void setEndLimit (final Long endLimit) {
        this.endLimit = endLimit;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    @XmlElement(name = "id")
    public Integer getId () {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId (final Integer id) {
        this.id = id;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    @XmlElement(name = "status")
    public String getStatus () {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus (String status) {
        this.status = status;
    }

    /**
     * Gets token.
     *
     * @return the token
     */
    @XmlElement(name = "token")
    public String getToken () {
        return token;
    }

    /**
     * Sets token.
     *
     * @param token the token
     */
    public void setToken (String token) {
        this.token = token;
    }


    /**
     * Validate paging boolean.
     *
     * @return the boolean
     */
    public boolean validatePaging () {
        Long startLimit = this.getStartLimit( ),
                endLimit = this.getEndLimit( );
        Integer pageSize = this.getPageSize( );

        if (startLimit == null && endLimit != null) {
            return false;
        } else if (startLimit == null & pageSize != null) {
            return false;
        } else if (startLimit != null && endLimit == null && pageSize == null) {
            return false;
        } else if (( startLimit != null && startLimit < 0 ) ||
                ( endLimit != null && endLimit < 0 ) ||
                ( pageSize != null && pageSize < 0 )) {
            return false;
        }
        return true;
    }

}
