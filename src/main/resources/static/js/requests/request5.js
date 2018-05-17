var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request5 = [];
    var sportsman_id=1;
    $http.get('http://localhost:8080/api/request5?sportsman_id='+sportsman_id).then(function (response){
        $scope.request5=response.data;
        console.log(response);
        $http.get('/api/sportsman').then(function (response){
            var sportsman = response.data;
            var selector = document.getElementById("Sportsman");
            $(selector).empty();
            for (var i = 0; i < sportsman.length; i++) {
                var option = document.createElement("option");
                option.text = sportsman[i].name;
                option.value = sportsman[i].id;
                selector.add(option);
            }
        });
    });

    this.update_request = function add() {
        var index = document.getElementById("Sportsman").selectedIndex;
        sportsman_id= document.getElementById("Sportsman").options[index].value;
        $http.get('http://localhost:8080/api/request5?sportsman_id='+sportsman_id).then(function (response){
            $scope.request5=response.data;
            console.log(response);
        });
    };
});