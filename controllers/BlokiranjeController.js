app.controller('blokiranjeController', ['$scope', 'funkcije', '$localStorage', 
	function($scope, funkcije, $localStorage) {
	$scope.korisnici = [];
	$scope.search = "";

	funkcije.svikorisnici().success(function(response) {
		$scope.korisnici = response;
	});

	$scope.blokiraj = function(korisnik) {
		var modal = confirm("Jeste li sigurni?");
		if (modal == true) {
			funkcije.obrisikorisnika(korisnik)
			.success(function() {
				window.location.reload();
			})
			.error(function() {
				alert("Došlo je do greške pri komunikaciji sa serverom, pokušajte kasnije!");
			});
		}
	}

}]);