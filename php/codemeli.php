<?php

    if(isset($_POST['code'])){
        $meli = $_POST['code'];

        function checkMeliCode($meli) {
            $cDigitLast = substr($meli , strlen($meli)-1);
            $fMeli = strval(intval($meli));
         
            if((str_split($fMeli))[0] == "0" && !(8 <= strlen($fMeli)  && strlen($fMeli) < 10)) return false;
         
            $nineLeftDigits = substr($meli , 0 , strlen($meli) - 1);
           
            $positionNumber = 10;
            $result = 0;
         
            foreach(str_split($nineLeftDigits) as $chr){
                $digit = intval($chr);
                $result += $digit * $positionNumber;
                $positionNumber--;
            }
         
            $remain = $result % 11;
         
            $controllerNumber = $remain;
         
            if(2 < $remain){
            $controllerNumber = 11-$remain;
            }
         
            return $cDigitLast == $controllerNumber;
        }
        
        $meliResult = checkMeliCode($meli);
    }
    
    include 'index.php';
    
?>