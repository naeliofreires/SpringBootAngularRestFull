angular.module("listaContatos", []);

angular.module("listaContatos").controller("listaContatosCtrl", function ($scope, $http) {

    $scope.aplicacao = "Minha Lista Telefonica";

    $scope.contatos = [];

    carregarContatos = function () {
        $http.get("http://localhost:8080/contatos").then(function (response) {
            $scope.contatos = response.data;
            console.log($scope.contatos);
        });
    };

    carregarContatos();

    $scope.adicionarContato = function (contato) {
        $http.post("http://localhost:8080/contatos", contato).then(function (response) {
            delete $scope.contato;
            carregarContatos();
        }, function (response) {
            console.log("Response: " + response);
        });
    }

    $scope.deletarContato = function (contato) {

        $http.delete("http://localhost:8080/contatos/" + contato.id + "/delete").then(function (response) {
            delete $scope.contato;
            carregarContatos();
        }, function (response, status) {
            console.log("Status:" + status)
        });

    };

});