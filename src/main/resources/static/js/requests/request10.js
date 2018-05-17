var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request10 = [];
    var sport_id=1;
    $http.get('http://localhost:8080/api/request10?sport_id='+sport_id).then(function (response){
        $scope.request10=response.data;
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
            selector.selectedIndex=0;
        });
    });

    this.update_request = function add() {
        var index = document.getElementById("Sport").selectedIndex;
        sport_id= document.getElementById("Sport").options[index].value;
        $http.get('http://localhost:8080/api/request10?sport_id='+sport_id).then(function (response){
            $scope.request10=response.data;
            console.log(response);
        });
    };
});