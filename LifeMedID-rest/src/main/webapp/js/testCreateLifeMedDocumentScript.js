var baseURL = "http://localhost:8080/LifeMedID/api/";

$(document).ready(function () {

    //$("#document").on("click", function () {
    //    console.log("Login Clicked");
    //    ajax.startLoginRequest();
    //});

    $("#document").on("click", function () {
        console.log("Document Clicked");
        ajax.startDocumentRequest();
    });
});

var ajax = {

    startDocumentRequest: function () {


        // Note Ticket Status Information
        var scope = this,
            data = {
                uploader: {
                    transactionID: "b3a59d45-6fbb-1014-a7a4-dfe5ca3b7ee6",
                    registarID: "v2015",
                    orgID: "22042-3307"
                },
                IDPdocs: [{
                    suffix: "Mr",
                    firstName: "Frederick",
                    licenseNumber: "FF-236-887-9906",
                    lastName: "Flintstone",
                    dateOfBirth: "1978-11-22",
                    issuingAuthority: "IL",
                    docIssuer: 'IL',
                    docExpirationDate: "2018-04-13",
                    docIssuanceDate: "2016-04-13",
                    gender: "F",
                    middleName: "J",
                    docType: 'A1',
                    docTitle: 'Passport',
                    docId: 'PP-465-67-6546'
                }],
                applicant: {
                    suffix: "Mr",
                    firstName: "Freddy",
                    lastName: "Flintstone",
                    dateOfBirth: "1978-11-22",
                    id: "12345",
                    middleName: "J",
                    gender: "F",
                    levelOfAssurance: "level3"
                }
            },
            typeofRequest = "POST",
            url = "api/document/lifemeddocument";
        //url = baseURL + url;
        console.log("Url is " + url);
        ajax.customAjaxRequest(url, data, typeofRequest, scope);

    },

    customAjaxRequest: function (url, data, typeOfReq, scope) {

        var authorizationToken = "KX8WUrZLCcY7JioM4HamHA==";
        count++;
        $.ajax({

            url: url,
            data: data != null ? JSON.stringify(data) : null,
            method: typeOfReq,
            contentType: "application/json",
            dataType: 'json',
            beforeSend: function (request) {
                if (count % 2 == 0) {
                    request.setRequestHeader("Authority", authorizationToken);
                    request.setRequestHeader("Authorization", "Basic " + authorizationToken);
                    //request.setRequestHeader("Access-Control-Allow-Headers" ,"Origin, X-Requested-With, Content-Type, Accept Authority Authorization" );
                }
            },
            success: function (data) {
                console.log(data);
            },
            error: function (obj1, obj2, obj3) {

            },
            callback: function (data) {
                console.log(data);
            }
        });

    }
};
var count = 0;