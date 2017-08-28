


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
    band["startTime"] = $("#startTime").val();
    band["endTime"] = $("#endTime").val();
    band["comment"] = $("#view").val();

    if( band.nameBand === "" ||
        band.dateBand === "" ||
        band.startTime === "" ||
        band.endTime === "") {

        return;
    }

    else {
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

                if (data.status === "SUCCESS") {
                    $('#success').html("Ваша заявка принята, спасибо.");
                    $('#start-time').html("");
                    $('#end-time').html("");
                    $('#date-error').html("");
                }

                else {
                    for (i = 0; data.result.length; i++) {

                        if (data.result[i].field === "startTime") {
                            $('#start-time').html(data.result[i].code);
                        }

                        if (data.result[i].field === "endTime") {
                            $('#end-time').html(data.result[i].code);
                        }

                        if (data.result[i].field === "dateBand") {
                            $("#date-error").html(data.result[i].code);
                        }
                    }

                    $("#success").html("Ошибка обработки запроса.")
                }
            },
            error: function (e) {

                var json = "<h4>Ajax Response</h4><pre>"
                    + e.responseText + "</pre>";
                $('#success').html(json);

                console.log("ERROR : ", e);
                $("#add-band").prop("disabled", false);

            }
        });
    }
}