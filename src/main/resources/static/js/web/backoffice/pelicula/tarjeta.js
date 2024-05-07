$(document).on("click", "#btnguardar", function(event) {
    event.preventDefault();
    $.ajax({
        type: "POST",
        url: "/tarjeta/registrar",
        contentType: "application/json", // Especificar el tipo de contenido como JSON
        data: JSON.stringify({  // Convertir los datos a formato JSON
            id_usuario: $("#idUsuario").val(),
            idtarjeta: $("#hddtarcod").val(),
            numerotarjeta: $("#numerotarjeta").val(),
            fechaexpiracion: $("#fechaexpiracion").val(),
            cvv: $("#cvv").val()
        }),
        success: function(resultado) {
            alert(resultado.mensaje);
            location.reload();
        }
    });
});

$(document).on("click", "#btnguardar1", function(event) {
    event.preventDefault();
    $.ajax({
        type: "POST",
        url: "/tarjeta/registrar",
        contentType: "application/json", // Especificar el tipo de contenido como JSON
        data: JSON.stringify({  // Convertir los datos a formato JSON
            idtarjeta: $("#hddtarcod").val(),
            numerotarjeta: $("#txtnumerotarjeta").val(),
            fechaexpiracion: $("#txtfechaexpiracion").val(),
            cvv: $("#txtcvv").val()
        }),
        success: function(resultado) {
            alert(resultado.mensaje);
            location.reload();
        }
    });
    $("#modaltarjeta").modal("hide");
});


$(document).on("click", ".btnactualizar", function(){
    $("#hddtarcod").val($(this).attr("data-tarcod"));
    $("#txtnumerotarjeta").val($(this).attr("data-tarnumerotarjeta"));
    $("#txtfechaexpiracion").val($(this).attr("data-tarfechaexpiracion"));
    $("#txtcvv").val($(this).attr("data-tarcvv"));

    $("#modaltarjeta").modal("show");
});

$(document).on("click", ".btneliminar", function() {
    var tarjetaId = $(this).data("tarcod");
    if (confirm("¿Estás seguro de que quieres eliminar esta película?")) {
        $.ajax({
            type: "DELETE",
            url: "/tarjeta/eliminar/" + tarjetaId,
            success: function() {
                // Recargar la página o actualizar la tabla después de eliminar
                // Por ejemplo:
                location.reload();
            },
            error: function(xhr, status, error) {
                console.error("Error al eliminar la película:", error);
            }
        });
    }
});
