var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request3_3 = [];
    var sportClub_id=1;
    $http.get('http://localhost:8080/api/request3_3?sportClub_id='+sportClub_id).then(function (response){
        $scope.request3_3=response.data;
        console.log(response);
        $http.get('/api/sport_club').then(function (response){
            var sportClub = response.data;
            var selector = document.getElementById("SportClub");
            $(selector).empty();
            for (var i = 0; i < sportClub.length; i++) {
                var option = document.createElement("option");
                option.text = sportClub[i].name;
                option.value = sportClub[i].id;
                selector.add(option);
            }
            selector.selectedIndex=0;
        });
    });

    this.update_request = function add() {
        var index = document.getElementById("SportClub").selectedIndex;
        sportClub_id= document.getElementById("SportClub").options[index].value;
        $http.get('http://localhost:8080/api/request3_3?sportClub_id='+sportClub_id).then(function (response){
            $scope.request3_3=response.data;
            console.log(response);
        });
    };
});