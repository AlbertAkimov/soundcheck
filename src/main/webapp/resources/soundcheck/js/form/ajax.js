function testAjax() {

    var nameBand = $("#name").val();
    var dateBand = $("#dateBand").val();

    var json = {"nameBand" : nameBand, "dateBand" : dateBand};

    $.ajax({
       url: $("#addTme").attr("action"),
        data: JSON.stringify(json),
        type: "POST",

        beforeSend: function(xhr) {
            $("#bandInformation").html("Loading");
        },

        success: function (jr) {
            var respContent = "";

            respContent += "<span class='has-error'>name band is: [";
            respContent += jr + "]</span>";

            $("#bandInformation").html(respContent);
        }
    });
}

function validationAjax () {

    $.ajax({
        url: "/validate",
        data: ({band : $("#name").val()}),
        success: function(data) {
            $("#bandInformation").html(data);
        }
    });
}


// new test ajax

$(document).ready(function () {

    $("#addTime").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

});

function fire_ajax_submit() {

    var search = {};
    search["nameBand"] = $("#name").val();
    search["dateBand"] = $("#dateBand").val();
    search["startTime"] = $("#startTime").val();
    search["endTime"] = $("#endTime").val();
    //search["email"] = $("#email").val();

    $("#addBand").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/main/add",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "<h4>Ajax Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
            $('#bandInformation').html(json);

            console.log("SUCCESS : ", data);
            $("#addBand").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#bandInformation').html(json);

            console.log("ERROR : ", e);
            $("#addBand").prop("disabled", false);

        }
    });

}