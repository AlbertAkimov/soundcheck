window.onload = function () {

    var dateBand = document.querySelector('input[name=dateBand]');
    var startTime = document.querySelector('input[name=startTime]');
    var endTime = document.querySelector('input[name=endTime]');

    document.querySelector('#submit').onclick = function () {
        var params = 'dateBand' + dateBand + '&' + 'startTime' + startTime + '&' + 'endTime' + endTime;
        //alert(dateBand.value);
        methodPost(params);
    }
};

function methodPost(params) {

    var request = new XMLHttpRequest();

    request.onreadystatechange = function () {
        if(request.readyState === 4 && request.status === 200) {
            document.querySelector('test').innerHTML = request.responseText;
        }
    };

    request.open('POST', '/main/add');
    request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
}