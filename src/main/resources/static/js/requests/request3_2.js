var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request3_2 = [];
    var coach_id=8;
    var category_id=6;
    $http.get('http://localhost:8080/api/request3_2?coach_id='+coach_id+'&category_id='+category_id)
        .then(function (response){
        $scope.request3_2=response.data;
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
        var index = document.getElementById("Coach").selectedIndex;
        coach_id= document.getElementById("Coach").options[index].value;

        index = document.getElementById("SportCategory").selectedIndex;
        category_id= document.getElementById("SportCategory").options[index].value;
        $http.get('http://localhost:8080/api/request3_2?coach_id='+coach_id+'&category_id='+category_id)
            .then(function (response){
            $scope.request3_2=response.data;
            console.log(response);
        });
    };
});