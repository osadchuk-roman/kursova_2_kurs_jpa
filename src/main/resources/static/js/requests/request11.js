var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request11 = [];
    var date1='2017-05-01';
    var date2='2019-01-01';
    $http.get('http://localhost:8080/api/request11?firstDate='+date1+'&secondDate='+date2)
        .then(function (response){
            $scope.request11=response.data;
            console.log(response);
            document.getElementById("FirstDate").value=date1;
            document.getElementById("SecondDate").value=date2;
        });

    this.update_request = function add() {
        date1= document.getElementById("FirstDate").value;
        date2= document.getElementById("SecondDate").value;
        $http.get('http://localhost:8080/api/request11?firstDate='+date1+'&secondDate='+date2)
            .then(function (response){
                $scope.request11=response.data;
                console.log(response);
            });
    };
});