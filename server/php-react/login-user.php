<?php

$conn = mysqli_connect("localhost", "min", "alstlrdl1!", "react_php_crud");
$json_array = array();
$json_array = array(
    "success" => "ok"
);
echo json_encode($json_array, JSON_UNESCAPED_UNICODE + JSON_PRETTY_PRINT);


?>