var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope) {

    $scope.sport_category = [];
    $http.get('http://localhost:8080/api/sport_category').then(function (response){
        $scope.sport_category=response.data;
        console.log(response);
    });
    this.del_sport_category= function del(id) {
        $http.get('/api/sport_category/del?id='+id).then(function (response){
            window.alert('Спортивну категорію було успішно видалено!');
            window.location.reload();
        });
    };
    this.insert_sport_category = function add() {
        var name = document.getElementById("Name").value;
        var errorMessage='Помилка: неправильні вхідні дані!\n';
        var isValid=true;
        var regex = /^[А-Яа-яІі\s]+$/
        if(!regex.test(name)){
            errorMessage=errorMessage+'-невірний формат назви спортивного розряду;';
            isValid=false;
        }
        if(isValid){
            $http.get('/api/sport_category/insert?name='+name).then(function (response){
                window.alert('Спортивну категорію було успішно додано!');
                window.location.reload();
            });
        }
        else window.alert(errorMessage);

    };
    var thisId;
    this.start_update_sport_category = function upd(id,name) {
        thisId=id;
        document.getElementById("NameUPD").value=name;
    };
    this.update_sport_category = function upd() {
        var name = document.getElementById("NameUPD").value;
        var errorMessage='Помилка: неправильні вхідні дані!\n';
        var isValid=true;
        var regex = /^[А-Яа-яІі\s]+$/
        if(!regex.test(name)){
            errorMessage=errorMessage+'-невірний формат назви спортивного розряду;';
            isValid=false;
        }
        if(isValid) {
            $http.get('/api/sport_category/update?id=' + thisId + '&name=' + name).then(function (response) {
                window.location.reload();
            });
        }
        else window.alert(errorMessage);

    };
});