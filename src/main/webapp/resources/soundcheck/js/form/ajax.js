


var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");

$(document).ajaxSend(function (e, xhr, options) {
    xhr.setRequestHeader(header, token);
});


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
    search["email"] = $("#email").val();

    $("#addBand").prop("disabled", true);

    $.ajax({
        type: "POST",
        url: "/main/add/band",
        data: JSON.stringify({ band : search}),
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        //cache: false,
        //timeout: 600000,
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