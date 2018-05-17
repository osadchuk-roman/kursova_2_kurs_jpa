var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request3_1 = [];
    var coach_id=8;
    $http.get('http://localhost:8080/api/request3_1?coach_id='+coach_id).then(function (response){
        $scope.request3_1=response.data;
        console.log(response);
        $http.get('/api/coach').then(function (response){
            var coach = response.data;
            var selector = document.getElementById("Coach");
            $(selector).empty();
            for (var i = 0; i < coach.length; i++) {
                var option = document.createElement("option");
                option.text = coach[i].name;
                option.value = coach[i].id;
                selector.add(option);
            }
        });
    });

    this.update_request = function add() {
        var index = document.getElementById("Coach").selectedIndex;
        coach_id= document.getElementById("Coach").options[index].value;
        $http.get('http://localhost:8080/api/request3_1?coach_id='+coach_id).then(function (response){
            $scope.request3_1=response.data;
            console.log(response);
        });
    };
});