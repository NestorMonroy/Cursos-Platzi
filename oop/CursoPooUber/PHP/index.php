<?php
require_once("car.php");
require_once("uberX.php");
require_once("uberPool.php");
require_once("account.php");

// $car = new  Car('3awsasDFA',new Account('Joel','64565AasasS');

// $car->printDataCar();

$uberX = new UberX('vasqwe6', new Account('Joel','64565AasasS'), 'Chrevr', "Spartk");
$uberX->printDataCar();

$uberPool = new UberPool('asasa', new Account('Nestor','xas64565AasasS'), 'Otro', "Otro2");
$uberPool-> printDataCar();
?>