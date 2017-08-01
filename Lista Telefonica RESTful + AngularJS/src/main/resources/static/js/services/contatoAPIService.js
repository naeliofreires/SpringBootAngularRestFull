angular.module("listaContatos").service("contatosAPI_S", function ($http, config) {

    this.deleteContato = function (contato) {
        return  $http.delete( config.baseUrl + "/contatos/" + contato.id + "/delete");
    };

});