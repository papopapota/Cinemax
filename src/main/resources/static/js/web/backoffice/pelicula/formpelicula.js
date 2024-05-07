$(document).on("click", "#btnagregar", function(){
    $("#txtnompelicula").val("");
    $("#txtdescpelicula").val("");
    $("#txturlimagen").val("");
    $("#hddpelicod").val("0");
    listarCboGenero(0,0);
    $("#txtduracion").val("");
    $("#txtidioma").val("");
    $("#cbpelienestreno").prop("checked", false);
    $("#modalpelicula").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtnompelicula").val($(this).attr("data-pelititulo"));
    $("#txtdescpelicula").val($(this).attr("data-pelidescrip"));
    $("#txturlimagen").val($(this).attr("data-peliimagen"));
    $("#hddpelicod").val($(this).attr("data-pelicod"));
    $("#cbopelicula").empty();
    listarCboGenero($(this).attr("data-peligenero"));
    $("#txtduracion").val($(this).attr("data-peliduracion"));
    $("#txtidioma").val($(this).attr("data-peliidioma"));
    if($(this).attr("data-pelienestreno") === "true"){
            $("#cbpelienestreno").prop("checked", true);
        }else
            $("#cbpelienestreno").prop("checked", false);
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
            idioma: $("#txtidioma").val(),
            enestreno: $("#cbpelienestreno").prop("checked")
        }),
        success: function(resultado){
            alert(resultado.mensaje)
            location.reload();
        }
    });
    $("#modalpelicula").modal("hide");
});



function listarCboGenero(idGenero){
    $.ajax({
        type: "GET",
        url: "/genero/get",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cbopelicula").append(
                    `<option value="${value.idGenero}">${value.nom_genero}</option>`
                )
            });
            if(idGenero > 0){
                $("#cbopelicula").val(idGenero);
            }
        }
    })
}

$(document).on("click", ".btneliminar", function() {
    var peliculaId = $(this).data("pelicod");
    if (confirm("¿Estás seguro de que quieres eliminar esta película?")) {
        $.ajax({
            type: "DELETE",
            url: "/pelicula/eliminar/" + peliculaId,
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