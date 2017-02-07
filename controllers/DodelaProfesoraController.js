app.controller('dodelaProfesoraController', ['$scope', 'funkcije', '$localStorage',
 function($scope, funkcije, $localStorage) {
	$scope.profesori = [];
	$scope.predmet = $localStorage.predmet;

	funkcije.ucitajsveprofesore()
	.success(function(response) {
		$scope.profesori = response;
		for (var i = 0; i < $scope.profesori.length; i++) {
			$('#profesoriSelect')
			.append($('<option>', {
    			value: $scope.profesori[i].korisnickoIme,
    			text: $scope.profesori[i].korisnickoIme
			}));
		}
	})
	.error(function() {
		alert("Nije moguće uspostaviti vezu sa serverom, pokušajte kasnije!");
	});

	$scope.dodeliProfesora = function() {
		var profesor = {};
		for (var i = 0; i < $scope.profesori.length; i++) {
			if ($("#profesoriSelect").val() == $scope.profesori[i].korisnickoIme) {
				profesor = $scope.profesori[i];
			}
		}

		var predmetProfesora = {
			korisnikId : profesor,
			predmetId : $scope.predmet
		}

		var data = JSON.stringify(predmetProfesora);
		$scope.izvrsiFunkciju(data);
	}

	$scope.izvrsiFunkciju = function(data) {
		funkcije.dodajpredmetkorisniku(data)
		.success(function() {
			alert("Uspešno ste dodelili predmet profesoru!");
			window.location = "#/predmetprikaz";
		})
		.error(function() {
			alert("Nije moguće uspostaviti vezu sa serverom, pokušajte kasnije!");
		});
	}

	$scope.nazad = function() {
		window.location = "#/predmetprikaz";
	}
}]);