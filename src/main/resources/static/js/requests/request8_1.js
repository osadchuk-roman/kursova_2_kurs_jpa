var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request8_1 = [];
    var building_id=2;
    $http.get('http://localhost:8080/api/request8_1?building_id='+building_id).
    then(function (response){
        $scope.request8_1=response.data;
        console.log(response);
        $http.get('/api/sport_building').then(function (response){
            var sport_building = response.data;
            var selector = document.getElementById("SportBuilding");
            $(selector).empty();
            for (var i = 0; i < sport_building.length; i++) {
                var option = document.createElement("option");
                option.text = sport_building[i].name;
                option.value = sport_building[i].id;
                selector.add(option);
            }
            selector.selectedIndex=1;
        });
    });

    this.update_request = function add() {
        var index = document.getElementById("SportBuilding").selectedIndex;
        building_id= document.getElementById("SportBuilding").options[index].value;
        $http.get('http://localhost:8080/api/request8_1?building_id='+building_id)
            .then(function (response){
                $scope.request8_1=response.data;
                console.log(response);
            });
    };
});