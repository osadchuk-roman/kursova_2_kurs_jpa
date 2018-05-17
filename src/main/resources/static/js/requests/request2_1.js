var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request2_1 = [];
    var sport_id=1;
    $http.get('http://localhost:8080/api/request2_1?sport_id='+sport_id).then(function (response){
        $scope.request2_1=response.data;
        console.log(response);
        $http.get('/api/kind_of_sport').then(function (response){
            var sport = response.data;
            var selector = document.getElementById("Sport");
            $(selector).empty();
            for (var i = 0; i < sport.length; i++) {
                var option = document.createElement("option");
                option.text = sport[i].name;
                option.value = sport[i].id;
                selector.add(option);
            }
        });
    });

    this.update_request = function add() {
        var indexOfType = document.getElementById("Sport").selectedIndex;
        sport_id= document.getElementById("Sport").options[indexOfType].value;
        $http.get('http://localhost:8080/api/request2_1?sport_id='+sport_id).then(function (response){
            $scope.request2_1=response.data;
            console.log(response);
        });
    };
});