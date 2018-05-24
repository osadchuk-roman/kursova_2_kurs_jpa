var app = angular.module("kursova", [])



app.controller("AppCtrl", function ($http, $scope) {

    $scope.kind_of_sport = [];
    $http.get('http://localhost:8080/api/kind_of_sport').then(function (response){
        $scope.kind_of_sport=response.data;
        console.log(response);
    });
    this.del_kind_of_sport= function del(id) {
        $http.get('/api/kind_of_sport/del?id='+id).then(function (response){
            //  $http.get('http://localhost:8080/api/students').then(function (response){
            // $scope.students=response.data;
            window.alert('Вид спорту  був успішно видалений!');
            window.location.reload();
        });
    };

    this.insert_kind_of_sport = function add() {
        var name = document.getElementById("sportName").value;

        var isValid=true;
        var regex=/^([а-я]|[і])+$/ ;
        var errorMessage='Помилка: неправильні вхідні дані!\n';
        if(!regex.test(name)){
            errorMessage=errorMessage+'-невірний формат назви вида спорту;';
            isValid=false;
        }
        if(isValid){
            $http.get('/api/kind_of_sport/insert?name='+name).then(function (response){
                //  $http.get('http://localhost:8080/api/students').then(function (response){
                // $scope.students=response.data;
                window.alert('Вид спорту був успішно доданий!');
                window.location.reload();
            });
        }
        else window.alert()

    };
    var idSport;
    this.start_update_kind_of_sport = function updt(id,name) {
        idSport=id;
        document.getElementById("sportNameUPD").value=name;
    };
    this.update_kind_of_sport = function upd() {
        var name = document.getElementById("sportNameUPD").value;
        var isValid=true;
        var regex=/^([а-я]|[і])+$/ ;
        var errorMessage='Помилка: неправильні вхідні дані!\n';
        if(!regex.test(name)){
            errorMessage=errorMessage+'-невірний формат назви вида спорту;';
            isValid=false;
        }
        if(isValid) {
            $http.get('/api/kind_of_sport/update?id=' + idSport + '&name=' + name).then(function (response) {
                //  $http.get('http://localhost:8080/api/students').then(function (response){
                // $scope.students=response.data;
                //window.alert('Вид спорту "' + response.data.name + '" був успішно доданий!');
                window.location.reload();
            });
        }
        else window.alert(errorMessage);

    };
});