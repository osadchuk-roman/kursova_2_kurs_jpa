var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request1_1 = [];
    var type_id=1;
    $http.get('http://localhost:8080/api/request1_1?type_id='+type_id).then(function (response){
        $scope.request1_1=response.data;
        console.log(response);
        $http.get('/api/type_of_sport_building').then(function (response){
            var types = response.data;
            var selector = document.getElementById("TypeOfSportBuilding");
            $(selector).empty();
            for (var i = 0; i < types.length; i++) {
                var option = document.createElement("option");
                option.text = types[i].name;
                option.value = types[i].id;
                selector.add(option);
            }
        });
    });

    this.update_request = function add() {
        var indexOfType = document.getElementById("TypeOfSportBuilding").selectedIndex;
        type_id= document.getElementById("TypeOfSportBuilding").options[indexOfType].value;
        $http.get('http://localhost:8080/api/request1_1?type_id='+type_id).then(function (response){
            $scope.request1_1=response.data;
            console.log(response);
        });
    };
});