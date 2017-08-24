


var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");

$(document).ajaxSend(function (e, xhr, options) {
    xhr.setRequestHeader(header, token);
});


$(document).ready(function () {

    $("#add-time").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

});

function fire_ajax_submit() {

    var band = {};
    band["nameBand"] = $("#name").val();
    band["dateBand"] = $("#date-band").val();

    //search["email"] = $("#email").val();

    $("#add-time").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/main/add/band",
        data: JSON.stringify(band),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "<h4>Ajax Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
            $('#feedback').html(json);

            console.log("SUCCESS : ", data);
            $("#add-band").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#add-band").prop("disabled", false);

        }
    });

}