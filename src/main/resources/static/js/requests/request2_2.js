var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request2_2 = [];
    var sport_id=1;
    var category_id=6;
    $http.get('http://localhost:8080/api/request2_2?sport_id='+sport_id+'&category_id='+category_id).
    then(function (response){
        $scope.request2_2=response.data;
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
            $http.get('/api/sport_category').then(function (response){
                var sportCategory = response.data;
                var selector = document.getElementById("SportCategory");
                $(selector).empty();
                for (var i = 0; i < sportCategory.length; i++) {
                    var option = document.createElement("option");
                    option.text = sportCategory[i].name;
                    option.value = sportCategory[i].id;
                    selector.add(option);
                }
                selector.selectedIndex=5;
            });
        });
    });

    this.update_request = function add() {
        var index = document.getElementById("Sport").selectedIndex;
        sport_id= document.getElementById("Sport").options[index].value;
        index = document.getElementById("SportCategory").selectedIndex;
        category_id= document.getElementById("SportCategory").options[index].value;

        $http.get('http://localhost:8080/api/request2_2?sport_id='+sport_id+'&category_id='+category_id)
            .then(function (response){
            $scope.request2_2=response.data;
            console.log(response);
        });
    };
});