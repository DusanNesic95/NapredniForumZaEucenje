var app = angular.module('NFE', ['ngRoute', 'ngStorage']);

app.config(['$routeProvider', function($routeProvider) {
	$routeProvider
	.when('/home', {
		controller: 'homeController',
		templateUrl: 'home.html'
	})
	.when('/homeprofesor', {
		controller: 'homeProfesorController',
		templateUrl: 'homeProfesor.html'
	})
	.when('/homeadmin', {
		controller: 'homeAdminController',
		templateUrl: 'homeAdmin.html'
	})
	.when('/predmetprikaz', {
		controller: 'predmetPrikazController',
		templateUrl: 'predmetPrikaz.html'
	})
	.when('/predmetprikazstudent', {
		controller: 'predmetPrikazStudentController',
		templateUrl: 'predmetPrikazStudent.html'
	})
	.when('/predmetforma', {
		controller: 'predmetFormaController',
		templateUrl: 'predmetForma.html'
	})
	.when('/dodelaprofesora', {
		controller: 'dodelaProfesoraController',
		templateUrl: 'dodelaProfesora.html'
	})
	.when('/odaberistudente', {
		controller: 'odaberiStudenteController',
		templateUrl: 'odaberiStudente.html'
	})
	//Milicin deo
	.when('/korisnikprikaz', {
		controller: 'korisnikPrikazController',
		templateUrl: 'korisnikPrikaz.html'
	})
	.when('/korisnikforma', {
		controller: 'korisnikFormaController',
		templateUrl: 'korisnikForma.html'
	})
	.when('/blokiranje', {
		controller: 'blokiranjeController',
		templateUrl: 'blokiranje.html'
	})
	.when('/materijalprikaz', {
		controller: 'materijalPrikazController',
		templateUrl: 'materijalPrikaz.html'
	})
	.when('/materijalprikazadmin', {
		controller: 'materijalPrikazAdminController',
		templateUrl: 'materijalPrikazAdmin.html'
	})
	.when('/materijalprikazstampanje', {
		controller: 'materijalPrikazStampanjeController',
		templateUrl: 'materijalPrikazStampanje.html'
	})
	.when('/materijalprikazstudent', {
		controller: 'materijalPrikazStudentController',
		templateUrl: 'materijalPrikazStudent.html'
	})
	.when('/materijalprikazprofesor', {
		controller: 'materijalPrikazProfesorController',
		templateUrl: 'materijalPrikazProfesor.html'
	})
	.when('/temaprikaz', {
		controller: 'temaPrikazController',
		templateUrl: 'temaPrikaz.html'
	})
	.when('/temaprikazstudent', {
		controller: 'temaPrikazStudentController',
		templateUrl: 'temaPrikazStudent.html'
	})
	.when('/temaforma', {
		controller: 'temaFormaController',
		templateUrl: 'temaForma.html'
	})
	.when('/generisanjematerijalaforma', {
		controller: 'generisanjeMaterijalaFormaController',
		templateUrl: 'generisanjeMaterijalaForma.html'
	})
	.when('/materijalforma', {
		controller: 'materijalFormaController',
		templateUrl: 'materijalForma.html'
	});
}]);
