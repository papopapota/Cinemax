$(document).on("click", "#btnagregar", function(){
    $("#txtnompelicula").val("");
    $("#txtdescpelicula").val("");
    $("#txturlimagen").val("");
    $("#hddpelicod").val("0");
    listarCboGenero(0,0);
    $("#txtduracion").val("");
    $("#txtestreno").val("");
    $("#txtidioma").val("");
    $("#txtdisponible").val("");
    $("#modalpelicula").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtnompelicula").val($(this).attr("data-pelititulo"));
    $("#txtdescpelicula").val($(this).attr("data-pelidescrip"));
    $("#hddpelicod").val($(this).attr("data-pelicod"));
    $("#cbopelicula").empty();
    listarCboGenero($(this).attr("data-peligenero"));
    $("#txtduracion").val($(this).attr("data-peliduracion"));
    $("#txtestreno").val($(this).attr("data-data-peliestreno"));
    $("#txtidioma").val($(this).attr("data-peliidioma"));
    $("#txtdisponible").val($(this).attr("data-pelidisp"));
    $("#modalpelicula").modal("show");
});

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/pelicula/registrar",
        contentType: "application/json",
        data: JSON.stringify({
            idpelicula: $("#hddpelicod").val(),
            titulo: $("#txtnompelicula").val(),
            descripcion: $("#txtdescpelicula").val(),
            imagen: $("#txturlimagen").val(),
            genero: $("#cbopelicula").val(),
            duracion: $("#txtduracion").val(),
            estreno: $("#txtestreno").val(),
            idioma: $("#txtidioma").val(),
            disponible: $("#txtdisponible").val()
        }),
        success: function(resultado){
            alert(resultado.mensaje)
        }
    });
    $("#modalpelicula").modal("hide");
});

function listarCboGenero(idgenero){
    $.ajax({
        type: "GET",
        url: "/genero/get",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cbopelicula").append(
                    `<option value="${value.idgenero}">${value.nom_genero}</option>`
                )
            });
            if(idgenero > 0){
                $("#cbopelicula").val(idgenero);
            }
        }
    })
}