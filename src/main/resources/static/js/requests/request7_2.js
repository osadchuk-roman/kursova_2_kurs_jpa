var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request7 = [];
    var competition_id=1;
    $http.get('http://localhost:8080/api/request7_2?competition_id='+competition_id)
        .then(function (response){
            $scope.request7=response.data;
            console.log(response);
            $http.get('/api/competition').then(function (response){
                var competition = response.data;
                var selector = document.getElementById("Competition");
                $(selector).empty();
                for (var i = 0; i < competition.length; i++) {
                    var option = document.createElement("option");
                    option.text = competition[i].name;
                    option.value = competition[i].id;
                    selector.add(option);
                }
                selector.selectedIndex=0;
            });
        });

    this.update_request = function add() {
        var index = document.getElementById("Competition").selectedIndex;
        competition_id= document.getElementById("Competition").options[index].value;
        $http.get('http://localhost:8080/api/request7_2?competition_id='+competition_id)
            .then(function (response){
                $scope.request7=response.data;
                console.log(response);
            });
    };
});