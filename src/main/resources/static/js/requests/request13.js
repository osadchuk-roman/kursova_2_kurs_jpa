var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request13 = [];
    var date1='2017-01-01';
    var date2='2019-01-01';
    $http.get('http://localhost:8080/api/request13?firstDate='+date1+'&secondDate='+date2)
        .then(function (response){
            $scope.request13=response.data;
            console.log(response);
            document.getElementById("FirstDate").value=date1;
            document.getElementById("SecondDate").value=date2;
        });

    this.update_request = function add() {
        date1= document.getElementById("FirstDate").value;
        date2= document.getElementById("SecondDate").value;
        var isValid=true;
        var errorMessage='Помилка: неправильні вхідні дані!\n';
        var regex=/^20[0-9][0-9]-((0[1-9])|(1[0-2]))-((0[1-9])|([12][0-9])|(3[01]))$/ ;
        if(!regex.test(date1)||!regex.test(date2)){
            errorMessage=errorMessage+'-невірний формат дати змагання;\n';
            errorMessage=errorMessage+'Потріббний формат yyyy-mm-dd (рік-місяць-день);';
            isValid=false;
        }
        if (isValid) {
            $http.get('http://localhost:8080/api/request13?firstDate=' + date1 + '&secondDate=' + date2)
                .then(function (response) {
                    $scope.request13 = response.data;
                    console.log(response);
                });
        }
        else window.alert(errorMessage);
    };
});