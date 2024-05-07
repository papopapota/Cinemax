

let butacasField = document.querySelector('#ButacasField');
let chairs = document.querySelectorAll('.chair');
let clase = 'chairSelected';
let claseQuitar = 'text-black-50';
var textoSillasCode = butacasField.value;
chairs.forEach(chair => {
    chair.addEventListener('click' , function(Event){
        if(chair.classList.contains(clase)){
            chair.classList.remove(clase);
            if(textoSillasCode == ""){
                textoSillasCode = textoSillasCode.replace(obtenerId(Event.target) , '');
            }
            else if(textoSillasCode == obtenerId(Event.target)){
                textoSillasCode = textoSillasCode.replace(obtenerId(Event.target) , '');
            }
            else if(textoSillasCode.includes("," +obtenerId(Event.target) )){
                textoSillasCode = textoSillasCode.replace("," +obtenerId(Event.target) , '');
            }else if(textoSillasCode.includes(obtenerId(Event.target)+ "," )){
                textoSillasCode = textoSillasCode.replace(obtenerId(Event.target)+"," , '');
            }else if (textoSillasCode.includes(obtenerId(Event.target) )){
                textoSillasCode = textoSillasCode.replace(obtenerId(Event.target) , '');
            }else if (textoSillasCode !=""){
                textoSillasCode = textoSillasCode.replace(obtenerId(Event.target) , '');
            }


        }else{
            chair.classList.add(clase);
            if(textoSillasCode.includes(obtenerId(Event.target))){

            }else{
                if(textoSillasCode == ""){
                    textoSillasCode += obtenerId(Event.target);
                }else{
                    textoSillasCode += ","+obtenerId(Event.target);
                }
            }

        }


        if(chair.classList.contains(clase)){
                chair.classList.remove(claseQuitar);

        }else{
            chair.classList.add(claseQuitar);
        }
        butacasField.value = textoSillasCode;
        CalcularCantidad(textoSillasCode);
        CalcularTotal(textoSillasCode);
    });
});

function obtenerId(divClickeado){
    id = divClickeado.querySelector('span').id;

    return id;
}



window.addEventListener('beforeunload', function(event) {
    butacasField.value = "";

});

function CalcularCantidad(textoSillasCode) {

    var array = [];
    let cantidadTextField = document.querySelector('#cantidadTextField');
    if(textoSillasCode != ""){
        array = textoSillasCode.split(',');
        cantidadTextField.value = array.length;
    }
    if(textoSillasCode == ""){
        cantidadTextField.value = "0";
    }
}

function CalcularTotal(textoSillasCode) {
    let cantidadTextField = document.querySelector('#cantidadTextField');
    let precioTextField = document.querySelector('#precioTextField');
    let totalTextField = document.querySelector('#totalTextField');

    let cantidad = parseInt( cantidadTextField.value);
    let precio = parseFloat( precioTextField.value);

    if(textoSillasCode != ""){

        totalTextField.value = cantidad * precio;
    }
    if(textoSillasCode == ""){
        totalTextField.value = "0";
    }
}