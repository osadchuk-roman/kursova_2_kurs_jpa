var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request6_2 = [];
    var date1='2017-01-01';
    var date2='2019-01-01';
    var organizer_id=1;
    $http.get('http://localhost:8080/api/request6_2?firstDate='+date1+'&secondDate='+date2
        +'&organizer_id='+organizer_id).then(function (response){
            $scope.request6_2=response.data;
            console.log(response);
            $http.get('/api/organizer').then(function (response){
                var organizer = response.data;
                var selector = document.getElementById("Organizer");
                $(selector).empty();
                for (var i = 0; i < organizer.length; i++) {
                    var option = document.createElement("option");
                    option.text = organizer[i].name;
                    option.value = organizer[i].id;
                    selector.add(option);
                }
                selector.selectedIndex=0;
            });
            document.getElementById("FirstDate").value=date1;
            document.getElementById("SecondDate").value=date2;
        });

    this.update_request = function add() {
        var index = document.getElementById("Organizer").selectedIndex;
        organizer_id= document.getElementById("Organizer").options[index].value;
        date1= document.getElementById("FirstDate").value;
        date2= document.getElementById("SecondDate").value;
        var isValid=true;
        var errorMessage='Помилка: неправильні вхідні дані!\n';
        var regex=/^20[0-9][0-9]-((0[1-9])|(1[0-2]))-((0[1-9])|([12][0-9])|(3[01]))$/ ;
        if(!regex.test(date1)||!regex.test(date2)){
            errorMessage=errorMessage+'-невірний формат дати змагання;\n';
            errorMessage=errorMessage+'Потріббний формат yyyy-mm-dd (рік-місяць-день);';
            isValid=false;
        }
        if (isValid){

            $http.get('http://localhost:8080/api/request6_2?firstDate='+date1+'&secondDate='+date2
                +'&organizer_id='+organizer_id).then(function (response){
                $scope.request6_2=response.data;
                console.log(response);
            });
        }
        else window.alert(errorMessage);
    };
});