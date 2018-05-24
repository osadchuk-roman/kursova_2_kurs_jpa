var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope) {

    $scope.type_of_cover = [];
    $http.get('http://localhost:8080/api/type_of_cover').then(function (response){
        $scope.type_of_cover=response.data;
        console.log(response);
    });
    this.del_type_of_cover= function del(id) {
        $http.get('/api/type_of_cover/del?id='+id).then(function (response){
            window.alert('Вид поктриття  було успішно видалено!');
            window.location.reload();
        });
    };
    this.insert_type_of_cover = function add() {
        var name = document.getElementById("typeName").value;

        var errorMessage='Помилка: неправильні вхідні дані!\n';
        var isValid=true;
        var regex = /^[А-Яа-яІі]+$/;
        if(!regex.test(name)){
            errorMessage=errorMessage+'-невірний формат назви типу покриття;\n';
            isValid=false;
        }
        if(isValid){
            $http.get('/api/type_of_cover/insert?name='+name).then(function (response){
                window.alert('Вид поктриття був успішно доданий!');
                window.location.reload();
            });
        }
        else window.alert(errorMessage);
    };
    var thisId;
    this.start_update_type_of_cover = function upd(id,name) {
        thisId=id;
        document.getElementById("typeNameUPD").value=name;
    };
    this.update_type_of_cover = function upd() {
        var name = document.getElementById("typeNameUPD").value;

        var errorMessage='Помилка: неправильні вхідні дані!\n';
        var isValid=true;
        var regex = /^[А-Яа-яІі]+$/;
        if(!regex.test(name)){
            errorMessage=errorMessage+'-невірний формат назви типу покриття;\n';
            isValid=false;
        }
        if(isValid) {
            $http.get('/api/type_of_cover/update?id=' + thisId + '&name=' + name).then(function (response) {
                window.location.reload();
            });
        }
        else window.alert(errorMessage);

    };
});