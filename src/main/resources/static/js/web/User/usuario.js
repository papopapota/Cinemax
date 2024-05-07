
let nombreTextField = document.querySelector('#nombreTextField');
let apellidoTextField = document.querySelector('#apellidoTextField');
let correoTextField = document.querySelector('#correoTextField');

let showNameSurname = document.querySelector('#showNameSurname');
let showEmail = document.querySelector('#showEmail');

nombreTextField.addEventListener('input' , function(){
    showNameSurname.textContent =  nombreTextField.value + ' ' + apellidoTextField.value;
});
apellidoTextField.addEventListener('input' , function(){
    showNameSurname.textContent =  nombreTextField.value + ' ' + apellidoTextField.value;
});
correoTextField.addEventListener('input' , function(){
    showEmail.textContent =  correoTextField.value;
});


window.addEventListener('beforeunload', function(event) {
    showNameSurname.textContent =  nombreTextField.value + ' ' + apellidoTextField.value;
    showEmail.textContent =  correoTextField.value;

});

