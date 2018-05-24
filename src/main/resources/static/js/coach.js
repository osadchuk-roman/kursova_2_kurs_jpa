var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope) {

    $scope.coach = [];
    $http.get('http://localhost:8080/api/coach').then(function (response){
        $scope.coach=response.data;
        console.log(response);
    });
    this.del_coach= function del(id) {
        $http.get('/api/coach/del?id='+id).then(function (response){
            window.location.reload();
            window.alert('Тренера  було успішно видалено!');
        });
    };

    this.start_insert_coach = function add() {

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
        });

    };

    this.insert_coach = function add() {
        var name = document.getElementById("Name").value;
        var indexOfSportClub = document.getElementById("SportClub").selectedIndex;
        var sportClubId = document.getElementById("SportClub").options[indexOfSportClub].value;
        var isValid=true;
        var regex=/^[А-ЯІ][а-яі]+\s[А-ЯІ]\.\s?[А-ЯІ]\.$/ ;
        var errorMessage='Помилка: неправильні вхідні дані!\n';
        if(!regex.test(name)){
            errorMessage=errorMessage+'-невірний формат прізвища та ініціалів тренера;';
            isValid=false;
        }
        if(isValid){
            $http.get('/api/coach/insert?name='+name+'&sportClubId='+sportClubId).then(function (response){
                window.location.reload();
                window.alert('Тренера було успішно додано!');
            });
        }
        else  window.alert(errorMessage);

    };
    var thisId;

    this.start_update_coach = function upd(id,name,sportClubName) {
        thisId=id;
        var  thisIndex;
        var  thisName;
        $http.get('/api/sport_club').then(function (response){
            var sportClub = response.data;
            var selector = document.getElementById("SportClubUPD");
            $(selector).empty();
            for (var i = 0; i < sportClub.length; i++) {
                var option = document.createElement("option");
                option.text = sportClub[i].name;
                option.value = sportClub[i].id;
                if(sportClub[i].name==sportClubName)
                {
                    thisIndex = i;
                    thisName=sportClub[i].name;

                }
                selector.add(option);
            }

            document.getElementById("SportClubUPD").selectedIndex=thisIndex;
        });
        document.getElementById("NameUPD").value=name;

    };
    this.update_coach = function upd() {
        var name = document.getElementById("NameUPD").value;
        var indexOfSportClub = document.getElementById("SportClubUPD").selectedIndex;
        var sportClubId = document.getElementById("SportClubUPD").options[indexOfSportClub].value;
        //var gender = document.getElementById("GenderUPD").value;

        var isValid=true;
        var regex=/^[А-ЯІ][а-яі]+\s[А-ЯІ]\.\s?[А-ЯІ]\.$/ ;
        var errorMessage='Помилка: неправильні вхідні дані!\n';
        if(!regex.test(name)){
            errorMessage=errorMessage+'-невірний формат прізвища та ініціалів тренера;';
            isValid=false;
        }
        if(isValid) {
            $http.get('/api/coach/update?id=' + thisId + '&name=' + name + '&sportClubId=' + sportClubId).then(function (response) {
                window.location.reload();
            });
        }
        else window.alert(errorMessage);

    };
});