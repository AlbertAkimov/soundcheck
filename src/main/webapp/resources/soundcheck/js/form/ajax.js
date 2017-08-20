window.onload = function () {

    var formDateBand = document.querySelector('input[name=dateBand]');


    document.querySelector('#submit').onclick = function () {
        alert(formDateBand.value);
    }
}