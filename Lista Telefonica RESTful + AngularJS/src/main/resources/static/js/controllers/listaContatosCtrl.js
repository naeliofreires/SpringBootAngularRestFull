angular.module("listaContatos", []);

angular.module("listaContatos").controller("listaContatosCtrl", function ($scope, contatosAPI, contatosAPI_S) {

    $scope.aplicacao = "Minha Lista Telefonica";

    $scope.contatos = [];

    getContatos = function () {
        contatosAPI.getContatos().then(function (response) {
            $scope.contatos = response.data;
            console.log($scope.contatos);
        });
    };

    getContatos();

    $scope.adicionarContato = function (contato) {

        contatosAPI.saveContato(contato).then(function (response) {

            delete $scope.contato;
            getContatos();

        }, function (response) {
            console.log("Response: " + response);
        });
    }

    $scope.deletarContato = function (contato) {

       contatosAPI_S.deleteContato(contato).then(function (response) {

            delete $scope.contato;
            getContatos();

        }, function (response, status) {
            console.log("Status:" + status)
        });

    };

});