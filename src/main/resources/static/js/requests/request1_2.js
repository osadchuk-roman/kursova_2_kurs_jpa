var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request1_2 = [];
    var type_id=1;
    var sport_id=4;
    $http.get('http://localhost:8080/api/request1_2?type_id='+type_id+'&sport_id='+sport_id)
        .then(function (response){
        $scope.request1_2=response.data;
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
                selector.selectedIndex=3;
            });
        });
    });

    this.update_request = function add() {
        var index = document.getElementById("TypeOfSportBuilding").selectedIndex;
        type_id= document.getElementById("TypeOfSportBuilding").options[index].value;

        var index = document.getElementById("Sport").selectedIndex;
        sport_id= document.getElementById("Sport").options[index].value;
        $http.get('http://localhost:8080/api/request1_2?type_id='+type_id+'&sport_id='+sport_id).then(function (response){
            $scope.request1_2=response.data;
            console.log(response);
        });
    };
});