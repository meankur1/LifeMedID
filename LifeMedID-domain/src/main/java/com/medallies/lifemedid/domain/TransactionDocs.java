package com.medallies.lifemedid.domain;

import javax.persistence.*;


@Entity
@Table(name = "transaction_docs", schema = "lifemedid")
public class TransactionDocs {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;


    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "transaction_id", referencedColumnName = "transaction_id")
    private LifeMedDocument lifeMedDocument;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "idpdoc_id", referencedColumnName = "id")
    private IDPDocument idpDocument;


    public long getId () {
        return id;
    }

    public void setId (long id) {
        this.id = id;
    }

    public LifeMedDocument getLifeMedDocument () {
        return lifeMedDocument;
    }

    public void setLifeMedDocument (LifeMedDocument lifeMedDocument) {
        this.lifeMedDocument = lifeMedDocument;
    }

    public IDPDocument getIdpDocument () {
        return idpDocument;
    }

    public void setIdpDocument (IDPDocument idpDocument) {
        this.idpDocument = idpDocument;
    }
}
